package com.rfg.goldsprint.observer;

/**
 * @author pnicolas
 *
 */
public interface Observer {
	public void update(String Component, String str);
	public void update(String Component, long str);
	public void update(String Component, int str);
	public void update(String Component, float str);
	
}
