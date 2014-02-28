package ch.mas.ict.events;

import java.util.EventObject;

/**
 * 
 * @file    	SortChangedEvent.java
 * @project 	XSort
 * @author  	Paulo Lopes
 * @create  	11 déc. 2010 00:43:29
 * @mail 		lopespaulo18@gmail.com
 * @Description Class non Utiliser.
 */
public class SortChangedEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int newVolume;

	/**
	 * 
	 * @param source
	 * @param newVolume
	 */
	public SortChangedEvent(Object source, int newVolume){
		super(source);

		this.newVolume = newVolume;
	}

	/**
	 * 
	 * @return
	 */
	public int getNewVolume(){
		return newVolume;
	}
}