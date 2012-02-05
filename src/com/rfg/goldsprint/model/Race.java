package com.rfg.goldsprint.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.rfg.goldsprint.properties.GoldSprintProperties;
import com.rfg.goldsprint.properties.InitProperties;

public class Race extends AbstractRace {

	//used by optimizer
	float lastDistance1 = 0;
    float lastDistance2 = 0;

    long currentime1 = 0;
    long currentime2 = 0;
    long lasDistance1Call = 0;
    long lasDistance2Call = 0;
    
    
    float accCoef1 = 1;
    float accCoef2 = 1;
  
	public Race(int distanceOfRace, PlayerRaceParameters player1rp,
			PlayerRaceParameters player2rp) {
		super(distanceOfRace, player1rp, player2rp);

	}

	public void reset() {
		raceTimer = 0;
		notifyObserver(GoldSprintProperties.RACE_TIMER,new Long(0));
		raceCountDown = "";
		notifyObserver(GoldSprintProperties.RACE_COUNTDOWN, "");
		RaceMessage = "";
		notifyObserver(GoldSprintProperties.RACE_MESSAGE, "Reset");

		if (player1RP != null) {
			
			player1RP.setFinishTime(0);
			notifyObserver(GoldSprintProperties.PLAYER1_FINISHTIME,new Long(0));
			player1RP.setSpeed(0);
			notifyObserver(GoldSprintProperties.PLAYER1_SPEED,new Float(0));
			player1RP.setMaxSpeed(0);
			notifyObserver(GoldSprintProperties.PLAYER1_MAXSPEED,new Float(0));
			player1RP.setDistance(0);
			notifyObserver(GoldSprintProperties.PLAYER1_DISTANCE,new Float(0));
		}

		if (player2RP != null) {		
			player2RP.setFinishTime(0);
			notifyObserver(GoldSprintProperties.PLAYER2_FINISHTIME,new Long(0));
			player2RP.setSpeed(0);
			notifyObserver(GoldSprintProperties.PLAYER2_SPEED,new Float(0));
			player2RP.setMaxSpeed(0);
			notifyObserver(GoldSprintProperties.PLAYER2_MAXSPEED,new Float(0));
			player2RP.setDistance(0);
			notifyObserver(GoldSprintProperties.PLAYER2_DISTANCE, new Float(0));
		}

		lastDistance1 = 0;
		lastDistance2 = 0;

		currentime1 = 0;
		currentime2 = 0;
		lasDistance1Call = 0;
		lasDistance2Call = 0;
		winner = null;

	}

	
	
	public void startRace() {
		startRaceAction = true;
	}

	public void stopRace() {
		stopRaceAction = true;
	}

