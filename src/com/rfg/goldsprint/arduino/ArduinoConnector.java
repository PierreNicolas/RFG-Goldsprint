package com.rfg.goldsprint.arduino;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.TooManyListenersException;

import com.rfg.goldsprint.model.Race;
import com.rfg.goldsprint.properties.GoldSprintProperties;

public class ArduinoConnector extends Thread implements SerialPortEventListener {

	private volatile boolean arret;

	Race race;

	boolean rline = false;

	static CommPortIdentifier portId;
	static CommPortIdentifier saveportId;
	@SuppressWarnings({ "rawtypes" })
	static Enumeration portList;
	InputStream inputStream;
	SerialPort serialPort;
	Thread readThread;
	String rlinevalue = "";
	private String machinePort;
	static OutputStream outputStream;
	static boolean outputBufferEmptyFlag = false;

	public ArduinoConnector(Race race,String machinePort) {
		this.race = race;
		this.machinePort = machinePort;

		// initalize serial port

	}

	public void initwritetoport() {
		// initwritetoport() assumes that the port has already been opened and
		// initialized by "public nulltest()"

		try {
			// get the outputstream
			outputStream = serialPort.getOutputStream();
		} catch (IOException e) {
		}

		// try {
		// // activate the OUTPUT_BUFFER_EMPTY notifier
		// serialPort.notifyOnOutputEmpty(true);
		// } catch (Exception e) {
		// System.out.println("Error setting event notification");
		// System.out.println(e.toString());
		// System.exit(-1);
		// }

	}

	public void writetoport(char message) {
		// System.out.println("Writing \""+(int)message+"\" to "+serialPort.getName());
		try {
			// write string to serial port
			outputStream.write((int) message);
		} catch (IOException e) {
		}
	}

