package ds;
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

class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String argName) {
        name = argName;
        adjacencies = new ArrayList<Edge>();
    }

    public void addEdge(Edge e) {
        adjacencies.add(e);
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

}

class Edge {
    public final Vertex target;
    public final double weight;

    public Edge(Vertex argTarget, double argWeight) {
        target = argTarget;
        weight = argWeight;
    }
}


public class Dijkstra {

    public static void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            // Visit each edge exiting u

            for (Edge e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous = u;
                    vertexQueue.add(v);
                }

            }
        }
    }

    public static List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
            path.add(vertex);

        Collections.reverse(path);
        return path;
    }

    public static void main(String args[]) {

        Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(args[0]));
            String line;
            boolean inVertex = true;

            while ((line = in.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    inVertex = false;
                    continue;
                }
                if (inVertex) {
                    //store the vertices
                    int indexOfSpace = line.indexOf(' ');
                    String vertexId = line.substring(0, indexOfSpace);
                    String vertexName = line.substring(indexOfSpace + 1);
                    Vertex v = new Vertex(vertexName);
                    vertexMap.put(vertexId, v);
                } else {
                    //store the edges
                    String[] parts = line.split(" ");
                    String vFrom = parts[0];
                    String vTo = parts[1];
                    double weight = Double.parseDouble(parts[2]);
                    Vertex v = vertexMap.get(vFrom);
                    if (v != null) {
                        v.addEdge(new Edge(vertexMap.get(vTo), weight));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(in!= null)
                try {
                    in.close();
                } catch (IOException ignore) {
                }
        }

        //get a list of all the vertices
        Collection<Vertex> vertices = vertexMap.values();
        Vertex source = vertices.iterator().next();
        System.out.println("Computing paths from " + source);
        computePaths(source);
        for (Vertex v : vertices) {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            List<Vertex> path = getShortestPathTo(v);
            System.out.println("Path: " + path);
        }
    }
}