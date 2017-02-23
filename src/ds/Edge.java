package ds;

public class Edge {
		public Vertex target;
		public double weight;
		public int from, to;
		Edge(Vertex target, double weight)
		{
			this.target = target;
			this.weight = weight;
		}
		Edge(int from,int to, int weight)
		{
			this.from = from;
			this.to= to;
			this.weight=weight;
		}
		public double weight()
		{
			return weight;
		}
		public Vertex either()
		{
			return target;
		}
}
