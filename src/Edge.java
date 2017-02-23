
public class Edge implements Comparable<Edge>{
	private final int v,w;
	private final double weight;
	public Edge(int v, int w, double weight)
	{
		if(v<0) throw new IndexOutOfBoundsException("Vertex name cannot be negative");
		if(w<0) throw new IndexOutOfBoundsException("Vertex name cannot be negative");
		if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		this.v = v; 
		this.w =w;
		this.weight = weight;
		
	}
	public double weight()
	{
		return weight;
	}
	public int either()
	{
		return v;
	}
	public int other(int vertex )
	{
		if(vertex  == v) return w;
		if(vertex  == w) return v;
		else throw new IllegalArgumentException("Illegal endpoint");
	}
	public int compareTo(Edge that)
	{
		return Double.compare(this.weight,that.weight);
	}
	public String toString()
	{
		return String.format("%d-%d %.5f",v,w,weight);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Edge e = new Edge(12,34,5.67);
	}

}
