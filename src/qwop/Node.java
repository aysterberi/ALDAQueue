package qwop;

/**
 * A simple node capable of pointing to data and another node
 * <p>
 * Copyright (C) Billy G. J. Beltran & Joakim Berglund
 * Contact details: billy@caudimordax.org, joakimberglund@live.se
 */

class Node<T> {

	public Node next;
	public T data;

	/**
	 * Initializes a node with no next reference.
	 *
	 * @param data a reference to the data node will hold
	 */
	public Node(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return data.toString();
	}
}
