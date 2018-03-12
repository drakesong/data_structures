import java.lang.Comparable;
import java.util.Iterator;
import java.util.LinkedList;
//Created by Professor Justin Li

public class Node {

	LinkedList<Edge> edges = new LinkedList<Edge>();
	String value;

	public Node(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public void addEdge(Edge edge) {
		this.edges.add(edge);
	}

	public Iterator<Edge> getChildren() {
		return this.edges.iterator();
	}

	public int hashCode() {
		return this.value.hashCode();
	}

	public boolean equals(Object other) {
		if (other instanceof Node) {
			return this.getValue().equals(((Node) other).getValue());
		}
		return false;
	}
}
