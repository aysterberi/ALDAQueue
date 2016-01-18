package qwop;

import alda.linear.ALDAQueue;

import java.util.Collection;
import java.util.Iterator;

public class LinkedQueue<E> implements ALDAQueue<E> {

	public void add(E element) {
	}

	public void addAll(Collection<? extends E> c)
	{
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
	}

	public int size() {
		return 0;
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
		return 0;
	}

	public int currentCapacity() {
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
		return null;
	}
}
