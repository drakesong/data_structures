import java.util.HashMap;
import java.util.Iterator;
//Created by Professor Justin Li

public class EightPuzzle extends Graph {

	private class State extends Node {

		private EightPuzzle puzzle;
		private boolean expanded;

		private State(String state, EightPuzzle puzzle) {
			super(state);
			this.puzzle = puzzle;
			this.expanded = false;
		}

		private String swap(int index) {
			int space = this.value.indexOf(" ");
			int first;
			int second;
			if (space < index) {
				first = space;
				second = index;
			} else {
				first = index;
				second = space;
			}
			return this.value.substring(0, first) +
				this.value.substring(second, second + 1) +
				this.value.substring(first + 1, second) +
				this.value.substring(first, first + 1) +
				this.value.substring(second + 1, 9);
		}

		public String getValue() {
			return this.value.substring(0, 3) + "\n" +
				this.value.substring(3, 6) + "\n" +
				this.value.substring(6, 9) + "\n";
		}

		public Iterator<Edge> getChildren() {
			if (!this.expanded) {
				// find the space
				int space = this.value.indexOf(" ");
				int row = space / 3;
				int col = space % 3;
				if (row - 1 >= 0) {
					String nextState = this.swap(space - 3);
					this.addEdge(new Edge(this, this.puzzle.getState(nextState), 1));
				}
				if (col - 1 >= 0) {
					String nextState = this.swap(space - 1);
					this.addEdge(new Edge(this, this.puzzle.getState(nextState), 1));
				}
				if (row + 1 < 3) {
					String nextState = this.swap(space + 3);
					this.addEdge(new Edge(this, this.puzzle.getState(nextState), 1));
				}
				if (col + 1 < 3) {
					String nextState = this.swap(space + 1);
					this.addEdge(new Edge(this, this.puzzle.getState(nextState), 1));
				}
				this.expanded = true;
			}
			return this.edges.iterator();
		}
	}

	public Node addNode(String value) {
		return null;
	}

	public Edge addEdge(Node parent, Node child, int weight) {
		return null;
	}

	private State getState(String state) {
		if (!this.nodes.containsKey(state)) {
			this.nodes.put(state, new State(state, this));
		}
		Node node = this.nodes.get(state);
		assert node instanceof State;
		return (State) node;
	}

	public Node getNode(String state) {
		return this.getState(state);
	}

	public Node getGoalNode() {
		return this.getState("12345678 ");
	}

	public static void main(String[] args) {
		EightPuzzle puzzle = new EightPuzzle();
		SearchAlgorithm algo = new SearchAlgorithm();

		Node start = puzzle.getGoalNode();
		//start = puzzle.getGoalNode(); // trivial
		start = puzzle.getNode("1234 5678"); // easy
		//start = puzzle.getNode("7245 6831"); // hard
		//start = puzzle.getNode("2831647 5"); // unsolvable!
		Node end = puzzle.getGoalNode();

		NodeList result;
		result = algo.BreadthFirstSearch(start, end);
		for (Iterator<Node> it = result.iterator(); it.hasNext(); ) {
			System.out.println(it.next().getValue());
		}
		System.out.println();

		/*
		// uncomment if you do the challenge question
		NodeList result;
		result = algo.UniformCostSearchWithPath(start, end);
		if (result != null) {
			for (Iterator<Node> it = result.iterator(); it.hasNext(); ) {
				System.out.println(it.next().getValue());
			}
			System.out.println();
		} else {
			System.out.println("Puzzle is unsolvable:");
			System.out.println(start.getValue());
		}
		*/
	}
}
