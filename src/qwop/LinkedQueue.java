/*
  Copyright (C) Billy G. J. Beltran & Joakim Berglund
  Contact details: billy@caudimordax.org, joakimberglund@live.se
 */
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
        if (currentCapacity() < 1) {
            //no more space
            throw new IllegalStateException();
        }
        Node<E> tmp = new Node<>(element);
        tmp.data = element;
        aList.add(tmp);
    }

    public void addAll(Collection<? extends E> c) {
        if (c == null) {
            throw new NullPointerException();
        }
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
        if (element == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            return 0;
        }
        Iterator<E> i = iterator();
        LinkedList<E> lucky = new LinkedList<>();
        LinkedList<E> unlucky = new LinkedList<>();
        //populate our lists
        while (i.hasNext()) {
            E tmp = i.next();
            if (!(tmp == null)) {

                if (tmp.equals(element)) {
                    unlucky.add(new Node<>(tmp));
                } else if (!tmp.equals(element)) {
                    lucky.add(new Node<>(tmp));
                }
            }
        }
        lucky.merge(unlucky);
        aList = lucky;
        return unlucky.size();
    }

    @Override
    public String toString() {
        Iterator<E> itr = iterator();
        String s = new String("[");
        if (!itr.hasNext()) {
            return "[]";
        }
        if (size() == 1) {
            return s + itr.next() + "]";
        }

        while (itr.hasNext()) {
            s += itr.next();
            if (!itr.hasNext()) {
                return s += "]";
            }
            s += ", ";

        }
        return s;

    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        //This code should totally be in LinkedList.java but we're bound by the spec.
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
                if (isEmpty()) {
                    throw new NoSuchElementException();
                }
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
