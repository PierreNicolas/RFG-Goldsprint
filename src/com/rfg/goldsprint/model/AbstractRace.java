package com.rfg.goldsprint.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.rfg.goldsprint.observer.Observable;
import com.rfg.goldsprint.observer.Observer;

public abstract class AbstractRace implements Observable {

	//Race Actions
	boolean startRaceAction = false;
	boolean stopRaceAction = false;

	// Race Parameters
	int distanceOfRace = 0;
	boolean mockModeAction = false;
	boolean fsModeAction = false;

	// Race infos
	long raceTimer = 0;
	String raceCountDown = "";
	String RaceMessage = "";

	//Race Session Statistics
	Set<PlayerRaceStats> playerRaceStats;
	
	PlayerRaceParameters player1RP;
	PlayerRaceParameters player2RP;
	Player winner;
	
	public AbstractRace(int distanceOfRace, PlayerRaceParameters player1rp,
			PlayerRaceParameters player2rp) {
		super();
		this.distanceOfRace = distanceOfRace;
		player1RP = player1rp;
		player2RP = player2rp;
		
		playerRaceStats = new HashSet<PlayerRaceStats>();
	}

	private ArrayList<Observer> listObserver = new ArrayList<Observer>();

	public abstract void reset();

	public abstract void startRace();

	public abstract void stopRace();

	public abstract void updateRaceParameters(int distanceOfRace,
			boolean mockModeAction, boolean fsModeAction, String p1Name,
			int p1wheelsize, int p1cranksize, int p1cogsize, String p2Name,
			int p2wheelsize, int p2cranksize, int p2cogsize);

	public abstract void updateRaceInfos(String cpt, String value);
	
	

	// **************************************************
	// IMPLÉMENTATION PATTERN OBSERVER
	// **************************************************

	public boolean isStartRaceAction() {
		return startRaceAction;
	}

	public void setStartRaceAction(boolean startRaceAction) {
		this.startRaceAction = startRaceAction;
	}

	public boolean isStopRaceAction() {
		return stopRaceAction;
	}

	public void setStopRaceAction(boolean stopRaceAction) {
		this.stopRaceAction = stopRaceAction;
	}

	public int getDistanceOfRace() {
		return distanceOfRace;
	}

	public void setDistanceOfRace(int distanceOfRace) {
		this.distanceOfRace = distanceOfRace;
	}

	public boolean isMockModeAction() {
		return mockModeAction;
	}

	public void setMockModeAction(boolean mockModeAction) {
		this.mockModeAction = mockModeAction;
	}

	public boolean isFsModeAction() {
		return fsModeAction;
	}

	public void setFsModeAction(boolean fsModeAction) {
		this.fsModeAction = fsModeAction;
	}

	public long getRaceTimer() {
		return raceTimer;
	}

	public void setRaceTimer(long raceTimer) {
		this.raceTimer = raceTimer;
	}

	public String getRaceCountDown() {
		return raceCountDown;
	}

	public void setRaceCountDown(String raceCountDown) {
		this.raceCountDown = raceCountDown;
	}

	public String getRaceMessage() {
		return RaceMessage;
	}

	public void setRaceMessage(String raceMessage) {
		RaceMessage = raceMessage;
	}

	public PlayerRaceParameters getPlayer1RP() {
		return player1RP;
	}

	public void setPlayer1RP(PlayerRaceParameters player1rp) {
		player1RP = player1rp;
	}

	public PlayerRaceParameters getPlayer2RP() {
		return player2RP;
	}

	public void setPlayer2RP(PlayerRaceParameters player2rp) {
		player2RP = player2rp;
	}

	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	
	/**
	 * @return the playerRaceStats
	 */
	public Set<PlayerRaceStats> getPlayerRaceStats() {
		return playerRaceStats;
	}

	/**
	 * @param playerRaceStats the playerRaceStats to set
	 */
	public void setPlayerRaceStats(Set<PlayerRaceStats> playerRaceStats) {
		this.playerRaceStats = playerRaceStats;
	}

	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}

	public void notifyObserver(String cpt, int str) {

		for (Observer obs : listObserver)
			obs.update(cpt, str);
	}
	
	public void notifyObserver(String cpt, float str) {

		for (Observer obs : listObserver)
			obs.update(cpt, str);
	}
	
	public void notifyObserver(String cpt, long str) {

		for (Observer obs : listObserver)
			obs.update(cpt, str);
	}

	public void notifyObserver(String cpt, String str) {

		for (Observer obs : listObserver)
			obs.update(cpt, str);
	}
	
	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}

}
