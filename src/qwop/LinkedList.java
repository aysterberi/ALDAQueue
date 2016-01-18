package qwop;

import qwop.Node;

public class LinkedList<T> {

	private Node<T> first;
	private Node<T> last;

	public void add(Node<T> node);

	public void insertAfter(Node<T> node, Node<T> newNode) {
		newNode.next = node.next; // point new node header to old node's
		node.next = newNode; // point old node to our newly inserted node
	}

}
