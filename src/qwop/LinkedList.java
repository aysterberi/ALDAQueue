package qwop;

/*
**
* A simple attempt at a linked list structure.
*
*
 */
public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;
	private int size = 0;

	/**
	 * Adds a node to the list irrespective if the list is empty or not.
	 *
	 * @param node
	 */
	public void add(Node<T> node) {
		if (first == null) {
			first = node;
			last = node;
		} else {
			last.next = node;
			last = node;
		}
		size++;
	}

	/**
	 * Returns the first element in the list without removing it.
	 *
	 * @return if the list empty, this is null, else the first element.
	 */
	public Node<T> peek() {
		return first;
	}

	/**
	 * Returns the first element in the list and removes it.
	 *
	 * @return if the list is empty, this is null, else the first element.
	 */
	public Node<T> remove() {
		Node<T> luckyNode = first; //keep a reference to the first
		first = first.next; //replace our ref. to the first element with the second
		size--;
		return luckyNode;
	}
	public void removeAfter(Node<T> node) {
		if (node.next != null) {
			node.next = node.next.next;
		}
		size--;
	}

	public void insertAfter(Node<T> node, Node<T> newNode) {
		newNode.next = node.next; // point new node header to old node's
		node.next = newNode; // point old node to our newly inserted node
		size++;
	}

}
