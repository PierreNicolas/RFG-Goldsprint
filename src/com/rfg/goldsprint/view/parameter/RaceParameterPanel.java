package com.rfg.goldsprint.view.parameter;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.rfg.goldsprint.controler.AbstractRaceControler;
import com.rfg.goldsprint.properties.InitProperties;
import com.rfg.goldsprint.view.PlayerDisplayPanel;
import com.rfg.goldsprint.view.listener.RecordParameterListener;
import com.rfg.goldsprint.view.race.RaceDisplayPanel;

public class RaceParameterPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5843158910933613930L;

	protected PlayerParameterComponent player1Parameter;
	protected PlayerParameterComponent player2Parameter;
	protected RaceParameterComponent raceParameter;
	protected JButton recordParameterBT;

	protected PlayerDisplayPanel player1Pane;
	protected PlayerDisplayPanel player2Pane;
	protected RaceDisplayPanel racePane;
	protected AbstractRaceControler controler;

	public RaceParameterPanel(AbstractRaceControler controler,
			PlayerDisplayPanel player1Pane, PlayerDisplayPanel player2Pane,
			RaceDisplayPanel racePane) {
		super();
		this.controler = controler;
		this.player1Pane = player1Pane;
		this.player2Pane = player2Pane;
		this.racePane = racePane;
		initPanel();

	}

	public void initPanel() {

		GridLayout panelLayout = new GridLayout(1, 0);
		this.setLayout(panelLayout);
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));	;
		player1Parameter = new PlayerParameterComponent(InitProperties.P1NAME,
				InitProperties.WHEELSIZE, InitProperties.CRANKSIZE,
				InitProperties.COGSIZE,InitProperties.PLAYER1COLOR);
	
		player2Parameter = new PlayerParameterComponent(InitProperties.P2NAME,
				InitProperties.WHEELSIZE, InitProperties.CRANKSIZE,
				InitProperties.COGSIZE,InitProperties.PLAYER2COLOR);
		
		
		raceParameter = new RaceParameterComponent();

		ImageIcon wrenchIcon = new ImageIcon(this.getClass().getResource("/images/wrench.png"));
		recordParameterBT = new JButton(wrenchIcon);
		recordParameterBT.setHorizontalAlignment(JLabel.CENTER);
		recordParameterBT.setForeground(Color.BLACK);
		recordParameterBT.setBackground(Color.WHITE);
		Border line = new LineBorder(Color.WHITE);
		Border margin = new EmptyBorder(0, 0, 0, 0);
		Border compound = new CompoundBorder(line, margin);
		recordParameterBT.setBorder(compound);
		recordParameterBT.addActionListener(new RecordParameterListener(this, controler, player1Pane, player2Pane, racePane));

		this.add(player1Parameter);
		this.add(player2Parameter);
		this.add(raceParameter);
		
		
		this.add(recordParameterBT);

	}

	public PlayerParameterComponent getPlayer1Parameter() {
		return player1Parameter;
	}

	public void setPlayer1Parameter(PlayerParameterComponent player1Parameter) {
		this.player1Parameter = player1Parameter;
	}

	public PlayerParameterComponent getPlayer2Parameter() {
		return player2Parameter;
	}

	public void setPlayer2Parameter(PlayerParameterComponent player2Parameter) {
		this.player2Parameter = player2Parameter;
	}

	public RaceParameterComponent getRaceParameter() {
		return raceParameter;
	}

	public void setRaceParameter(RaceParameterComponent raceParameter) {
		this.raceParameter = raceParameter;
	}

	/**
	 * @return the recordParameterBT
	 */
	public JButton getRecordParameterBT() {
		return recordParameterBT;
	}

	/**
	 * @param recordParameterBT
	 *            the recordParameterBT to set
	 */
	public void setRecordParameterBT(JButton recordParameterBT) {
		this.recordParameterBT = recordParameterBT;
	}

	/**
	 * @return the player1Pane
	 */
	public PlayerDisplayPanel getPlayer1Pane() {
		return player1Pane;
	}

	/**
	 * @param player1Pane
	 *            the player1Pane to set
	 */
	public void setPlayer1Pane(PlayerDisplayPanel player1Pane) {
		this.player1Pane = player1Pane;
	}

	/**
	 * @return the player2Pane
	 */
	public PlayerDisplayPanel getPlayer2Pane() {
		return player2Pane;
	}

	/**
	 * @param player2Pane
	 *            the player2Pane to set
	 */
	public void setPlayer2Pane(PlayerDisplayPanel player2Pane) {
		this.player2Pane = player2Pane;
	}

}
