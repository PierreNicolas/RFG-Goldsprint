package com.rfg.goldsprint.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class RaceDisplayPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4904235081465062226L;

	protected int raceDistance;
	protected int player1Angle = 0;
	protected int player2Angle = 0;

	protected int lastAngle1 = 80;
	protected int lastAngle2 = 80;
	
	protected Color player1Color;
	protected Color player2Color;
	
	JLabel raceTimer;
	JLabel raceCountDown;

	public RaceDisplayPanel(int raceDistance,Color player1Color,Color player2Color) {
		super();
		this.raceDistance = raceDistance;
		this.player1Color = player1Color;
		this.player2Color = player2Color;
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		Font police = new Font("Arial", Font.BOLD, 40);

		raceTimer = new JLabel("00:00:000");
		raceTimer.setFont(police);
		raceTimer.setHorizontalAlignment(JLabel.CENTER);
		raceTimer.setPreferredSize(new Dimension(220, 30));

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 1;
		c.insets = new Insets(0, 0, 0, 0); // top padding

		this.add(raceTimer, c);

		raceCountDown = new JLabel("GO!");
		raceCountDown.setFont(police);
		raceCountDown.setHorizontalAlignment(JLabel.CENTER);
		raceCountDown.setPreferredSize(new Dimension(220, 30));

		c.fill = GridBagConstraints.CENTER;
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(100, 0, 0, 0); // top padding

		this.add(raceCountDown, c);

		this.setPreferredSize(new Dimension(560, 560));

	}

	@Override
	protected synchronized void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// dessin.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		
			g2d.setStroke(new BasicStroke(28));
			g2d.setPaint(Color.LIGHT_GRAY);
			g2d.drawArc(30, 30, 500, 500, 80, -340);

			g2d.setStroke(new BasicStroke(28));
			g2d.setPaint(Color.LIGHT_GRAY);
			g2d.drawArc(60, 60, 440, 440, 80, -340);

		try {

		g2d.setStroke(new BasicStroke(28));
		g2d.setPaint(player1Color);
		g2d.drawArc(30, 30, 500, 500, lastAngle1, player1Angle);

		g2d.setStroke(new BasicStroke(28));
		g2d.setPaint(player2Color);
		g2d.drawArc(60, 60, 440, 440, lastAngle2, player2Angle);
		 
        } finally {
            g2d.dispose();
        }
	}

	public void setAngle1(float distance) {
		refreshAngleValue1(distance);

	}

	public void refreshAngleValue1(float distance) {
		if(distance <= raceDistance){
		float currentdistance = distance;
		player1Angle = (int) (-340 * (currentdistance / (float) raceDistance));
		this.revalidate();
		}
	}

	public void setAngle2(float distance) {
		refreshAngleValue2(distance);
	}

	public void refreshAngleValue2(float distance) {
		if(distance <= raceDistance){
		float currentdistance = distance;
		player2Angle = (int) (-340 * (currentdistance / (float) raceDistance));
		this.revalidate();
		}
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
	 * @param racecountDown
	 *            the racecountDown to set
	 */
	public void setRaceCountDown(JLabel racecountDown) {
		this.raceCountDown = racecountDown;
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

	public Color getPlayer2Color() {
		return player2Color;
	}

	public void setPlayer2Color(Color player2Color) {
		this.player2Color = player2Color;
	}

	

	

}
