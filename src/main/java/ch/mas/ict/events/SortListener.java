package ch.mas.ict.events;

import java.util.EventListener;

/**
 * 
 * @file    	SortListener.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:43:50
 * @mail 		lopespaulo18@gmail.com
 * @Description  Class non Utiliser.
 */
public interface SortListener extends EventListener {
	
	/**
	 * 
	 * @param event
	 */
	public void volumeChanged(SortChangedEvent event);
}
