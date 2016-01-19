/*
  Copyright (C) Billy G. J. Beltran & Joakim Berglund
 */
package qwop;

import java.util.NoSuchElementException;

/*
**
* A simple attempt at a linked list structure.
*
*
 */
public class LinkedList<E> {

	private Node<E> first = null;
	private Node<E> last = null;
	private int size = 0;

	/**
	 * Adds a node to the list irrespective if the list is empty or not.
	 * If the list is empty, the node reference is stored as first
	 *
	 * @param node
	 */
	public void add(Node<E> node) {
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
	public Node<E> peek() {
		return first;
	}

	/**
	 * Returns the first element in the list and removes it.
	 *
	 * @return if the list is empty, this is null, else the first element.
	 */
	public Node<E> remove() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		Node<E> luckyNode = first; //keep a reference to the first
		first = first.next; //replace our ref. to the first element with the second
		size--;
		return luckyNode;
	}

	public int size() {
		return size;
	}

	public void removeAfter(Node<E> node) {
		if (node.next != null) {
			node.next = node.next.next;
		}
		size--;
	}

	public void clear() {
		first = null;
		last = null;
		size = 0;
	}

	public Node<E> getFirst() {
		return first;
	}

	public Node<E> getLast() {
		return last;
	}

	public void insertAfter(Node<E> node, Node<E> newNode) {
		newNode.next = node.next; // point new node header to old node's
		node.next = newNode; // point old node to our newly inserted node
		size++;
	}

}
