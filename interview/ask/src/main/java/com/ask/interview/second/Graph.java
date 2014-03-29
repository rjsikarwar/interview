package com.ask.interview.second;

/**
 * This class can be used to build of a graph
 * and perform some basic operations on it.
 * 
 * The graph is constructed by calling the 
 * addEdge or addEdges methods. The Strings
 * to define an edge will contain 2 characters,
 * each character being the label for the 
 * node. After these 2 characters, there will
 * be an integer value that represents the
 * distance or length on the edge between
 * the nodes. The edges are directional. In
 * other words "AB" implies that you can
 * traverse from A to B but not from B to A.
 * You would have to have anther edge added
 * "BA" in order to go the other direction.
 * 
 * There are several methods available to 
 * get details about the graph.
 * 
 */
public class Graph {
	
	/**
	 * The format of the string is
	 *  1st Character = starting node name
	 *  2nd Character = ending node name
	 *  Integer = edge length
	 *  
	 * For example, the String "AB5" should
	 * create 2 nodes, each labeled "A" and
	 * "B" respectively with a distance between
	 * them of 5 units.
	 */
	public void addEdge(String edge) {
		throw new RuntimeException("Implement Me!!!");
	}
	
	/**
	 * Just like addEdge() but it does
	 * more than one at a time.
	 */
	public void addEdges(String... edges) {
		throw new RuntimeException("Implement Me!!!");
	}

	/**
	 * Each character in the String represents an edge
	 * traversal over which the sum of the edge lengths
	 * is to be accumulated.
	 * 
	 * The route is defined by providing a sequence of
	 * characters that represent the nodes of the path.
	 * 
	 * For example, if a graph had been created as
	 * "AB5", "BC2" then the return value for various
	 * paths would be:
	 * 
	 * "AB" --> 5
	 * "BC" --> 2
	 * "ABC" --> 7
	 * "ABCB" --> 9
	 */
	public int calculateRouteDistance(String routeToTake) {
		throw new RuntimeException("Implement Me!!!");
	}
	
	/**
	 * The format of the fromTo input string is 
	 *  1st Character = starting node name
	 *  2nd Character = ending node name
	 *  
	 * Any single shortest path from the starting node
	 * name to the ending node dame. If the graph had
	 * been created as "AB5", "BC2", "AD2", "DC5", and
	 * this method was called with "AC" then both paths
	 * "ABC7" and "ADC7" are of length 7 and either
	 * would be a valid return value.
	 * 
	 * The return value should be the node names followed
	 * by the length of the path.
	 */
	public String calculateShortestRoute(String fromTo) {
		throw new RuntimeException("Implement Me!!!");
	};

	/**
	 * The format of the string is 
	 *  1st Character = starting node name
	 *  2nd Character = ending node name
	 *  
	 *  As each edge is traversed, the length of the edge
	 *  should be accumulated to create a total distance 
	 *  for that route.
	 *  
	 *  All unique paths that go from the starting node to the
	 *  ending node which are shorter than the maximumDistance
	 *  should be counted.
	 *  
	 *  For example, if the graph is constructed as "AB5", "BC2",
	 *  "CD3", "BD6", "AC1", "AD9", then some valid paths for "AD"
	 *  are "ABCD10", "ABD11", "ACD4", "AD9".
	 *  
	 *  If the maximumDistance is set above 11, all 4 should be
	 *  returned. If set below 4, then nothing should be returned.
	 *  If set to 4, then "ACD4" should be returned, and so on.
	 */
	public String[] getPaths(String fromTo, int maximumDistance) {
		throw new RuntimeException("Implement Me!!!");
	}
	
}
