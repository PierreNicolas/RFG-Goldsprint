package com.rfg.goldsprint.controler;

import com.rfg.goldsprint.model.AbstractRace;

public abstract class AbstractRaceControler {

	protected AbstractRace race;
	
	public AbstractRaceControler(AbstractRace race){
		this.race = race;
	}
	
	public  void stopRace(){
		race.stopRace();
	}
	public  void startRace(){
		race.startRace();
	}
	public  void reset(){
		race.reset();
	}
	
	public  void updateRaceParameters(int distanceOfRace,
			boolean mockModeAction, boolean fsModeAction, String p1Name,
			int p1wheelsize, int p1cranksize, int p1cogsize, String p2Name,
			int p2wheelsize, int p2cranksize, int p2cogsize){
		race.updateRaceParameters(distanceOfRace, mockModeAction, fsModeAction, p1Name, p1wheelsize, p1cranksize, p1cogsize, p2Name, p2wheelsize, p2cranksize, p2cogsize);
	}
	
	
}
