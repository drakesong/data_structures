import java.util.Iterator;
import java.util.LinkedList;

public class SearchAlgorithm {

	public NodeList DepthFirstSearch(Node start, Node end) {
		NodeList stack = new NodeList();
		NodeList n = new NodeList();
		stack.add(start);
		n.add(start);
		NodePriorityQueue q = new NodePriorityQueue();
		while (!stack.isEmpty()) {
			Node a = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);
			Iterator<Edge> v = a.getChildren();
			if (a.equals(end)) {
				break;
			}
			while (v.hasNext()) {
				q.add(v.next().getChild(), 1);
			}
			n.add(q.peekNode());
			stack.add(stack.size(), q.poll());
		}
		return n;
	}

	public NodeList BreadthFirstSearch(Node start, Node end) {
		LinkedList<Node> queue = new LinkedList<Node>();
		NodeList n = new NodeList();
		int i = 0;
		queue.add(start);
		n.add(start);
		NodePriorityQueue q = new NodePriorityQueue();
		while (!queue.isEmpty()) {
			Node a = queue.get(queue.size() - 1);
			queue.remove(queue.size() - 1);
			Iterator<Edge> v = a.getChildren();
			if (a.equals(end)) {
				break;
			}
			while (v.hasNext()) {
				q.add(v.next().getChild(), i);
			}
			if (q.peekNode() != start) {
				n.add(q.peekNode());
			}
			queue.add(queue.size(), q.poll());
			i++;
		}
		return n;
	}

	public NodeList UniformCostSearch(Node start, Node end) {
		NodeList n = new NodeList();
		NodePriorityQueue q = new NodePriorityQueue();
		q.add(start, 1);
		while (!q.isEmpty()) {
			Node a = q.poll();
			Iterator<Edge> v = a.getChildren();
			if (a.equals(end)) {
				n.add(end);
				break;
			}
			if (n.contains(a)) {
				continue;
			}
			n.add(a);
			while (v.hasNext()) {
				Edge curEdge = v.next();
				q.add(curEdge.getChild(), curEdge.getWeight());
			}
		}
		return n;
	}

	public NodeList UniformCostSearchWithPath(Node start, Node end) {
		// 0 point challenge question
		return new NodeList();
	}

}
