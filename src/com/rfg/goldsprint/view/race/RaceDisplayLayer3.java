package com.rfg.goldsprint.view.race;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RaceDisplayLayer3 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904235081465062226L;

	protected int raceDistance;
	protected int player1Angle = 0;

	protected Color player1Color;

	public RaceDisplayLayer3(int raceDistance,Color player1Color) {
		super();
		this.raceDistance = raceDistance;
		this.player1Color = player1Color;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
	
		g2d.setStroke(new BasicStroke(28));
		g2d.setPaint(player1Color);
		g2d.drawArc(30, 30, 500, 500, 80, player1Angle);

	}

	public void setAngle(float distance) {
		refreshAngleValue(distance);

	}

	public void refreshAngleValue(float distance) {
		if(distance <= raceDistance){
		if (distance > 0) {
			player1Angle = (int) (-340 * (distance / (float) raceDistance));
		}else{
			player1Angle = 0;
		}
		this.revalidate();
		}
	}

	public int getRaceDistance() {
		return raceDistance;
	}

	public void setRaceDistance(int raceDistance) {
		this.raceDistance = raceDistance;
	}

	public Color getPlayer1Color() {
		return player1Color;
	}

	public void setPlayer1Color(Color player1Color) {
		this.player1Color = player1Color;
	}
}
