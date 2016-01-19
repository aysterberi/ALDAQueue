package qwop;

import alda.linear.ALDAQueue;

import java.util.Collection;
import java.util.Iterator;

public class LinkedQueue<E> implements ALDAQueue<E> {

	LinkedList<E> aList = new LinkedList<>();

	public void add(E element) {
		Node<E> tmp = new Node<>(element);
		aList.add(tmp);
	}

	public void addAll(Collection<? extends E> c)
	{
		//TODO

	}

	public E remove() {
		// TODO
		return null;
	}

	public E peek() {
		// TODO
		return null;
	}

	public void clear() {
		// TODO
	}

	public int size() {
		return aList.size();
	}

	public boolean isEmpty() {
		// TODO
		return false;
	}

	public boolean isFull() {
		// TODO
		return false;
	}

	public int totalCapacity() {
		//TODO
		return 0;
	}

	public int currentCapacity() {
		//TODO
		return 0;
	}

	public int discriminate(E element) {
		// TODO
		// move all E equal to e to the end of the queue, throw NPE if e ==
		// null, return n(E_moved)
		return 0;
	}

	/**
	 * Returns an iterator over elements of type {@code T}.
	 *
	 * @return an Iterator.
	 */
	@Override
	public Iterator<E> iterator() {
		//TODO
		return null;
	}
}
