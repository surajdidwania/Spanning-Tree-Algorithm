package SpanTree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Readdata {
	public TreeSet alltheedges;
	public int MAXIMUM=50;
	public HashSet node[];
	public Readdata(String filename, TreeSet alltheedges, HashSet[] node){
		this.alltheedges = alltheedges;
		this.node = node;
		try{
			int from,to,weight;
			FileReader file1 = null;
			file1 = new FileReader(filename);
			BufferedReader br = null;
			br = new BufferedReader(file1);
			String read = br.readLine();
				while(read!=null)
				{
					StringTokenizer st = new StringTokenizer(read," ");
				     from = Integer.valueOf(st.nextToken()).intValue();
				     to = Integer.valueOf(st.nextToken()).intValue();
				     weight = Integer.valueOf(st.nextToken()).intValue();
				     alltheedges.add(new Edge(from,to,weight));
				     if(node[from] == null)
				     {
				    	 node[from] = new HashSet(MAXIMUM);
				    	 node[from].add(new Integer(from));
				    	 
				     }
				     if(node[to]==null)
				     {
				    	 node[to] = new HashSet(MAXIMUM);
				    	 node[to].add(new Integer(to));
				     }
				     
				     read = br.readLine();
				}
				br.close();
				}catch(IOException e)
			{
					System.out.println(e);
			}
			
			}
}
