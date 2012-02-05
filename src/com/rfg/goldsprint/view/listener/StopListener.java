package com.rfg.goldsprint.view.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.rfg.goldsprint.controler.AbstractRaceControler;

public class StopListener implements ActionListener{

	AbstractRaceControler controler;
	JButton startBT;
	JButton stopBT;
	
	
	
	public StopListener(AbstractRaceControler controler2, JButton startBT,JButton stopBT) {
		super();
		this.controler = controler2;
		this.startBT = startBT;
		this.stopBT = stopBT;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		controler.stopRace();
		startBT.setEnabled(true);
		stopBT.setEnabled(false);
	}

}
