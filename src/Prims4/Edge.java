package Prims4;

public class Edge {

	public Double weight;
	public Vertex startvertex;
	public Vertex desvertex;

	public Edge(Double weight, Vertex startvertex, Vertex desvertex) {

		this.weight = weight;
		this.startvertex = startvertex;
		this.desvertex = desvertex;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Vertex getStartvertex() {
		return startvertex;
	}

	public void setStartvertex(Vertex startvertex) {
		this.startvertex = startvertex;
	}

	public Vertex getDesvertex() {
		return desvertex;
	}

	public void setDesvertex(Vertex desvertex) {
		this.desvertex = desvertex;
	}

}
