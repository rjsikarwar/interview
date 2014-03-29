package com.ask.interview.second;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.ask.interview.second.Graph;

import junit.framework.TestCase;

public class TestGraph extends TestCase {

	public void testGraphCreationAddEdge() {
		Graph g = new Graph();
		g.addEdge("AB5");
		g.addEdge("BC5");
	}
	
	public void testGraphCreationAddEdges() {
		Graph g = new Graph();
		g.addEdges("AB5", "BC5");
	}
	
	private Graph setupGraph() {
		Graph g = new Graph();
		g.addEdges("AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7");
		return g;
	}
		
	public void testDistance() {
		Graph g = setupGraph();
		assertEquals(9, g.calculateRouteDistance("ABC"));
		assertEquals(5, g.calculateRouteDistance("AD"));
		assertEquals(13, g.calculateRouteDistance("ADC"));
		assertEquals(22, g.calculateRouteDistance("AEBCD"));
	}

	public void testShortestRoute() {
		Graph g = setupGraph();
		assertEquals("ABC9", g.calculateShortestRoute("AC"));
		assertEquals("BCEB9", g.calculateShortestRoute("BB"));
	}
	
	public void testRoutes() {
		Graph g = setupGraph();
		String[] paths = g.getPaths("CC", 30);
		assertEquals(9, paths.length);
		Set<String> pathSet = new HashSet<String>();
		Collections.addAll(pathSet, paths);
		assertTrue(pathSet.remove("CDC16"));
		assertTrue(pathSet.remove("CEBC9"));
		assertTrue(pathSet.remove("CDEBC21"));
		assertTrue(pathSet.remove("CDCEBC25")); 
		assertTrue(pathSet.remove("CEBCDC25"));
		assertTrue(pathSet.remove("CEBCEBC18"));
		assertTrue(pathSet.remove("CEBCEBCEBC27"));
		assertTrue(pathSet.remove("CDEBCEBC30"));
		assertTrue(pathSet.remove("CEBCDEBC30"));
		assertTrue(pathSet.isEmpty());
	}
	
}
