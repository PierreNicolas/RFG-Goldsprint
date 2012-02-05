package com.rfg.goldsprint.view.race;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaceDisplayLayer1 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904235081465062226L;

	
	JLabel raceTimer;
	JLabel raceCountDown;

	public RaceDisplayLayer1() {
		super();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Font police = new Font("Arial", Font.BOLD, 40);

		raceTimer = new JLabel("00:00:000");
		raceTimer.setFont(police);
		raceTimer.setHorizontalAlignment(JLabel.CENTER);
		raceTimer.setPreferredSize(new Dimension(400, 50));

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		this.add(raceTimer, c);

		raceCountDown = new JLabel("");
		raceCountDown.setFont(police);
		raceCountDown.setHorizontalAlignment(JLabel.CENTER);
		raceCountDown.setPreferredSize(new Dimension(560, 50));
		
		
		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(100, 0, 0, 0); // top padding

		this.add(raceCountDown, c);
	}

	
	/**
	 * @return the raceTimer
	 */
	public JLabel getRaceTimer() {
		return raceTimer;
	}

	/**
	 * @param raceTimer
	 *            the raceTimer to set
	 */
	public void setRaceTimer(JLabel raceTimer) {
		this.raceTimer = raceTimer;
	}

	/**
	 * @return the racecountDown
	 */
	public JLabel getRaceCountDown() {
		return raceCountDown;
	}


	/**
	 * @param raceCountDown the raceCountDown to set
	 */
	public void setRaceCountDown(JLabel raceCountDown) {
		this.raceCountDown = raceCountDown;
	}
	
	

}
