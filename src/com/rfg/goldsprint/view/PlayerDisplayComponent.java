package com.rfg.goldsprint.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;

public class PlayerDisplayComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2937471634946226528L;
	
	private JLabel playerName;
	private JLabel distance;
	private JLabel speed; 
	private JLabel maxSpeed; 
	private JLabel finishtime;
	
	public PlayerDisplayComponent() {
		super();
		initComposant();
		
	}
	
	public void initComposant() {
	
	GridLayout playerLayout = new GridLayout(0,1);
	this.setLayout(playerLayout);

	
	this.setBorder(BorderFactory.createLineBorder(Color.red, 4));	;
		
	Font police = new Font("Arial", Font.BOLD, 20);
	
	playerName = new JLabel("");
	playerName.setFont(police);
	playerName.setHorizontalAlignment(JLabel.CENTER);
	playerName.setPreferredSize(new Dimension(100, 20));
	
	distance = new JLabel("0,00 m");
	distance.setFont(police);
	distance.setHorizontalAlignment(JLabel.CENTER);
	distance.setPreferredSize(new Dimension(100, 20));

	speed = new JLabel("0,00 Km/h");
	speed.setFont(police);
	speed.setHorizontalAlignment(JLabel.CENTER);
	speed.setPreferredSize(new Dimension(100, 20));

	maxSpeed = new JLabel("0,00 Km/h");
	maxSpeed.setFont(police);
	maxSpeed.setHorizontalAlignment(JLabel.CENTER);
	maxSpeed.setPreferredSize(new Dimension(100, 20));

	finishtime = new JLabel("00:00:000");
	finishtime.setFont(police);
	finishtime.setHorizontalAlignment(JLabel.CENTER);
	finishtime.setPreferredSize(new Dimension(100, 20));
	
	this.add(playerName);
	this.add(distance);
	this.add(speed);
	this.add(maxSpeed);
	this.add(finishtime);
	
	}

	/**
	 * @return the playerName
	 */
	public JLabel getPlayerName() {
		return playerName;
	}

	/**
	 * @param playerName the playerName to set
	 */
	public void setPlayerName(JLabel playerName) {
		this.playerName = playerName;
	}

	/**
	 * @return the distance
	 */
	public JLabel getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(JLabel distance) {
		this.distance = distance;
	}

	/**
	 * @return the speed
	 */
	public JLabel getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(JLabel speed) {
		this.speed = speed;
	}

	/**
	 * @return the maxSpeed
	 */
	public JLabel getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed the maxSpeed to set
	 */
	public void setMaxSpeed(JLabel maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @return the finishtime
	 */
	public JLabel getFinishtime() {
		return finishtime;
	}

	/**
	 * @param finishtime the finishtime to set
	 */
	public void setFinishtime(JLabel finishtime) {
		this.finishtime = finishtime;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}
	
}
