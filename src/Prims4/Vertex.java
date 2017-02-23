package Prims4;
import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
	private String name;
	private Double mindistance = Double.MAX_VALUE;
	private List<Edge> adjList;
	private Edge minEdge;
	

	public boolean visited;
	public Vertex previosvertex;

	public Vertex(String name) {
		this.name = name;
		this.adjList = new ArrayList<Edge>();
	}
	public Edge getMinEdge() {
		return minEdge;
	}

	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}
	public void addEdge(Edge e) {
		this.adjList.add(e);
	}

	public String toString() {
		return this.name;
	}

	public Double getMindistance() {
		return mindistance;
	}

	public void setMindistance(Double mindistance) {
		this.mindistance = mindistance;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviosvertex() {
		return previosvertex;
	}

	public void setPreviosvertex(Vertex previosvertex) {
		this.previosvertex = previosvertex;
	}

	public List<Edge> getAdjList() {
		return adjList;
	}

	@Override
	public int compareTo(Vertex v) {
		return Double.compare(this.mindistance, v.getMindistance());
	}

}
