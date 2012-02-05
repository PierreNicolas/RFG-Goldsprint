package com.rfg.goldsprint.view.race;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class RaceDisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904235081465062226L;

	RaceDisplayLayer4 ds4;
	RaceDisplayLayer3 ds3;
	RaceDisplayLayer2 ds2;
	RaceDisplayLayer1 ds1;
	
	int raceDistance;
	Color player1Color;
	Color player2Color;

	public RaceDisplayPanel(int raceDistance,Color player1Color,Color player2Color) {
		super();
		this.raceDistance = raceDistance;
		this.player1Color = player1Color;
		this.player2Color = player2Color;
		this.setPreferredSize(new Dimension(560, 560));
		initPane();
	}

private void initPane() {
		
		this.setBackground(Color.WHITE);
		
		JLayeredPane layerHolder = new JLayeredPane(); 
		layerHolder.setPreferredSize(new Dimension(560,560));
		layerHolder.setOpaque(false);
		
		ds1 = new RaceDisplayLayer1();
		ds1.setBounds(0, 0, 560, 560);
		ds1.setOpaque(false);
		layerHolder.add(ds1);
		
		ds2 = new RaceDisplayLayer2(raceDistance,player2Color);
		ds2.setBounds(0, 0, 560, 560);
		ds2.setOpaque(false);
		layerHolder.add(ds2);
		
		ds3 = new RaceDisplayLayer3(raceDistance,player1Color);
		ds3.setBounds(0, 0, 560, 560);
		ds3.setOpaque(false);
		layerHolder.add(ds3);
		
		ds4 = new RaceDisplayLayer4();
		ds4.setBounds(0, 0, 560, 560);
		ds4.setOpaque(false);
		layerHolder.add(ds4);
		
		this.add(layerHolder);
		
	}

/**
 * @return the ds4
 */
public RaceDisplayLayer4 getDs4() {
	return ds4;
}

/**
 * @param ds4 the ds4 to set
 */
public void setDs4(RaceDisplayLayer4 ds4) {
	this.ds4 = ds4;
}

/**
 * @return the ds3
 */
public RaceDisplayLayer3 getDs3() {
	return ds3;
}

/**
 * @param ds3 the ds3 to set
 */
public void setDs3(RaceDisplayLayer3 ds3) {
	this.ds3 = ds3;
}

/**
 * @return the ds2
 */
public RaceDisplayLayer2 getDs2() {
	return ds2;
}

/**
 * @param ds2 the ds2 to set
 */
public void setDs2(RaceDisplayLayer2 ds2) {
	this.ds2 = ds2;
}

/**
 * @return the ds1
 */
public RaceDisplayLayer1 getDs1() {
	return ds1;
}

/**
 * @param ds1 the ds1 to set
 */
public void setDs1(RaceDisplayLayer1 ds1) {
	this.ds1 = ds1;
}
	
	

}
