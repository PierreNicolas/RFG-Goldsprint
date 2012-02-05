package com.rfg.goldsprint.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.rfg.goldsprint.properties.InitProperties;

public class PlayerDisplayPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2937471634946226528L;
	
	private JLabel playerName;
	private JLabel distance;
	private JLabel speed; 
	private JLabel maxSpeed; 
	private JLabel finishtime;
	
	private JLabel distanceLabel;
	private JLabel speedLabel; 
	private JLabel maxSpeedLabel; 
	private JLabel finishtimeLabel;
	
	public PlayerDisplayPanel() {
		super();
		initComposant();
		this.setPreferredSize(new Dimension(200,560));
		this.setBackground(Color.white);
	}
	
	public void initComposant() {
	
	
	
	//this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));	;
	
	this.setLayout(new GridBagLayout());
	GridBagConstraints c = new GridBagConstraints();
	
	Font police = new Font(InitProperties.FONT, Font.BOLD, 25);
	Font police2 = new Font(InitProperties.FONT, Font.BOLD, 20);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 0;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	playerName = new JLabel("Player Name");
	playerName.setFont(police);
	playerName.setHorizontalAlignment(JLabel.LEFT);
	playerName.setPreferredSize(new Dimension(300, 30));
	this.add(playerName,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 1;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	distanceLabel = new JLabel("Distance");
	distanceLabel.setFont(police2);
	distanceLabel.setHorizontalAlignment(JLabel.LEFT);
	distanceLabel.setPreferredSize(new Dimension(300, 30));
	distanceLabel.setForeground(Color.GRAY);
	
	this.add(distanceLabel,c);
	
	distance = new JLabel("0 m");
	distance.setFont(police);
	distance.setHorizontalAlignment(JLabel.LEFT);
	distance.setPreferredSize(new Dimension(200, 30));

	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 2;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	this.add(distance,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 3;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	
	speedLabel = new JLabel("Speed");
	speedLabel.setFont(police2);
	speedLabel.setHorizontalAlignment(JLabel.LEFT);
	speedLabel.setPreferredSize(new Dimension(200, 30));
	speedLabel.setForeground(Color.GRAY);
	
	this.add(speedLabel,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 4;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	speed = new JLabel("0,00 Km/h");
	speed.setFont(police);
	speed.setHorizontalAlignment(JLabel.LEFT);
	speed.setPreferredSize(new Dimension(300, 30));

	this.add(speed,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 5;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	maxSpeedLabel = new JLabel("Max Speed");
	maxSpeedLabel.setFont(police2);
	maxSpeedLabel.setHorizontalAlignment(JLabel.LEFT);
	maxSpeedLabel.setPreferredSize(new Dimension(300, 30));
	maxSpeedLabel.setForeground(Color.GRAY);
	
	this.add(maxSpeedLabel,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 6;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	maxSpeed = new JLabel("0,00 Km/h");
	maxSpeed.setFont(police);
	maxSpeed.setHorizontalAlignment(JLabel.LEFT);
	maxSpeed.setPreferredSize(new Dimension(300, 30));

	this.add(maxSpeed,c);
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 7;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	
	
	finishtimeLabel = new JLabel("Finish Time");
	finishtimeLabel.setFont(police2);
	finishtimeLabel.setHorizontalAlignment(JLabel.LEFT);
	finishtimeLabel.setPreferredSize(new Dimension(300, 30));
	finishtimeLabel.setForeground(Color.GRAY);
	
	this.add(finishtimeLabel,c);
	
	
	
	c.fill = GridBagConstraints.WEST;
	c.gridx = 0;
	c.gridy = 8;
	c.anchor = GridBagConstraints.WEST;
	c.insets = new Insets(5, 5, 5, 5); // top padding
	
	finishtime = new JLabel("00:00:000");
	finishtime.setFont(police);
	finishtime.setHorizontalAlignment(JLabel.LEFT);
	finishtime.setPreferredSize(new Dimension(300, 30));
	
	this.add(finishtime,c);
	
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

	public void setPlayerColor(Color color){
		playerName.setForeground(color);
	}
	
	
}
