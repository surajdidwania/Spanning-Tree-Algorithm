package Dijkstra;
/*****************************************************************************************
*Class Name: Dijkstra
*
*Dependencies: Edge.java Vertex.java
*
*			
*
*Description: Generic implementation of Djikstra Algorithm to find the shortest path from source to destination.
*			  The priority queue has been used in order to find the minimum of the unsettled sets.
*			We have taken from user the input and printed the shortest path from source to destination.
*			Input is in the form of no of vert in the graph and adjacency matrix.
*
*			Test case :
*			
*			Please input the number of vertices in your graph.
*			5
*			Please input the adjcaency matrix
*			0 19 0 7 0 19 0 4 11 0 0 4 0 15 13 7 11 15 0 5 0 0 13 5 0
*			Please enter the source and destination
*			2 5
*			Distance to 5: 16
*			Path: 2 -> 4 -> 5	
*			
*
*Return code: Shortest path from source to destination using Dijkstra algorithm.
*
*Author: Suraj Kumar Didwania <dsuraj@hawk.iit.edu>
*
*************************************************************************************************/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class DijkstraAlgo {
	final static int MAX_VALUE = 999;   //To define the infinity Value
	public static void computingpath(Vertex source)    //To compute the shortest path
	{
		source.setDist(0);				//Source distance to 0
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();  //PriorityQUEUE for the unsettled set
		pq.add(source);								//source into PQ
		while(!pq.isEmpty())
		{
			Vertex a = pq.poll();
			Edge aAdj[] = a.getAdj();
			for(Edge e : aAdj)
			{
				Vertex v = e.getTarget();
				int weight = e.getWeight();
				int distanceViaA = a.getDist() + weight;
				if(distanceViaA < v.getDist()){
					pq.remove(v);
					v.setDist(distanceViaA);
					v.setPredec(a);
					pq.add(v);
				}
			}
		}
	}
	public static List<Vertex> shorterpath(Vertex target){
		List<Vertex> path = new ArrayList<Vertex>();
		for(Vertex v = target; v != null; v = v.getPredec()){
			path.add(v);
		}
		Collections.reverse(path);
		return path;
	}
			
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the number of vertices in your graph.");
		int x = sc.nextInt();
		int[][] adj = new int[x][x];
		Vertex[] vertices = new Vertex[x];
		ArrayList<Edge> edges = new ArrayList<Edge>();
		int w = 0;
		String name ="";
		
		for(int i = 1; i <= x; i++){
			name = "" + i;
			vertices[i-1] = new Vertex(name);
		}
		System.out.println("Please input the adjaency matrix");
		for(int m=0;m<x;m++)
		{
			for(int n=0;n<x;n++)
			{
				adj[m][n] = sc.nextInt();
				if(adj[m][n]!=0)
				{ 
					w = adj[m][n];
					edges.add(new Edge(vertices[n],w));
				}
		}
			Edge[] edgeArray = new Edge[edges.size()];
			edges.toArray(edgeArray);
			vertices[m].setAdj(edgeArray);
			edges.clear();
		}
		System.out.println("Please enter the source and destination");
		int s = sc.nextInt();
		int d = sc.nextInt();
		Vertex destinat = vertices[d-1];
		Vertex source = vertices[s-1];
		DijkstraAlgo.computingpath(source);  
			System.out.println("Distance to " + destinat.getDist());
			List<Vertex> path = DijkstraAlgo.shorterpath(destinat);
			System.out.println("Path: " + path.toString().substring(1, path.toString().length() -1).replaceAll(",", " ->"));
	}
}



