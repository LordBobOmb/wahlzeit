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
		double delta = 0.00001;
		return Math.abs(to.x - this.x) <= delta
				&& Math.abs(to.y - this.y) <= delta
				&& Math.abs(to.z - this.z) <= delta;
	}
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		return this.isEqual(other);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
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
