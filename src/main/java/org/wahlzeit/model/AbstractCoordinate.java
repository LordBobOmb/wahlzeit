package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate{
	
	public boolean isEqual(Coordinate to) {
		assertClassInvariant();
		double delta = 0.00001;
		return this.getDistance(to) < delta;
	}
	
	public boolean equals(Object obj) {
		assertClassInvariant();
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		assertClassInvariant();
		return this.isEqual(other);
	}
	
	public double getDistance(Coordinate to) {
		assertClassInvariant();
		if(to == null) throw new IllegalArgumentException();
		if(to instanceof CartesianCoordinate) {
			return this.getCartesianDistance(to);
		} else {
			return this.getSphericDistance(to);
		}
	}
	
	@Override
	public double getCartesianDistance(Coordinate to) {
		assertClassInvariant();
		if(to == null) throw new IllegalArgumentException("null argument");
		CartesianCoordinate cart1 = this.asCartesianCoordinate();
		CartesianCoordinate cart2 = to.asCartesianCoordinate();
		double xDiff = cart2.getX() - cart1.getX();
		double yDiff = cart2.getY() - cart1.getY();
		double zDiff = cart2.getZ() - cart1.getZ();
		assertClassInvariant();
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
	}
	
	//uses the radius of the Coordinate the method is called on
	@Override
	public double getSphericDistance(Coordinate to) {
		assertClassInvariant();
		if(to == null) throw new IllegalArgumentException("null argument");
		SphericCoordinate sph1 = this.asSphericCoordinate();
		SphericCoordinate sph2 = to.asSphericCoordinate();
		
		double delta = Math.acos(Math.sin(sph1.getLatitude()) * Math.sin(sph2.getLatitude())
				+ Math.cos(sph1.getLatitude()) * Math.cos(sph2.getLatitude()) * Math.cos(sph1.getLatitude() 
						- sph2.getLatitude()));
		assertClassInvariant();
		return sph1.getRadius() * delta;
	}
	
	private void assertClassInvariant() {
		assert true;
	}
	
	abstract public CartesianCoordinate asCartesianCoordinate();
	abstract public SphericCoordinate asSphericCoordinate();

}
