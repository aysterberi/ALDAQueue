package qwop;

public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;

	public void add(Node<T> node) {
		if (first == null) {
			first = node;
			last = node;
		} else {
			first.next = node;
			last = node;
		}
	}

	public void removeAfter(Node<T> node) {
		if (node.next != null) {
			node.next = node.next.next;
		}
	}

	public void insertAfter(Node<T> node, Node<T> newNode) {
		newNode.next = node.next; // point new node header to old node's
		node.next = newNode; // point old node to our newly inserted node
	}

}
