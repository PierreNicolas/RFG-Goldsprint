package com.rfg.goldsprint.appli;

import com.rfg.goldsprint.arduino.ArduinoConnector;
import com.rfg.goldsprint.controler.AbstractRaceControler;
import com.rfg.goldsprint.controler.RaceControler;
import com.rfg.goldsprint.model.Player;
import com.rfg.goldsprint.model.PlayerRaceParameters;
import com.rfg.goldsprint.model.Race;
import com.rfg.goldsprint.properties.InitProperties;
import com.rfg.goldsprint.view.GoldsprintInterface;

/**
 * @author pnicolas
 * Main class of the GoldSprint
 */
public class  Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Init Players
		Player player1 = new Player(InitProperties.P1NAME, InitProperties.WHEELSIZE, InitProperties.CRANKSIZE, InitProperties.COGSIZE);
		Player player2 = new Player(InitProperties.P2NAME, InitProperties.WHEELSIZE, InitProperties.CRANKSIZE, InitProperties.COGSIZE);
		
		//Init Players parameters
		PlayerRaceParameters prp1 = new PlayerRaceParameters(player1);
		PlayerRaceParameters prp2 = new PlayerRaceParameters(player2);
		
		Race race = new Race(InitProperties.RACEDISTANCE,prp1,prp2);
		
		//création du contrôleur
		AbstractRaceControler controler = new RaceControler(race);
		
		//Création de notre fenêtre avec le contrôleur en paramètre
		GoldsprintInterface goldsprintInterface = new GoldsprintInterface(controler);
		
		
		//Ajout de la fenêtre comme observer de notre modèle
		race.addObserver(goldsprintInterface);
		
		//thread Arduino
		ArduinoConnector arduinoConnector = new ArduinoConnector(race,args[0]);
		arduinoConnector.start();
	}

}
