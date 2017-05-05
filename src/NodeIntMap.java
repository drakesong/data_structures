import java.lang.Comparable;
import java.util.HashMap;
//Created by Professor Justin Li

public class NodeIntMap {

	private HashMap<Node, Integer> map = new HashMap<Node, Integer>();

	public void put(Node key, Integer value) {
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

	public int get(Node key) {
		return this.map.get(key).intValue();
	}

}
