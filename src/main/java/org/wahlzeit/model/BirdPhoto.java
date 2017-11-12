package org.wahlzeit.model;

public class BirdPhoto extends Photo{
	
	public final String birdType;
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto() {
		this("General");
	}
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto(PhotoId myID) {
		this("General", myID);
	}
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto(String birdType) {
		super();
		this.birdType = birdType;
	}
	
	/**
	 * @methodtype constructor
	 */
	public BirdPhoto(String birdType, PhotoId myID) {
		super(myID);
		this.birdType = birdType;
	}
	
	
	

}
