package qwop;

/**
 * A simple node capable of pointing to data and another node
 */
class Node<T> {

	public Node next;
	public T data;

	/**
	 * Initializes a node with no reference.
	 *
	 * @param data the data reference the node will hold
	 */
	public Node(T data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return data.toString();
	}
}
