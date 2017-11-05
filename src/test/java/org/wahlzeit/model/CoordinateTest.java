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
		assertEquals(testCoordinate2.getDistance(testCoordinate), 3);
	}
	
	@Test
	public void testCoordinateDistance2() {
		Coordinate testCoordinate2 = new Coordinate(6, 1.7, 9.5);
		double dist = Math.sqrt(4*4 + 0.8 * 0.8 + 5.5*5.5);
		assertEquals(testCoordinate2.getDistance(testCoordinate), dist);
	}
	
	
	
}
