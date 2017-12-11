/*
 * Copyright (c) 2017 by Filip Kozik, https://github.com/LordBobOmb
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.model;
/*
 * represents a geographic coordinate in the spheric model and provides methods to deal with them
 */
public class SphericCoordinate extends AbstractCoordinate {

	private double latitude;
	private double longitude;
	private double radius;
	

	public SphericCoordinate(double latitude, double longitude, double radius) {
		try {
			setLatitude(latitude);
			setLongitude(longitude);
			setRadius(radius);
		} catch (IllegalArgumentException e) {
			latitude = 0;
			longitude = 0;
			radius = 0;
		}
		assertClassInvariant();
	}
	
	//tests for realistic values in coordinate values
	private void assertClassInvariant() {
		assert Math.abs(latitude) <= 90 && Math.abs(longitude) <= 180 
				&& radius > 0 && radius < 15e6;
	}
	public double getLatitude() {
		 assertClassInvariant();
		return latitude;
	}

	public double getLongitude() {
		assertClassInvariant();
		return longitude;
	}

	public double getRadius() {
		assertClassInvariant();
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariant();
		double oldLat = latitude, oldLong = longitude, oldRad = radius;
		
		double convertedX = radius * Math.sin(latitude) * Math.cos(longitude);
		double convertedY = radius * Math.sin(latitude) * Math.sin(longitude);
		double convertedZ = radius * Math.cos(latitude);
		
		assert oldLat == latitude && oldLong == longitude && oldRad == radius;
		return new CartesianCoordinate(convertedX, convertedY, convertedZ);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariant();
		return this;
	}

	@Override
	public int hashCode() {
		assertClassInvariant();
		double oldLat = latitude, oldLong = longitude, oldRad = radius;
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		assert oldLat == latitude && oldLong == longitude && oldRad == radius;
		assertClassInvariant();
		return result;
	}

	protected void setLatitude (double latitude) throws IllegalArgumentException {
		if(Math.abs(latitude) > 90) throw new IllegalArgumentException("Tried to set to illegal latitude value");
		this.latitude = latitude;
		assertClassInvariant();
	}

	protected void setLongitude(double longitude) throws IllegalArgumentException {
		if(Math.abs(latitude) > 180) throw new IllegalArgumentException("Tried to set to illegal longitude value");
		this.longitude = longitude;
		assertClassInvariant();
	}

	protected void setRadius(double radius) throws IllegalArgumentException {
		if(radius < 0 || radius > 15e6) throw new IllegalArgumentException("Tried to set to illegal latitude value");
		this.radius = radius;
		assertClassInvariant();
	}

}
