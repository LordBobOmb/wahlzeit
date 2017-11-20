package org.wahlzeit.model;

public interface Coordinate {
	
	public CartesianCoordinate asCartesianCoordinate();
	
	public double getCartesianDistance(Coordinate to);
	
	public SphericCoordinate asSphericCoordinate();
	
	public double getSphericDistance(Coordinate to);
	
	public double getDistance(Coordinate to);
	
	public boolean isEqual(Coordinate to);
}
