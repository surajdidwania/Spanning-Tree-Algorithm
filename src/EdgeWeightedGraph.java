import java.util.Stack;

import SpanTree.Edge;

public class EdgeWeightedGraph{
	private final int V;
	private int E;
	private Bag<Edge>[] adj;
	
	public EdgeWeightedGraph(int V)
	{
		if(V < 0) throw new IllegalArgumentException("Vertex cannot be nagative");
		this.V = V;
		this.E = 0;
		adj = (Bag<Edge>[]) new Bag[V];
		for(int v = 0; v<V;v++){
			adj[v] = new Bag<Edge>();
		}
		
	}
	
	public EdgeWeightedGraph(Input input) {
        this(input.readInt());
        int E = input.readInt();
        for (int i = 0; i < E; i++) {
            int v = input.readInt();
            int w = input.readInt();
            double weight = input.readDouble();
            Edge e = new Edge(v, w, weight);
            addEdge(e);
        }
    }
	public EdgeWeightedGraph(EdgeWeightedGraph G)
	{
		this(G.V());
		this.E = G.E();
		for(int v= 0 ;v<G.V();v++)
		{
			Stack<Edge> reverse = new Stack<Edge>();
				for(Edge e: G.adj[v])
				{
					reverse.push(e);
				}
			for (Edge e : reverse) {
                adj[v].add(e);
            }
		}
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public 	void addEdge(Edge e)
	{
		int v = e.either();
		int w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	public Iterable<Edge> edges()
	{
		Bag<Edge> list = new Bag<Edge>();
		for(int v=0;v<V;v++)
		{
			int loop=0;
			for(Edge e: adj(v))
			{
				if(e.other(v)>v)
				{
					list.add(e);
				}
				else if(e.other(v) == v)
				{
					if(loop%2 == 0) list.add(e);
					loop++;
				}
			}
		}
		return list;
	}
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append(V + " " +E + '\n');
		for(int v= 0;v<v ;v++)
		{
			s.append(V + " ");
			for(Edge e:adj(v))
			{
				s.append(e+ " ");
			}
			System.out.println();
		}
		return s.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Input input = new Input();
		EdgeWeightedGraph G = new EdgeWeightedGraph(input);
		StdOut.println(G);
		
	}

}
