package com.rfg.goldsprint.view.race;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaceDisplayLayer2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7268561932738949051L;

	protected int raceDistance;

	protected int player2Angle = 0;

	protected Color player2Color;

	JLabel raceTimer;
	JLabel raceCountDown;

	public RaceDisplayLayer2(int raceDistance, Color player2Color) {
		super();
		this.raceDistance = raceDistance;
		this.player2Color = player2Color;
	}

	@Override
	protected  void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
				0.5f));

		g2d.setStroke(new BasicStroke(28));
		g2d.setPaint(player2Color);
		g2d.drawArc(60, 60, 440, 440, 80, player2Angle);

	}

	public void setAngle(float distance) {
		refreshAngleValue(distance);
	}

	public void refreshAngleValue(float distance) {
		if(distance <= raceDistance){
			if (distance > 0) {
				player2Angle = (int) (-340 * (distance / (float) raceDistance));
			}else{
				player2Angle = 0;
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

	public Color getPlayer2Color() {
		return player2Color;
	}

	public void setPlayer2Color(Color player2Color) {
		this.player2Color = player2Color;
	}

}
