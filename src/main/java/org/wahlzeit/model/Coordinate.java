package org.wahlzeit.model;

public class Coordinate {

	private double x;
	private double y;
	private double z;
	
	
	public Coordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	double getDistance(Coordinate to) {
		
		double xDiff = to.x - this.x;
		double yDiff = to.y - this.y;
		double zDiff = to.z - this.z;
		
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
	}
	
	boolean isEqual(Coordinate to) {
		return to.x == this.x && to.y == this.y
				&& to.z == this.z;
	}
	
	@Override
	public boolean equals(Object obj) {
		return isEqual((Coordinate) obj);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}
}
