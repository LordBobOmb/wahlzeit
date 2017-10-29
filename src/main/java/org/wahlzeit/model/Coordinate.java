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
 * represents a geographic coordinate and provides methods to deal with them
 */
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
