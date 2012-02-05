package com.rfg.goldsprint.observer;

/**
 * @author pnicolas
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	public void removeObserver();
	public void notifyObserver(String  cpt, String str);
}