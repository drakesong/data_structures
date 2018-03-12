import java.util.Iterator;
import java.util.LinkedList;
//Created by Professor Justin Li

public class NodeList {

	private LinkedList<Node> list = new LinkedList<Node>();

	public int size() {
		return this.list.size();
	}

	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	public void add(Node node) {
		this.list.add(node);
	}

	public void add(int index, Node node) {
		this.list.add(index, node);
	}

	public Node get(int index) {
		return this.list.get(index);
	}

	public Node remove(int index) {
		return this.list.remove(index);
	}

	public boolean contains(Node node) {
		for (Iterator<Node> it = this.iterator(); it.hasNext();) {
			if (node.equals(it.next())) {
				return true;
			}
		}
		return false;
	}

	public Iterator<Node> iterator() {
		return this.list.iterator();
	}

}
