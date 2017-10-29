package org.wahlzeit.model;

public class Location {
	
	protected Coordinate coordinate;
	
	public Location(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	/**
	 * @methodtype get
	 */
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	/**
	 * @methodtype set
	 */
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
}
