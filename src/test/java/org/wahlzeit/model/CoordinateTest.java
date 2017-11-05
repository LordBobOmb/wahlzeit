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

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import org.junit.Before;


public class CoordinateTest {
	
	private Location testLocation;
	private Coordinate testCoordinate;
	
	@Before
	public void setup() {
		testCoordinate = new Coordinate(2, 2.5, 4);
		testLocation = new Location(testCoordinate);
		
	}
	
	@Test
	public void testEquals() {
		Coordinate testCoordinate2 = new Coordinate(2, 2.5, 4);
		assertTrue(testCoordinate.isEqual(testCoordinate2));
		assertTrue(testCoordinate.equals(testCoordinate2));
	}
	
	@Test
	public void testEqualsNegativeCase() {
		Coordinate testCoordinate2 = new Coordinate(1, 1 , 4);
		assertFalse(testCoordinate.isEqual(testCoordinate2));
		assertFalse(testCoordinate.equals(testCoordinate2));
	}
	
	@Test
	public void testGetCoordinate() {
		assertTrue(testCoordinate.equals(testLocation.getCoordinate()));
	}
	
	@Test
	public void testSetCoordinate() {
		Coordinate newCoordinate = new Coordinate(5, 2, 420);
		testLocation.setCoordinate(newCoordinate);
		assertTrue(newCoordinate.equals(testLocation.getCoordinate()));
	}
	
	@Test
	public void testCoordinateDistance() {
		Coordinate testCoordinate2 = new Coordinate(5, 2.5, 4);
		assertEquals(testCoordinate2.getDistance(testCoordinate), 3, 0.0001);
	}
	
	@Test
	public void testCoordinateDistance2() {
		Coordinate testCoordinate2 = new Coordinate(6, 1.7, 9.5);
		double dist = Math.sqrt(4*4 + 0.8 * 0.8 + 5.5*5.5);
		assertEquals(testCoordinate2.getDistance(testCoordinate), dist, 0.0001);
	}
	
	
	
}
