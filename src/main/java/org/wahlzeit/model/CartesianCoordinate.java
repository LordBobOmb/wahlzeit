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
 * represents a geographic coordinate in the cartesian model and provides methods to deal with them
 */
public class CartesianCoordinate extends AbstractCoordinate{

	private double x;
	private double y;
	private double z;
	
	
	public CartesianCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		assert assertClassInvariant();
	}

	//tests for realistic values in coordinate values
	private boolean assertClassInvariant() {
		double limit = 15e6;	//earth radius is about 6e6 m, for pictures on earth you shouldn't need more
		return Math.abs(x) < limit && Math.abs(y) < limit && Math.abs(z) < limit;
	}

	@Override
	public int hashCode() {
		assert assertClassInvariant();
		double oldX = x, oldY = y, oldZ = z;
		
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(x);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(y);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(z);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		
		assert oldX == x && oldY == y && oldZ == z;	//post-condition
		assert assertClassInvariant();
		return result;
	}

	public double getX() {
		assert assertClassInvariant();
		return x;
	}

	public double getY() {
		assert assertClassInvariant();
		return y;
	}

	protected void setX(double x) {
		this.x = x;
		assert assertClassInvariant();
	}

	protected void setY(double y) {
		this.y = y;
		assert assertClassInvariant();
	}

	protected void setZ(double z) {
		this.z = z;
		assert assertClassInvariant();
	}

	public double getZ() {
		assert assertClassInvariant();
		return z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assert assertClassInvariant();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assert assertClassInvariant();
		double oldX = x, oldY = y, oldZ = z;
		double radius = Math.sqrt(x*x + y*y + z*z);
		double latitude = Math.acos(z/radius);
		double longitude = Math.atan(y/x);
		
		assert oldX == x && oldY == y && oldZ == z;	//post-condition
		assert assertClassInvariant();
		return new SphericCoordinate(latitude, longitude, radius);
	}

}
