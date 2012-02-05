package com.rfg.goldsprint.view.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rfg.goldsprint.controler.AbstractRaceControler;
import com.rfg.goldsprint.view.PlayerDisplayPanel;
import com.rfg.goldsprint.view.extcomponent.ComboItem;
import com.rfg.goldsprint.view.parameter.RaceParameterPanel;
import com.rfg.goldsprint.view.race.RaceDisplayPanel;

public class RecordParameterListener implements ActionListener{

	RaceParameterPanel raceParameterPanel;
	AbstractRaceControler controler;
	PlayerDisplayPanel player1Pane;
	PlayerDisplayPanel player2Pane;
	RaceDisplayPanel racePane;
	
	
	public RecordParameterListener(RaceParameterPanel raceParameterPanel,
			AbstractRaceControler controler, PlayerDisplayPanel player1Pane,
			PlayerDisplayPanel player2Pane,RaceDisplayPanel racePane) {
		super();
		this.raceParameterPanel = raceParameterPanel;
		this.controler = controler;
		this.player1Pane = player1Pane;
		this.player2Pane = player2Pane;
		this.racePane = racePane;
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		int distanceOfRace = Integer.valueOf(raceParameterPanel.getRaceParameter().getRaceDistance().getText());
		boolean mockModeAction = raceParameterPanel.getRaceParameter().getMockMode().isSelected();
		boolean fsModeAction = raceParameterPanel.getRaceParameter().getFsMode().isSelected();
		
		String p1Name = raceParameterPanel.getPlayer1Parameter().getPlayerName().getText();
		int p1wheelsize = ((ComboItem) raceParameterPanel.getPlayer1Parameter().getWheelSize().getSelectedItem()).getValue();
		int p1cranksize = ((ComboItem) raceParameterPanel.getPlayer1Parameter().getCrankSize().getSelectedItem()).getValue();
		int p1cogsize = ((ComboItem) raceParameterPanel.getPlayer1Parameter().getCogSize().getSelectedItem()).getValue();
		Color player1Color = raceParameterPanel.getPlayer1Parameter().getPlayerCurrentColor();
		
		
		String p2Name = raceParameterPanel.getPlayer2Parameter().getPlayerName().getText();
		int p2wheelsize = ((ComboItem) raceParameterPanel.getPlayer2Parameter().getWheelSize().getSelectedItem()).getValue();
		int p2cranksize = ((ComboItem) raceParameterPanel.getPlayer2Parameter().getCrankSize().getSelectedItem()).getValue();
		int p2cogsize = ((ComboItem) raceParameterPanel.getPlayer2Parameter().getCogSize().getSelectedItem()).getValue();
		Color player2Color = raceParameterPanel.getPlayer2Parameter().getPlayerCurrentColor();
		
		controler.updateRaceParameters(distanceOfRace, mockModeAction, fsModeAction, p1Name, p1wheelsize, p1cranksize, p1cogsize, p2Name, p2wheelsize, p2cranksize, p2cogsize);
		
		player1Pane.getPlayerName().setText(p1Name);
		player2Pane.getPlayerName().setText(p2Name);
		
		player1Pane.setPlayerColor(player1Color);
		player2Pane.setPlayerColor(player2Color);
		
		racePane.getDs3().setPlayer1Color(player1Color);
		racePane.getDs2().setPlayer2Color(player2Color);
		
		racePane.getDs2().setRaceDistance(distanceOfRace);
		racePane.getDs3().setRaceDistance(distanceOfRace);
		
		//Closed Parameter panel after submit
		raceParameterPanel.setVisible(false);
	}

}
