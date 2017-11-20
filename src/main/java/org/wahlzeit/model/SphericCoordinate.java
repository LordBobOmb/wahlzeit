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
public class SphericCoordinate implements Coordinate {

	private double latitude; //theta
	private double longitude; //phi
	private double radius;
	

	public SphericCoordinate(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getRadius() {
		return radius;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double convertedX = radius * Math.sin(latitude) * Math.cos(longitude);
		double convertedY = radius * Math.sin(latitude) * Math.sin(longitude);
		double convertedZ = radius * Math.cos(latitude);
		return new CartesianCoordinate(convertedX, convertedY, convertedZ);
	}

	@Override
	public double getCartesianDistance(Coordinate to) {
		CartesianCoordinate convThis = this.asCartesianCoordinate();
		return convThis.getCartesianDistance(to);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getSphericDistance(Coordinate to) {
		SphericCoordinate convTo = to.asSphericCoordinate();
		double delta = Math.acos(Math.sin(this.getLatitude()) * Math.sin(convTo.getLatitude())
				+ Math.cos(this.getLatitude()) * Math.cos(convTo.getLatitude()) * Math.cos(this.getLatitude() - convTo.getLatitude()));
		return this.getRadius() * delta;
	}

	@Override
	public double getDistance(Coordinate to) {
		return getSphericDistance(to);
	}

	public boolean isEqual(Coordinate to) {
		double delta = 0.00001;
		SphericCoordinate convertedCoord = to.asSphericCoordinate();
		return getDistance(convertedCoord) <= delta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(latitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(longitude);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return isEqual((SphericCoordinate) obj);
		
	}

}
