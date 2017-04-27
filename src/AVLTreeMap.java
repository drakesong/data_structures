public class AVLTreeMap implements Map {

	
	
	
	
	
	// I am attempting the extra credit.
	
	
	
	
	
	
	
	class Node {
		String key;
		String value;
		int height;
		// Node parent; delete this variable for extra credit
		Node left;
		Node right;

		public Node(String key, String value) {
			this.key = key;
			this.value = value;
			this.height = 1;
			// this.parent = null;
			this.left = null;
			this.right = null;
		}

		public int balance() {
			if (this.left != null && this.right != null) {
				return this.right.height - this.left.height;
			} else if (this.left == null && this.right != null) {
				return this.right.height;
			} else if (this.left != null && this.right == null) {
				return 0 - this.left.height;
			}
			return 0;
		}
	}

	private int size;
	private Node root;

	public AVLTreeMap() {
		size = 0;
		root = null;
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			size(node.left);
			size++;
			size(node.right);
		}
		return size;
	}

	public void put(String key, String value) {
		root = putRecur(root, key, value);
	}

	Node putRecur(Node root, String key, String value) {
		if (root == null) {
			root = new Node(key, value);
			return root;
		} else if (root.key.compareTo(key) > 0) {
			root.left = putRecur(root.left, key, value);
		} else if (root.key.compareTo(key) < 0) {
			root.right = putRecur(root.right, key, value);
		} else if (root.key.compareTo(key) == 0) {
			return root;
		}

		int a = 0;
		int b = 0;

		if (root.left != null) {
			a = root.left.height;
		}
		if (root.right != null) {
			b = root.right.height;
		}

		root.height = 1 + max(a, b);

		if (root.balance() < -1) {
			if (root.left.balance() > 0) {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			} else {
				return rightRotate(root);
			}
		} else if (root.balance() > 1) {
			if (root.right.balance() < 0) {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			} else {
				return leftRotate(root);
			}
		}

		return root;
	}

	Node rightRotate(Node z) {
		Node q = z.left.right;
		Node r = z;
		Node s = z.left;
		
		s.right = r;
		r.left = q;
		
		int a = 0;
		int b = 0;
		int c = 0;
		
		if (s.right.left != null) {
			a = s.right.left.height;
		}
		if (s.right.right != null) {
			b = s.right.right.height;
		}
		if (s.left != null) {
			c = s.left.height;
		}

		s.right.height = max(a, b) + 1;
		s.height = max(c, s.right.height) + 1;

		return (s);
	}

	Node leftRotate(Node z) {
		Node q = z.right.left;
		Node r = z;
		Node s = z.right;

		r.right = q;
		s.left = r;
		
		int a = 0;
		int b = 0;
		int d = 0;

		if (s.left.left != null) {
			a = s.left.left.height;
		}
		if (s.left.right != null) {
			b = s.left.right.height;
		}
		if (s.right != null) {
			d = s.right.height;
		}

		
		s.left.height = max(a, b) + 1;
		s.height = max(s.left.height, d) + 1;
		
		return s;

	}

	int max(int a, int b) {
		if (a > b) {
			return a;
		}
		return b; 
	}
	
	public String get(String key) {
		if (getRecur(root, key) != null) {
			return getRecur(root, key).value;
		} else {
			return null;
		}
	}

	Node getRecur(Node root, String key) {
		if (root == null || root.key == key) {
			return root;
		} else if (root.key.compareTo(key) > 0) {
			return getRecur(root.left, key);
		} else if (root.key.compareTo(key) < 0) {
			return getRecur(root.right, key);
		}
		return null;
	}

	public void print() {
		this.print(this.root, "", 0);
	}

	private void print(Node node, String prefix, int depth) {
		if (node == null) {
			return;
		}
		for (int i = 0; i < depth; i++) {
			System.out.print("  ");
		}
		if (!prefix.equals("")) {
			System.out.print(prefix);
			System.out.print(":");
		}
		System.out.print(node.key);
		System.out.print(" ");
		System.out.print(node.value);
		System.out.print(" (");
		System.out.print("H:");
		System.out.print(node.height);
		System.out.print(", B:");
		System.out.print(node.balance());
		System.out.println(")");
		this.print(node.left, "L", depth + 1);
		this.print(node.right, "R", depth + 1);
	}

	public static void main(String[] args) {
		AVLTreeMap map = new AVLTreeMap();
		String[] keys = { "7", "9", "6", "0", "4", "2", "1" };
		String[] values = { "seven", "nine", "six", "zero", "four", "two", "one" };
		for (int i = 0; i < keys.length; i++) {
			map.put(keys[i], values[i]);
			map.print();
			System.out.println();
		}
		for (int i = 0; i < keys.length; i++) {
			System.out.print(keys[i]);
			System.out.print(" ");
			System.out.println(map.get(keys[i]));
		}
	}
}
