package com.rfg.goldsprint.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.rfg.goldsprint.controler.AbstractRaceControler;
import com.rfg.goldsprint.observer.Observer;
import com.rfg.goldsprint.properties.GoldSprintProperties;
import com.rfg.goldsprint.properties.InitProperties;
import com.rfg.goldsprint.view.extcomponent.ExpandPanel;
import com.rfg.goldsprint.view.listener.ResetListener;
import com.rfg.goldsprint.view.listener.StartListener;
import com.rfg.goldsprint.view.listener.StopListener;
import com.rfg.goldsprint.view.parameter.RaceParameterPanel;
import com.rfg.goldsprint.view.race.RaceDisplayPanel;

public class GoldsprintInterface extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2531733976519506102L;

	private JLayeredPane container;
	private ExpandPanel menuPane;
	private JPanel contentPane;

	private PlayerDisplayPanel player1Pane;
	private PlayerDisplayPanel player2Pane;
	private RaceDisplayPanel racePane;

	
	private long finishTime1 = 0;
	private long finishTime2 = 0;
	
	RaceParameterPanel raceParameterPanel;

	private JButton startBT;
	private JButton stopBT;
	private JButton resetBT;

	// Notre instance de notre objet contrôleur
	private AbstractRaceControler controler;

	public GoldsprintInterface(AbstractRaceControler controler) {

		this.setSize(1280, 720);
		this.setTitle("RFG - GOLDSPRINT V0");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.controler = controler;

		this.setBackground(Color.WHITE);
		initComposant();
		
		
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initComposant() {

		player1Pane = new PlayerDisplayPanel();
		player2Pane = new PlayerDisplayPanel();
		racePane = new RaceDisplayPanel(InitProperties.RACEDISTANCE,
				Color.BLUE, Color.RED);
		player1Pane.getPlayerName().setText(InitProperties.P1NAME);
		player2Pane.getPlayerName().setText(InitProperties.P2NAME);
		player1Pane.getPlayerName().setForeground(InitProperties.PLAYER1COLOR);
		player2Pane.getPlayerName().setForeground(InitProperties.PLAYER2COLOR);
		
		container = new JLayeredPane();
		container.setBounds(0, 0, 1280, 720);

		raceParameterPanel = new RaceParameterPanel(controler, player1Pane,
				player2Pane, racePane);

		menuPane = new ExpandPanel("RFG - GOLDSPRINT V0", raceParameterPanel);
		menuPane.setBounds(0, 0, 1280, 720);
		menuPane.setOpaque(false);
		container.add(menuPane);

		contentPane = new JPanel();
		contentPane.setBounds(0, 0, 1280, 720);
		contentPane.setBackground(Color.white);
		contentPane.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Font police = new Font("Arial", Font.BOLD, 20);
		
		Border line = new LineBorder(Color.WHITE);
		Border margin = new EmptyBorder(0, 0, 0, 0);
		Border compound = new CompoundBorder(line, margin);
		ImageIcon startIcon = new ImageIcon(getClass().getResource("/images/playback_play.png"));
		ImageIcon stopIcon = new ImageIcon(getClass().getResource("/images/playback_stop.png"));
		ImageIcon resetIcon = new ImageIcon(getClass().getResource("/images/refresh.png"));
		
		
		startBT = new JButton(startIcon);
		stopBT = new JButton(stopIcon);
		
		startBT.setFont(police);
		startBT.setHorizontalAlignment(JLabel.CENTER);
		startBT.setForeground(Color.BLACK);
		startBT.setBackground(Color.WHITE);
		startBT.setBorder(compound);
		startBT.addActionListener(new StartListener(controler, startBT, stopBT));
		
		
	
		stopBT.setFont(police);
		stopBT.setHorizontalAlignment(JLabel.CENTER);
		stopBT.setForeground(Color.BLACK);
		stopBT.setBackground(Color.WHITE);
		stopBT.setBorder(compound);
		stopBT.setEnabled(false);
		stopBT.addActionListener(new StopListener(controler, startBT, stopBT));

		resetBT = new JButton(resetIcon);
		resetBT.setFont(police);
		resetBT.setHorizontalAlignment(JLabel.CENTER);
		resetBT.setForeground(Color.BLACK);
		resetBT.setBackground(Color.WHITE);
		resetBT.setBorder(compound);
		resetBT.addActionListener(new ResetListener(controler,racePane.getDs1()));
		
		
		// container.add(raceTime, BorderLayout.NORTH);
		// container.add(raceMessage, BorderLayout.NORTH);
		// container.add(raceCountdown, BorderLayout.NORTH);
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		contentPane.add(player1Pane, c);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 0); // top padding
		contentPane.add(racePane, c);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		contentPane.add(player2Pane, c);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.add(resetBT);
		buttonPanel.add(startBT);
		buttonPanel.add(stopBT);
		
		contentPane.add(buttonPanel, c);

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		ImageIcon RFGIcon = new ImageIcon(getClass().getResource("/images/RFG.png"));
		JLabel RFGLabel = new JLabel(RFGIcon);
		
		contentPane.add(RFGLabel, c);
		
		container.add(contentPane);

	}

	// ************************************************
	// IMPLEMENTATION DU PATTERN OBSERVER
	// ************************************************
	public void update(String cpt, String str) {
		// not necessary might be remove later

		if (cpt.equals(GoldSprintProperties.RACE_COUNTDOWN)) {
			racePane.getDs1().getRaceCountDown().setText(str);
		}else 
		if (cpt.equals(GoldSprintProperties.RACE_MESSAGE)) {
			System.out.println("Message :"+str);
		}
	}

	public void update(String cpt, long str) {
		Long time = Long.valueOf(str);
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(time);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		int M = c.get(Calendar.MILLISECOND);

		
		String mZero = ""; 
		String sZero = ""; 
		String MZero = ""; 
		if (m < 10) {
			mZero = "0";
		}
		if (s < 10) {
			sZero = "0";
		}
		if (M < 10) {
			MZero = "0";
		}
		
		if (cpt.equals(GoldSprintProperties.RACE_TIMER)) {
			racePane.getDs1().getRaceTimer().setText(mZero +""+ m + ":"+ sZero + s + ":" + MZero + M);
		} else if (cpt.equals(GoldSprintProperties.PLAYER1_FINISHTIME)) {
			finishTime1 = time;
			player1Pane.getFinishtime().setText(mZero +""+ m + ":"+ sZero + s + ":" + MZero + M);
			racePane.getDs3().setAngle(racePane.getDs3().getRaceDistance());
			displayWinner();
			

		} else if (cpt.equals(GoldSprintProperties.PLAYER2_FINISHTIME)) {
			finishTime2 = time;
			player2Pane.getFinishtime().setText(mZero +""+ m + ":"+ sZero + s + ":" + MZero + M);
			racePane.getDs2().setAngle(racePane.getDs3().getRaceDistance());
			displayWinner();

		}
	}

	public void update(String cpt, int str) {

	}

	public void update(String cpt, float str) {

		DecimalFormat df = new DecimalFormat ( ) ; 
		df.setMaximumFractionDigits ( 2 ) ; //arrondi à 2 chiffres apres la virgules 
		df.setMinimumFractionDigits ( 2 ) ; 
		df.setDecimalSeparatorAlwaysShown ( true ) ; 
		String str2 =  df.format(str) ;
		if (cpt.equals(GoldSprintProperties.PLAYER1_SPEED)) {
			player1Pane.getSpeed().setText(str2 + " Km/h");
		}
		if (cpt.equals(GoldSprintProperties.PLAYER1_MAXSPEED)) {
			player1Pane.getMaxSpeed().setText(str2 + " Km/h");
		}
		if (cpt.equals(GoldSprintProperties.PLAYER1_DISTANCE)) {
			player1Pane.getDistance().setText(str2 + " m");
			racePane.getDs3().setAngle(str);
			this.repaint();
		}

		if (cpt.equals(GoldSprintProperties.PLAYER2_SPEED)) {
			player2Pane.getSpeed().setText(str2 + " Km/h");
		}
		if (cpt.equals(GoldSprintProperties.PLAYER2_MAXSPEED)) {
			player2Pane.getMaxSpeed().setText(str2 + " Km/h");
		}
		if (cpt.equals(GoldSprintProperties.PLAYER2_DISTANCE)) {
			player2Pane.getDistance().setText(str2 + " m");
			racePane.getDs2().setAngle(str);
			this.repaint();

		}
	}
	
	public void displayWinner(){
		if(finishTime1 > 0 && finishTime2 >0 ){
			
			Font winnerpolice = new Font("Arial", Font.BOLD, 30);
			racePane.getDs1().getRaceCountDown().setFont(winnerpolice);
			racePane.getDs1().getRaceCountDown().setBackground(Color.BLACK);
			racePane.getDs1().getRaceCountDown().setOpaque(true);
			racePane.getDs1().getRaceCountDown().setForeground(Color.WHITE);
			racePane.getDs1().getRaceCountDown().setBorder(new LineBorder(Color.WHITE));
			if(finishTime2 > finishTime1){
				racePane.getDs1().getRaceCountDown().setText(" Race win by "+player1Pane.getPlayerName().getText()+" in  "+player1Pane.getFinishtime().getText() +" ");
			}else if(finishTime2 < finishTime1){
				racePane.getDs1().getRaceCountDown().setText(" Race win by "+player2Pane.getPlayerName().getText()+" in  "+player2Pane.getFinishtime().getText() + " ");
			}else{
				racePane.getDs1().getRaceCountDown().setText("Draw Game!");
			}
			
		}
		
	}

}