	public void run() {
		boolean portFound = false;
		String defaultPort;

		// determine the name of the serial port on several operating systems
		String osname = System.getProperty("os.name", "").toLowerCase();
		if (osname.startsWith("windows")) {
			// windows
			if (machinePort!= null) {
				defaultPort = machinePort;
			} else {
				defaultPort = "COM4";
			}
			
		} else if (osname.startsWith("linux")) {
			// linux
			defaultPort = "/dev/ttyUSB0";
		} else if (osname.startsWith("mac")) {
			// mac
			defaultPort = "????";
		} else {
			System.out.println("Sorry, your operating system is not supported");
			return;
		}

		System.out.println("Set default port to " + defaultPort);

		// parse ports and if the default port is found, initialized the reader
		portList = CommPortIdentifier.getPortIdentifiers();
		while (portList.hasMoreElements()) {
			portId = (CommPortIdentifier) portList.nextElement();
			if (portId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				if (portId.getName().equals(defaultPort)) {
					System.out.println("Found port: " + defaultPort);
					portFound = true;
					try {
						serialPort = (SerialPort) portId.open("SimpleReadApp",
								2000);
					} catch (PortInUseException e) {
					}

					try {
						inputStream = serialPort.getInputStream();
					} catch (IOException e) {
					}

					try {
						serialPort.addEventListener(this);
					} catch (TooManyListenersException e) {
					}

					// activate the DATA_AVAILABLE notifier
					serialPort.notifyOnDataAvailable(true);

					try {
						// set port parameters
						serialPort.setSerialPortParams(115200,
								SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
								SerialPort.PARITY_NONE);
					} catch (UnsupportedCommOperationException e) {
					}

				}
			}

		}
		if (!portFound) {
			System.out.println("port " + defaultPort + " not found.");
		}

		System.out.println("lauchn");
		// first thing in the thread, we initialize the write operation
		initwritetoport();

		while (!arret) {
			try {
				if (race.isStartRaceAction()) {
					System.out.println("Start");
					if (race.isMockModeAction()) {
						writetoport('m');
					}
					if (race.isFsModeAction()) {
						writetoport('f');
					}
					int ticks1 = (int) (race.getDistanceOfRace() / race
							.getPlayer1RP().getPlayer().getDevelopment());
					//System.out.println("Number of tick to reach distance 1 :" + ticks1);
					int ticks2 = (int) (race.getDistanceOfRace() / race
							.getPlayer2RP().getPlayer().getDevelopment());
					//System.out.println("Number of tick to reach distance 2 :" + ticks2);

					writetoport('i');
					writetoport((char) ((ticks1 % 256)+1));
					writetoport((char) (ticks1 / 256));
					writetoport('&');
					writetoport('j');

					writetoport((char) ((ticks2 % 256)+1));
					writetoport((char) (ticks2 / 256));
					writetoport('&');
					writetoport('g');
					race.setStartRaceAction(false);
				}
				if (race.isStopRaceAction()) {
					writetoport('s');
					if (race.isMockModeAction()) {
						writetoport('m');
					}
					if (race.isFsModeAction()) {
						writetoport('f');
					}
					race.setStopRaceAction(false);
				}
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void sortir() {
		arret = true;
		this.close();
	}

	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	public void interpreter(char chara) {

		if (chara == '^' && rline) {
			// rlinevalue += chara;
			interpreterAction(rlinevalue);

			//System.out.println("rline :" + rlinevalue);
			rline = false;
			rlinevalue = "";
		} else if (rline) {
			rlinevalue += chara;
		} else if (chara == '@') {
			rline = true;
			// rlinevalue += chara;
		}
	}

	private synchronized void interpreterAction(String rlinevalue2) {

		// Timer Value
		if (rlinevalue2.charAt(0) == 'c') {
			race.updateRaceInfos(GoldSprintProperties.RACE_TIMER,
					rlinevalue2.substring(1, rlinevalue2.length()));
		}
		// finish Value
		else if (rlinevalue2.charAt(0) == 'f') {
			if (rlinevalue2.charAt(1) == '0') {
				race.updateRaceInfos(GoldSprintProperties.PLAYER1_FINISHTIME,
						rlinevalue2.substring(2, rlinevalue2.length()));
				if (race.getWinner() == null) {
					race.setWinner(race.getPlayer1RP().getPlayer());
				}

			} else if (rlinevalue2.charAt(1) == '1') {
				if (race.getWinner() == null) {
					race.setWinner(race.getPlayer2RP().getPlayer());
				}
				race.updateRaceInfos(GoldSprintProperties.PLAYER2_FINISHTIME,
						rlinevalue2.substring(2, rlinevalue2.length()));
			}
		}
		// Player distance
		else if (rlinevalue2.charAt(0) == 't') {
			if (rlinevalue2.charAt(1) == '0') {
				race.updateRaceInfos(GoldSprintProperties.PLAYER1_DISTANCE,
						rlinevalue2.substring(2, rlinevalue2.length()));
			} else if (rlinevalue2.charAt(1) == '1') {
				race.updateRaceInfos(GoldSprintProperties.PLAYER2_DISTANCE,
						rlinevalue2.substring(2, rlinevalue2.length()));
			}
			//Current number of tick	
			//System.out.println(rlinevalue2.substring(2, rlinevalue2.length()));
		}
		// last tick time / equivalent of speed
		else if (rlinevalue2.charAt(0) == 'l') {
			if (rlinevalue2.charAt(1) == '0') {
				race.updateRaceInfos(GoldSprintProperties.PLAYER1_SPEED,
						rlinevalue2.substring(2, rlinevalue2.length()));
			} else if (rlinevalue2.charAt(1) == '1') {
				race.updateRaceInfos(GoldSprintProperties.PLAYER2_SPEED,
						rlinevalue2.substring(2, rlinevalue2.length()));
			}
		}
		// Race Message
		if (rlinevalue2.charAt(0) == 'm') {
			race.updateRaceInfos(GoldSprintProperties.RACE_MESSAGE,
					rlinevalue2.substring(1, rlinevalue2.length()));

		}
		// Countdown message
		if (rlinevalue2.charAt(0) == 'r') {
			race.updateRaceInfos(GoldSprintProperties.RACE_COUNTDOWN,
					rlinevalue2.substring(1, rlinevalue2.length()));
		}

	}

	public void serialEvent(SerialPortEvent event) {
		switch (event.getEventType()) {
		case SerialPortEvent.BI:
		case SerialPortEvent.OE:
		case SerialPortEvent.FE:
		case SerialPortEvent.PE:
		case SerialPortEvent.CD:
		case SerialPortEvent.CTS:
		case SerialPortEvent.DSR:
		case SerialPortEvent.RI:
		case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
			break;
		case SerialPortEvent.DATA_AVAILABLE:

			// we get here if data has been received

			try {
				// read data
				int numBytes = 0;
				while (inputStream.available() > 0) {

					numBytes = inputStream.read();
					// System.out.println((char)numBytes);
					interpreter((char) numBytes);
				}

			} catch (IOException e) {

				break;
			}
		}
	}

}
