package SpanTree;

/*****************************************************************************************
*Class Name: Edge
*
*Description: The CLass defines the edge by the taking the both the vertices and weight of the edge
*				It returns weight, from vertex and other vertex.
*				It compares 2 objects by comparing weight, from and to
*
*Parameters: The parameters are defined in the constructor
*			f: It defines from of the edge.
*			t: It defines to of the edge
*			weight: it defines the weight of the vertex.
*
*Author: Suraj Kumar Didwania <dsuraj@hawk.iit.edu>
*
*************************************************************************************************/
import java.util.Comparator;

public class Edge implements Comparator{
	public int from,to;
	public  int weight;
	public Edge()
	{
	}
	public Edge(int f, int t, int weight)
	{
		if(f<0) throw new IndexOutOfBoundsException("Vertex name cannot be negative");
		if(t<0) throw new IndexOutOfBoundsException("Vertex name cannot be negative");
		if (Double.isNaN(weight)) throw new IllegalArgumentException("Weight is NaN");
		this.from = f; 
		this.to =t;
		this.weight = weight;
		
	}
	public double weight()
	{
		return weight;
	}
	public int either()
	{
		return from;
	}
	public int other(int vertex )
	{
		if(vertex  == from) return to;
		if(vertex  == to) return from;
		else throw new IllegalArgumentException("Illegal endpoint");
	}
	public int compare(Object o1, Object o2)
	{
		//return Double.compare(this.weight,that.weight);
		int costA = ((Edge) o1).weight;
		int costB = ((Edge) o2).weight;
		int fromA = ((Edge) o1).from;
		int fromB = ((Edge) o2).from;
		int toA = ((Edge) o1).to;
		int toB = ((Edge) o2).to;
		
		if(costA <costB) return -1;
		else if (costA==costB && fromA==fromB && toA==toB)return(0);
	      else if (costA==costB)
	        return(-1);
	      else if (costA>costB)
	        return(1); 
	      else
	        return(0);
		
	}
	public String toString()
	{
		return String.format("%d-%d %.5f",from,to,weight);
	}
	public boolean equals(Object o)
	{
		Edge e = (Edge) o;
		return (weight == e.weight && from == e.from && to == e.to);
	}
	
	

}
