public class SinglyLinkedList {

	private class Node {
		int data;
		Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;

	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public void add(int element) {
		Node new_node = new Node(element, null);
		if (tail == null) {
			this.head = new_node;
		} else {
			this.tail.next = new_node;
		}
		this.tail = new_node;
	}

	public void print() {
		Node cur = this.head;
		while (cur != null) {
			System.out.print(cur.data);
			System.out.print(" ");
			cur = cur.next;
		}
		System.out.println();
	}

	public void remove_last(int element) {
		Node cur = this.head;
		Node temp = this.head;
		while (cur != null) {
			if (cur.data == element) {
				if (cur.next != null) {
					while (cur.next.data != element) {
						if (cur.next.next != null) {
							cur = cur.next;
						} else {
							this.head = temp.next;
							break;
						}
					}
				}
				if (cur.next.next != null) {
					cur.next.data = cur.next.next.data;
					cur.next.next = cur.next.next.next;
				}
			} else if (cur.next != null && cur.next.data == element) {
				cur.next = null;
				break;
			}
			cur = cur.next;
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.add(8);
		list.add(7);
		list.add(8);
		list.add(1);
		list.add(9);
		list.add(5);
		list.add(3);
		list.print(); // 8 7 8 1 9 5 3
		list.remove_last(8);
		list.print(); // 8 7 1 9 5 3
		list.remove_last(3);
		list.print(); // 8 7 1 9 5
		list.remove_last(8);
		list.print(); // 7 1 9 5
		list.remove_last(10);
		list.print(); // 7 1 9 5
	}
}
