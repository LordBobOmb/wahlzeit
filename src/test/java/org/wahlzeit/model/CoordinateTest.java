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
	private SphericCoordinate sph;
	private CartesianCoordinate cart;
	private final double EPSILON = 0.00001;
	
	@Before
	public void setup() {
		sph = new SphericCoordinate(2, 2.5, 4);
		cart = new CartesianCoordinate(2, 2.5, 4);
		testLocation = new Location(sph);
		
	}
	
	@Test
	public void testLocationInit() {
		assertTrue(testLocation.getCoordinate() instanceof SphericCoordinate);
		testLocation.setCoordinate(cart);
		assertTrue(testLocation.getCoordinate() instanceof CartesianCoordinate);
	}
	
	@Test
	public void testEquals() {
		
		SphericCoordinate sph2 = new SphericCoordinate(2, 2.5, 4);
		assertTrue(sph.isEqual(sph2));
		assertTrue(sph.equals(sph2));
		
		assertTrue(cart.asSphericCoordinate().asCartesianCoordinate().equals(cart));
		assertTrue(sph.asCartesianCoordinate().asSphericCoordinate().equals(sph));
	}
	
	@Test
	public void testEqualsNegativeCase(){
		assertFalse(sph.equals(cart));
		assertFalse(sph.isEqual(cart));
		assertFalse(sph.asCartesianCoordinate().equals(cart));
		assertFalse(cart.asSphericCoordinate().isEqual(sph));
	}
	
	@Test
	public void testCartesianCoordinateDistance() {
		CartesianCoordinate cart2 = new CartesianCoordinate(5, 2.5, 4);
		assertEquals(cart2.getDistance(cart), 3, EPSILON);
		assertEquals(cart.getDistance(cart2), 3, EPSILON);
		SphericCoordinate sph2 = cart2.asSphericCoordinate();
		assertEquals(cart.getCartesianDistance(sph2), 3, EPSILON);
	}
	
	
}
