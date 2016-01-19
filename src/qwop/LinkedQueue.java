package qwop;

import alda.linear.ALDAQueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<E> implements ALDAQueue<E> {

	private final int totalCapacity;
	private LinkedList<E> aList = new LinkedList<>();

	public LinkedQueue(int totalCapacity) {
		if (totalCapacity <= 0) {
			throw new IllegalArgumentException();
		}
		this.totalCapacity = totalCapacity;
	}

	public void add(E element) {
		if (element == null) {
			throw new NullPointerException();
		}
		if (aList.size() < totalCapacity) {
			// make sure we're not adding more elements than fit
			Node<E> tmp = new Node<>(element);
			tmp.data = element;
			aList.add(tmp);
		}
	}

	public void addAll(Collection<? extends E> c) {
		if (c.size() > currentCapacity()) {
			throw new IllegalStateException();
			// make sure we're not adding more elements than fit
			// which is the right Exception to throw?
		}
		c.forEach(this::add); //lambda expr. to add

	}

	public E remove() {
		Node<E> tmp = aList.remove();
		return tmp.data;
	}

	public E peek() {
		Node<E> tmp = aList.peek();
		if (tmp == null) {
			return null;
		}
		return tmp.data;
	}

	public void clear() {
		aList.clear();
	}

	public int size() {
		return aList.size();
	}

	public boolean isEmpty() {
		return aList.size() == 0;
	}

	public boolean isFull() {
		return aList.size() == totalCapacity();
	}

	public int totalCapacity() {
		return totalCapacity;
	}

	public int currentCapacity() {
		return totalCapacity() - size();
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
		return new Iterator<E>() {
			Node<E> currNode = null;

			/**
			 * Returns {@code true} if the iteration has more elements.
			 * (In other words, returns {@code true} if {@link #next} would
			 * return an element rather than throwing an exception.)
			 *
			 * @return {@code true} if the iteration has more elements
			 */
			@Override
			public boolean hasNext() {
				return !isEmpty() && currNode != aList.getLast();
				// returns T when list is not empty and current node is not last
			}

			/**
			 * Returns the next element in the iteration.
			 *
			 * @return the next element in the iteration
			 * @throws NoSuchElementException if the iteration has no more elements
			 */
			@Override
			public E next() {
				if (currNode == null) {
					//set our node to the first in our list
					currNode = aList.getFirst();
					return currNode.data;
				}
				if (currNode.next == null) {
					//we ran out of nodes
					throw new NoSuchElementException();
				}
				//set our current node to the next one and return that data
				currNode = currNode.next;
				return currNode.data;
			}


		};
	}


}
