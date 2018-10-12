import java.util.ArrayList;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SAP {
	
	
	private final Digraph _g;
	
	private boolean[] _visited;

	// constructor takes a digraph (not necessarily a DAG)
	public SAP(Digraph G) {
		_g = G;
	}

	// length of shortest ancestral path between v and w; -1 if no such path
	public int length(int v, int w) {
		
//		ArrayList<boolean> = new ArrayList<boolean>(g.V());
		
		_visited = new boolean[_g.V()];
	
		
		for( boolean b : _visited)
		{
			StdOut.printf("V = %b\n",b );
		}
		
		
		
		
		return _visit(v,w,0);
	}
	
	private int _visit( int v, int w, int depth )
	{
		Iterable<Integer> neighbours = _g.adj(v);
		_visited[v] = true;

		for( Integer neighbour: neighbours )
		{
			if( neighbour == w ) {
				return depth;
			}
			else
			{
				int new_depth = depth + 1;
				return _visit( neighbour, w , new_depth);
			}
		}
		
		
		return -1;
		
	}

	// a common ancestor of v and w that participates in a shortest ancestral path;
	// -1 if no such path
	public int ancestor(int v, int w) {
		return 0;
	}

	// length of shortest ancestral path between any vertex in v and any vertex in
	// w; -1 if no such path
	public int length(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	// a common ancestor that participates in shortest ancestral path; -1 if no such
	// path
	public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
		return 0;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		

		
		StdOut.printf("V = %d, E = %d\n", G.V(), G.E());
		
		StdOut.printf("Graph = %s\n", G);

				
		SAP sap = new SAP(G);
		StdOut.printf("length = %d\n", sap.length(12,7));

//		while (!StdIn.isEmpty()) {
//			int v = StdIn.readInt();
//			int w = StdIn.readInt();
//			int length = sap.length(v, w);
//			int ancestor = sap.ancestor(v, w);
//			StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
//		}
	}
}