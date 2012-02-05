package com.rfg.goldsprint.view.race;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RaceDisplayLayer4 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8100173998453501000L;

	public RaceDisplayLayer4() {
		super();
	}

	@Override
	protected  void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		
			g2d.setStroke(new BasicStroke(28));
			g2d.setPaint(Color.LIGHT_GRAY);
			g2d.drawArc(30, 30, 500, 500, 80, -340);

			g2d.setStroke(new BasicStroke(28));
			g2d.setPaint(Color.LIGHT_GRAY);
			g2d.drawArc(60, 60, 440, 440, 80, -340);

	}

}
