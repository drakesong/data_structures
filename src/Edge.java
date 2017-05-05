import java.lang.Comparable;
//Created by Professor Justin Li

public class Edge {

	private Node parent;
	private Node child;
	private int weight;

	public Edge(Node parent, Node child, int weight) {
		this.parent = parent;
		this.child = child;
		this.weight = weight;
		this.parent.addEdge(this);
	}

	public Node getParent() {
		return this.parent;
	}

	public Node getChild() {
		return this.child;
	}

	public int getWeight() {
		return this.weight;
	}
}
