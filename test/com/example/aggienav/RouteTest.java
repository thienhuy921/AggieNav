package com.example.aggienav;

import junit.framework.TestCase;

public class RouteTest extends TestCase {

	Route rt;
	BusStop[] stops;
	protected void setUp() throws Exception {
		super.setUp();
		rt = new Route();
		stops = new BusStop[3];
		stops[0] = new BusStop(98, 88, "one", 60);
		stops[1] = new BusStop(100, 105, "two", 120);
		stops[2] = new BusStop(100, 110, "three", 250);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAdd() {
		assertEquals("size of route should be 0", 0, rt.numStops());
		rt.add(stops[0]);
		assertEquals("size of route should be 1", 1, rt.numStops());
		rt.add(stops[1]);
		assertEquals("size of route should be 2", 2, rt.numStops());
		rt.add(stops[2]);
		assertEquals("size of route should be 3", 3, rt.numStops());
		BusStop iter = rt.getFirst();
		assertEquals("first should equal stops[0]", stops[0], iter);
		iter = iter.getNext();
		assertEquals("next should equal stops[1]", stops[1], iter);
		iter = iter.getNext();
		assertEquals("next should equal stops[2]", stops[2], iter);
		iter = iter.getNext();
		assertEquals("next should equal stops[0]", stops[0], iter);
		//fail("Not yet implemented");
	}

}
