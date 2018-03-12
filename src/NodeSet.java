import java.lang.Comparable;
import java.util.HashSet;
//Created by Professor Justin Li

public class NodeSet {

	private HashSet<String> set = new HashSet<String>();

	public void add(Node node) {
		this.set.add(node.getValue());
	}

	public int size() {
		return this.set.size();
	}

	public boolean isEmpty() {
		return this.set.isEmpty();
	}

	public boolean contains(Node node) {
		return this.set.contains(node.getValue());
	}

}
