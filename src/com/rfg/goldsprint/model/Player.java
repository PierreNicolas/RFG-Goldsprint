package com.rfg.goldsprint.model;

/**
 * This class contain bike and player infos
 * @author pnicolas
 *
 */
public class Player {

	//Name of the player
	String name;
	//Wheel Size
	int wheelSize;
	//Crank Size
	int crankSize;
	//Cog Size
	int cogSize;
	//player Development
	float development;

	
	public Player(String name, int wheelSize, int crankSize, int cogSize) {
		super();
		this.name = name;
		this.wheelSize = wheelSize;
		this.crankSize = crankSize;
		this.cogSize = cogSize;
		computePlayerDevelopment();
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the wheelSize
	 */
	public int getWheelSize() {
		return wheelSize;
	}



	/**
	 * @param wheelSize the wheelSize to set
	 */
	public void setWheelSize(int wheelSize) {
		this.wheelSize = wheelSize;
	}



	/**
	 * @return the crankSize
	 */
	public int getCrankSize() {
		return crankSize;
	}



	/**
	 * @param crankSize the crankSize to set
	 */
	public void setCrankSize(int crankSize) {
		this.crankSize = crankSize;
	}



	/**
	 * @return the cogSize
	 */
	public int getCogSize() {
		return cogSize;
	}



	/**
	 * @param cogSize the cogSize to set
	 */
	public void setCogSize(int cogSize) {
		this.cogSize = cogSize;
	}



	/**
	 * @return the development
	 */
	public float getDevelopment() {
		return development;
	}



	/**
	 * @param development the development to set
	 */
	public void setDevelopment(float development) {
		this.development = development;
	}



	public void computePlayerDevelopment(){
		float development = ((float)crankSize/(float)cogSize)*(float)wheelSize/1000;
		setDevelopment(development);
	}
	
}
