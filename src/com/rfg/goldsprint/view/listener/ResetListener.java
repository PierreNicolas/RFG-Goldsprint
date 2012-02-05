package com.rfg.goldsprint.view.listener;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.rfg.goldsprint.controler.AbstractRaceControler;
import com.rfg.goldsprint.view.race.RaceDisplayLayer1;

public class ResetListener implements ActionListener {

	AbstractRaceControler controler;
	RaceDisplayLayer1 ds1;

	public ResetListener(AbstractRaceControler controler, RaceDisplayLayer1 ds1) {
		super();
		this.controler = controler;
		this.ds1 = ds1;
		
	}

	public void actionPerformed(ActionEvent e) {
		controler.reset();
		Font winnerpolice = new Font("Arial", Font.BOLD, 40);
		ds1.getRaceCountDown().setFont(winnerpolice);
		ds1.getRaceCountDown().setBackground(null);
		ds1.getRaceCountDown().setOpaque(false);
		ds1.getRaceCountDown().setForeground(Color.BLACK);
		ds1.getRaceCountDown().setBorder(null);

	}

}