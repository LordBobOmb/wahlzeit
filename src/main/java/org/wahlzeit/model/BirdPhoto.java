package org.wahlzeit.model;

public class BirdPhoto extends Photo{
	
	public Bird bird;
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto(Bird bird) {
		super();
		this.bird = bird;
	}
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto(Bird bird, PhotoId myID) {
		super(myID);
		this.bird = bird;
	}
	
	
	

}
