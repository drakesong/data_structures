import java.lang.Comparable;
import java.util.PriorityQueue;
//Created by Professor Justin Li

public class NodePriorityQueue {

	private class Item implements Comparable<Item> {
		public Node node;
		public int priority;
		private Item(Node node, int priority) {
			this.node = node;
			this.priority = priority;
		}
		public int compareTo(Item other) {
			if (this.priority != other.priority) {
				return this.priority - other.priority;
			} else {
				return this.node.getValue().compareTo(other.node.getValue());
			}
		}
	}

	private PriorityQueue<Item> pq = new PriorityQueue<Item>();

	public void add(Node node, int priority) {
		this.pq.add(new Item(node, priority));
	}

	public int size() {
		return this.pq.size();
	}

	public boolean isEmpty() {
		return this.pq.isEmpty();
	}
	
	public int peekPriority() {
		return this.pq.peek().priority;
	}
	
	public Node peekNode() {
		return this.pq.peek().node;
	}

	public Node poll() {
		return this.pq.poll().node;
	}

}
