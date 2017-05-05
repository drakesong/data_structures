import java.util.Iterator;
import java.util.HashMap;
//Created by Professor Justin Li

public class Graph {
	HashMap<String, Node> nodes = new HashMap<String, Node>();
	
	public Node addNode(String value) {
		if (!this.nodes.containsKey(value)) {
			Node node = new Node(value);
			this.nodes.put(value, node);
		}
		return this.getNode(value);
	}
		

	public Edge addEdge(Node parent, Node child, int weight) {
		return new Edge(parent, child, weight);
	}

	public Node getNode(String value) {
		return this.nodes.get(value);
	}

	public void print() {
		System.out.println("digraph {");
		for (Iterator<Node> node_iter = this.nodes.values().iterator(); node_iter.hasNext(); ) {
			Node node = node_iter.next();
			for (Iterator<Edge> edge_iter = node.getChildren(); edge_iter.hasNext(); ) {
				Edge edge = edge_iter.next();
				System.out.format(
						"    \"%s\" -> \"%s\" [label=\"%d\"]\n",
						node.getValue(),
						edge.getChild().getValue(),
						edge.getWeight()
				);
			}
		}
		System.out.println("}");
	}
}
