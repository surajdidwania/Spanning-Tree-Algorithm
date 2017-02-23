package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class DijsktraAlgo {

	public static void path(Vertex Source)
	{
		Source.dist = 0;
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		pq.add(Source);
		while(!pq.isEmpty())
		{
			Vertex latestnode = pq.poll();
			for(Edge e:latestnode.adj)
			{
			Vertex target1 = e.target;
			double weight = e.weight;
			int distance = (int) (latestnode.dist + weight);
			if(distance < target1.dist)
			{
				pq.remove(target1);
				target1.dist = distance;
				target1.predec = latestnode;
				pq.add(target1);
			}
			}
		}
	}
	public static List<Vertex> shortestpath(Vertex target)
	{
		List<Vertex> shortpath = new ArrayList<Vertex>();
		for(Vertex vertex=target;vertex!=null;vertex= vertex.predec)
			shortpath.add(target);
		
		Collections.reverse(shortpath);
		return shortpath;
	}
	
	public static void main(String[] args) {
		Map<String, Vertex> vertexMap1 = new HashMap<String, Vertex>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(args[0]));
            String read;
            boolean inVertex = true;

            while ((read = br.readLine()) != null) {
                if (inVertex) {
                 
                    int indexOfSpace = read.indexOf(' ');
                    String vertexId = read.substring(0, indexOfSpace);
                    String vertexName = read.substring(indexOfSpace + 1);
                    Vertex v = new Vertex(vertexName);
                    vertexMap1.put(vertexId, v);
                } else {
                  
                    String[] parts = read.split(" ");
                    String vFrom = parts[0];
                    String vTo = parts[1];
                    Double weight = Double.parseDouble(parts[2]);
                    Vertex v = vertexMap1.get(vFrom);
                    if (v != null) {
                        v.addEdge(new Edge(vertexMap1.get(vTo), weight));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
                    try {
						br.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}


        Collection<Vertex> vertices = vertexMap1.values();
        Vertex source = vertices.iterator().next();
        System.out.println("The single shortest paths from " + source);
        path(source);
        for (Vertex v : vertices) {
            System.out.println("Distance to " + v + " " + v.dist);
            List<Vertex> path = shortestpath(v);
            System.out.println("Path: " + path);
        }
	}
	
}
		
