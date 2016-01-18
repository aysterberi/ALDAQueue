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
