package SpanTree;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class KruskalAlgo {
	public static  TreeSet alltheedges;
	public  int MAXIMUM = 50;
	public static  HashSet node[];
	public static Vector allthenewedges;
	
	public KruskalAlgo()
	{
		alltheedges = new TreeSet(new Edge());
		node = new HashSet[MAXIMUM];
		allthenewedges = new Vector(MAXIMUM);

	}
	
	public void kruskalmet()
	{
		try{int size1 = alltheedges.size();
		for(int i=0;i<size1;i++)
		{
			Edge currentedge = (Edge) alltheedges.first();
			if(alltheedges.remove(currentedge))
			{
				if(diffset(currentedge.from,currentedge.to ))
				{
					HashSet source;
					HashSet destination;
					int index;
					if(node[currentedge.from].size() > node[currentedge.to].size())
					{
						source = node[currentedge.to];
						destination = node[index = currentedge.from];
					}
					else
					{
						source = node[currentedge.from];
						destination = node[index = currentedge.to];
					}
					Object sourcearray[] = source.toArray();
					for(int k =0;k<sourcearray.length;k++)
					{
						if(source.remove(sourcearray[k]))
						{
							destination.add(sourcearray[k]);
							node[((Integer) sourcearray[k]).intValue()] = node[index];
						}
					}
					allthenewedges.add(currentedge);
				}
			}
			
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public boolean diffset(int from, int to)
	{
		return (!(node[from].equals(node[to])));
	}
	
	public void print()
	{
		int totalweight=0;
		System.out.println("Source Destination Weight" );
		while(!allthenewedges.isEmpty())
		{
			Edge e = (Edge) allthenewedges.firstElement();
			System.out.println(e.from + " " + e.to + " " + e.weight);
			totalweight = totalweight+ e.weight;
			allthenewedges.remove(e);
		}
		System.out.println("The total cost for the minimum spanning tree :" + totalweight);
	}
	
	
	public static void main(String[] args) {
		KruskalAlgo kg = new KruskalAlgo();
		Readdata rd = new Readdata(args[0],alltheedges,node);
		kg.kruskalmet();
		kg.print();

	}

}
