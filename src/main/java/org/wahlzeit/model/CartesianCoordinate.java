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
	
	private final double LIMIT = 15e6;	//earth radius is about 6e6 m, for pictures on earth you shouldn't need more
	

	public CartesianCoordinate(double x, double y, double z) {
		try{setX(x);
		setY(y);
		setZ(z); 
		} catch (IllegalArgumentException e) {
			x = 0;
			y = 0;
			z = 0;
		}
		assertClassInvariant();
	}

	//tests for realistic values in coordinate values
	private void assertClassInvariant() {
		assert Math.abs(x) < LIMIT && Math.abs(y) < LIMIT && Math.abs(z) < LIMIT;
	}

	@Override
	public int hashCode() {
		assertClassInvariant();
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
		assertClassInvariant();
		return result;
	}

	public double getX() {
		assertClassInvariant();
		return x;
	}

	public double getY() {
		assertClassInvariant();
		return y;
	}

	protected void setX(double x) {
		if(Math.abs(x) > LIMIT) throw new IllegalArgumentException("Tried to set to illegal x value");
		this.x = x;
		assertClassInvariant();
	}

	protected void setY(double y) {
		if(Math.abs(y) > LIMIT) throw new IllegalArgumentException("Tried to set to illegal y value");
		this.y = y;
		assertClassInvariant();
	}

	protected void setZ(double z) {
		if(Math.abs(z) > LIMIT) throw new IllegalArgumentException("Tried to set to illegal z value");
		this.z = z;
		assertClassInvariant();
	}

	public double getZ() {
		assertClassInvariant();
		return z;
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariant();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariant();
		double oldX = x, oldY = y, oldZ = z;	//for post-condition
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		double latitude = Math.acos(z/radius);
		double longitude = Math.atan(y/x);
		
		assert oldX == x && oldY == y && oldZ == z;	//post-condition
		assertClassInvariant();
		return new SphericCoordinate(latitude, longitude, radius);
	}

}
