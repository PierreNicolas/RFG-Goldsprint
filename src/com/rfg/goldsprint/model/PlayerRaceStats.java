package com.rfg.goldsprint.model;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * @author Pierre
 * Store player Stat about the race he did
 */
public class PlayerRaceStats {
	
	protected String PlayerName;
	protected long finishTime;
	protected int raceDistance;
	protected float maxSpeed;
	
	/**
	 * @param playerName
	 * @param finishTime
	 * @param raceDistance
	 * @param maxSpeed
	 */
	public PlayerRaceStats(String playerName, long finishTime,
			int raceDistance, float maxSpeed) {
		super();
		PlayerName = playerName;
		this.finishTime = finishTime;
		this.raceDistance = raceDistance;
		this.maxSpeed = maxSpeed;
	}

	/**
	 * @return
	 */
	public String getPlayerName() {
		return PlayerName;
	}

	/**
	 * @param playerName
	 */
	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}

	/**
	 * @return
	 */
	public long getFinishTime() {
		return finishTime;
	}

	/**
	 * @param finishTime
	 */
	public void setFinishTime(long finishTime) {
		this.finishTime = finishTime;
	}

	/**
	 * @return
	 */
	public int getRaceDistance() {
		return raceDistance;
	}

	/**
	 * @param raceDistance
	 */
	public void setRaceDistance(int raceDistance) {
		this.raceDistance = raceDistance;
	}

	/**
	 * @return
	 */
	public float getMaxSpeed() {
		return maxSpeed;
	}

	/**
	 * @param maxSpeed
	 */
	public void setMaxSpeed(float maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	public String printStats(){
		
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(finishTime);
		int m = c.get(Calendar.MINUTE);
		int s = c.get(Calendar.SECOND);
		int M = c.get(Calendar.MILLISECOND);
		
		DecimalFormat df = new DecimalFormat ( ) ; 
		df.setMaximumFractionDigits ( 2 ) ; //arrondi à 2 chiffres apres la virgules 
		df.setMinimumFractionDigits ( 2 ) ; 
		df.setDecimalSeparatorAlwaysShown (true) ; 
		
		
		return PlayerName+";"+raceDistance+";'"+m+":"+s+":"+M+"';'"+df.format(maxSpeed)+"'";
		
	}
	
	

}
