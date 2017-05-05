import java.lang.Comparable;
import java.util.HashMap;

public class NodeNodeMap {

	private HashMap<Node, Node> map = new HashMap<Node, Node>();

	public void put(Node key, Node value) {
		this.map.put(key, value);
	}

	public int size() {
		return this.map.size();
	}

	public boolean isEmpty() {
		return this.map.isEmpty();
	}

	public boolean containsKey(Node key) {
		return this.map.containsKey(key);
	}

	public Node get(Node key) {
		return this.map.get(key);
	}

}
