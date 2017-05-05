import java.util.Iterator;
//Created by Professor Justin Li

public class Main {

	public static void main(String[] args) {

		// create the graph
		Graph g = new Graph();

		// create the nodes first
		g.addNode("Z");
		g.addNode("Y");
		g.addNode("X");
		g.addNode("W");
		g.addNode("V");
		g.addNode("U");
		g.addNode("T");
		g.addNode("S");

		// create the edges
		g.addEdge(g.getNode("Z"), g.getNode("Y"), 1);
		g.addEdge(g.getNode("Y"), g.getNode("Z"), 1);
		g.addEdge(g.getNode("Z"), g.getNode("X"), 2);
		g.addEdge(g.getNode("X"), g.getNode("W"), 1);
		g.addEdge(g.getNode("X"), g.getNode("U"), 4);
		g.addEdge(g.getNode("W"), g.getNode("V"), 1);
		g.addEdge(g.getNode("V"), g.getNode("U"), 1);
		g.addEdge(g.getNode("U"), g.getNode("T"), 5);
		g.addEdge(g.getNode("V"), g.getNode("S"), 5);
		g.addEdge(g.getNode("U"), g.getNode("S"), 3);

		// print out the graph for verification
		g.print();
		System.out.println();

		SearchAlgorithm algo = new SearchAlgorithm();
		NodeList result;

		// depth first search
		result = algo.DepthFirstSearch(g.getNode("Z"), g.getNode("S"));
		for (Iterator<Node> it = result.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
		System.out.println();

		// breadth first search
		result = algo.BreadthFirstSearch(g.getNode("Z"), g.getNode("S"));
		for (Iterator<Node> it = result.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
		System.out.println();

		// uniform cost search
		result = algo.UniformCostSearch(g.getNode("Z"), g.getNode("S"));
		for (Iterator<Node> it = result.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
		System.out.println();

	}

}
