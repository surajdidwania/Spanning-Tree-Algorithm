package Prims4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgo {
		public List<Edge> edgelist;
		public List<Vertex> vertexlist;
		public PrimsAlgo()
		{
			edgelist = new ArrayList<>();
			vertexlist = new ArrayList<Vertex>();	
		}
	public void MST(Vertex sourcetarget)
	{
		PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>();
		for(Vertex vertex: this.vertexlist)
		{
			if(!vertex.isVisited())
		sourcetarget.setMindistance(0.0);
		pq.add(sourcetarget);
		while(pq.size()>0)
		{
			Vertex u = pq.poll();
			u.setVisited(true);
			for(Edge e : u.getAdjList())
			{
				Vertex q = e.getDesvertex();
				if(!q.isVisited())
				{
					if(e.getWeight() < q.getMindistance())
					{
						q.setMindistance(e.getWeight());
						q.previosvertex = u;
						q.setMinEdge(e);
						if(pq.contains(q)) pq.remove();
						pq.add(q);
					}
				}
			}
		}
		}
		
	}
	public void display()
	{
		for(Vertex vertex: vertexlist)
		{
			if(vertex.getMinEdge()!=null)
			{
				Edge e = vertex.getMinEdge();
				System.out.println("Edge" + e.getStartvertex()+ " " +e.getDesvertex());
				
			}
		}
	}
	public void addEdge(Edge e)
	{
		Vertex start = e.getStartvertex();
		Vertex destination = e.getDesvertex();
		this.vertexlist.get(vertexlist.indexOf(start)).addEdge(new Edge(e.getWeight(),start,destination));
		this.vertexlist.get(vertexlist.indexOf(destination)).addEdge(new Edge(e.getWeight(),destination,start));
	}
	public static void main(String[] args) {
		PrimsAlgo PA = new PrimsAlgo();
			Vertex vertexA = new Vertex("A");
		Vertex vertexB= new Vertex("B");
		Vertex vertexC= new Vertex("C");
		Vertex vertexD= new Vertex("D");
		Vertex vertexE= new Vertex("E");
		Vertex vertexF= new Vertex("F");
		Vertex vertexG= new Vertex("G");
		Vertex vertexH= new Vertex("H");
		Vertex vertexI= new Vertex("I");
		PA.addEdge(new Edge(4.0,vertexA,vertexB));
		PA.addEdge(new Edge(8.0,vertexA,vertexI));
		PA.addEdge(new Edge(11.0,vertexB,vertexI));
		PA.addEdge(new Edge(8.0,vertexB,vertexC));
		PA.addEdge(new Edge(7.0,vertexC,vertexD));
		PA.addEdge(new Edge(9.0,vertexD,vertexE));
		PA.addEdge(new Edge(10.0,vertexE,vertexF));
		PA.addEdge(new Edge(2.0,vertexF,vertexG));
		PA.addEdge(new Edge(1.0,vertexG,vertexH));
		PA.addEdge(new Edge(7.0,vertexH,vertexI));
		PA.addEdge(new Edge(2.0,vertexI,vertexC));
		PA.addEdge(new Edge(6.0,vertexI,vertexG));
		PA.addEdge(new Edge(4.0,vertexC,vertexF));
		PA.addEdge(new Edge(14.0,vertexD,vertexF));
				
		PA.MST(vertexA);
		
	}

}
