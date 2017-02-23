package SpanTree;

import java.util.ArrayList;

public class dijkstra {
	private static final int MAXIMUM = 5000;
	public int[] MainDijkstra(Graph G, int source)
	{
		
		int[] distance = new int[G.size()];
		int[] predecessor = new int[G.size()];
		boolean[] visitednode = new boolean[G.size()];
		
		for(int i=0;i<G.size();i++)
		{
			distance[i] = MAXIMUM;
			}
		distance[source] = 0;
		
		for(int i =0;i<distance.length;i++ )
		{
			final int u = extractmin(distance, visitednode);
			visitednode[u] = true;
		final int [] ne = G.neighbors(u);
		 for(int j=0;j<ne.length;j++)
		 {
			 final int v = ne[j];
			 final int d = distance[u] + G.getWeight(u,v);
			 if (distance[v] > d) {
				 distance[v] =d;
				 predecessor[v]=d;
			 }
		 }
	}
	return predecessor;
		
	}
	public int extractmin(int[] dis , boolean[] visit)
	{ int u = 9999;
		int v=-1;
		for(int i=0;i<dis.length;i++)
		{
			if(!visit[i] && dis[i]<u)
			{
				u = dis[i];
				v = i;
				}
		}
		return v;
		}
	public void PathPrinting(Graph G, int[] predecessor, int s, int e )
	{
		ArrayList path = new ArrayList();
		int x =e;
		while(x!=s)
		{
			path.add(0,G.getLabel(x));
			x = predecessor[x];
			
		}
		path.add(0,G.getLabel(s));
		System.out.println(path);
	}
	public static void main(String[] args) {
	

	}

}