	public void updateRaceInfos(String cpt, String value) {
		// not necessary might be remove later
		if (cpt.equals(GoldSprintProperties.RACE_TIMER)) {
			notifyObserver(cpt, Long.valueOf(value));
		}
		if (cpt.equals(GoldSprintProperties.RACE_COUNTDOWN)) {
			raceCountDown = value;
			notifyObserver(cpt, value);
		}
		if (cpt.equals(GoldSprintProperties.RACE_MESSAGE)) {
			RaceMessage = value;
			notifyObserver(cpt, value);
		}
		if (cpt.equals(GoldSprintProperties.PLAYER1_DISTANCE)) {
			float distance = Float.valueOf(value)
					* player1RP.getPlayer().getDevelopment();
			player1RP.setDistance(distance);
			if(InitProperties.PLAYER1DISTANCEOPTIMIZER){
				currentime1 = System.currentTimeMillis();
	            if(lasDistance1Call > 0){
	            	
	            	notifyObserver(cpt,(distance-((distance - lastDistance1) * (float)0.7)));
					//Thread.sleep((long) ((currentime1-lasDistance1Call)/(4*accCoef1)));
					notifyObserver(cpt,(distance-((distance - lastDistance1) * (float)0.3)));
					// Thread.sleep((long) ((currentime1-lasDistance1Call)/(4*accCoef1)));
		            
	            }
	            lasDistance1Call = currentime1;
	            lastDistance1 = distance;
			}
			
			notifyObserver(cpt,distance);
		}
		if (cpt.equals(GoldSprintProperties.PLAYER1_FINISHTIME)) {
			notifyObserver(cpt, Long.valueOf(value));
			notifyObserver(GoldSprintProperties.PLAYER1_DISTANCE,(float)this.getDistanceOfRace());
			if (winner == null) {
				this.setWinner(this.getPlayer1RP().getPlayer());
				notifyObserver(GoldSprintProperties.RACE_WINNER,this.getPlayer1RP().getPlayer().getName());
			}
			PlayerRaceStats player1Stats = new PlayerRaceStats(this.getPlayer1RP().getPlayer().getName(), Long.valueOf(value), distanceOfRace, this.getPlayer1RP().getMaxSpeed());
			playerRaceStats.add(player1Stats);
			addStatsToFile(player1Stats.printStats());
			
		}
		if (cpt.equals(GoldSprintProperties.PLAYER1_SPEED)) {

			float speed = (player1RP.getPlayer().getDevelopment() / Float
					.valueOf(value)) * 3600;
			if (player1RP.getMaxSpeed() < speed) {
				player1RP.setMaxSpeed(speed);
				notifyObserver(GoldSprintProperties.PLAYER1_MAXSPEED, speed);
			}
			accCoef1 = speed/player1RP.getSpeed();
			player1RP.setSpeed(speed);
			notifyObserver(cpt, speed);
		}

		if (cpt.equals(GoldSprintProperties.PLAYER2_DISTANCE)) {
			float distance = Float.valueOf(value)
					* player2RP.getPlayer().getDevelopment();
			player2RP.setDistance(distance);
			if(InitProperties.PLAYER2DISTANCEOPTIMIZER){
				currentime2 = System.currentTimeMillis();
	            if(lasDistance2Call > 0){
	            	
	            	notifyObserver(cpt,(distance-((distance - lastDistance2) * (float)0.7)));
					//Thread.sleep((long) ((currentime2-lasDistance2Call)/(4*accCoef2)));
					notifyObserver(cpt,(distance-((distance - lastDistance2) * (float)0.3)));
					//Thread.sleep((long) ((currentime2-lasDistance2Call)/(4*accCoef2)));
		            
	            }
	            lasDistance2Call = currentime2;
	            lastDistance2 = distance;
			}
			notifyObserver(cpt, distance);
		}
		if (cpt.equals(GoldSprintProperties.PLAYER2_FINISHTIME)) {
			notifyObserver(cpt, Long.valueOf(value));
			notifyObserver(GoldSprintProperties.PLAYER2_DISTANCE,(float)this
					.getDistanceOfRace());
			if (winner == null) {
				this.setWinner(this.getPlayer2RP().getPlayer());
				notifyObserver(GoldSprintProperties.RACE_WINNER,this.getPlayer2RP().getPlayer().getName());
			}
			//Add Stats
			PlayerRaceStats player2Stats = new PlayerRaceStats(this.getPlayer2RP().getPlayer().getName(), Long.valueOf(value), distanceOfRace, this.getPlayer2RP().getMaxSpeed());
			playerRaceStats.add(player2Stats);
			addStatsToFile(player2Stats.printStats());
			
		}
		if (cpt.equals(GoldSprintProperties.PLAYER2_SPEED)) {
			float speed = (player2RP.getPlayer().getDevelopment() / Float
					.valueOf(value)) * 3600;
			if (player2RP.getMaxSpeed() < speed) {
				player2RP.setMaxSpeed(speed);
				notifyObserver(GoldSprintProperties.PLAYER2_MAXSPEED, speed);
			}
			accCoef2 = speed/player2RP.getSpeed();
			player2RP.setSpeed(speed);
			notifyObserver(cpt, speed);
		}

	}

	public void updateRaceParameters(int distanceOfRace,
			boolean mockModeAction, boolean fsModeAction, String p1Name,
			int p1wheelsize, int p1cranksize, int p1cogsize, String p2Name,
			int p2wheelsize, int p2cranksize, int p2cogsize) {

		this.distanceOfRace = distanceOfRace;
		this.mockModeAction = mockModeAction;
		this.fsModeAction = fsModeAction;

		this.player1RP.getPlayer().setName(p1Name);
		this.player1RP.getPlayer().setWheelSize(p1wheelsize);
		this.player1RP.getPlayer().setCrankSize(p1cranksize);
		this.player1RP.getPlayer().setCogSize(p1cogsize);
		this.player1RP.getPlayer().computePlayerDevelopment();

		this.player2RP.getPlayer().setName(p2Name);
		this.player2RP.getPlayer().setWheelSize(p2wheelsize);
		this.player2RP.getPlayer().setCrankSize(p2cranksize);
		this.player2RP.getPlayer().setCogSize(p2cogsize);
		this.player2RP.getPlayer().computePlayerDevelopment();
	}
	
	public static void addStatsToFile(String text) {
	        BufferedWriter bufWriter = null;
	        FileWriter fileWriter = null;
	        try {
	            fileWriter = new FileWriter("StatsGS.csv", true);
	            bufWriter = new BufferedWriter(fileWriter);
	            //Insérer un saut de ligne
	            bufWriter.newLine();
	            bufWriter.write(text);
	            bufWriter.close();
	        } catch (IOException ex) {
	         
	        } finally {
	            try {
	                bufWriter.close();
	                fileWriter.close();
	            } catch (IOException ex) {
	               
	        }
	    } 
	}       

}
