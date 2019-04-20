package linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList <E> implements Iterable <E>{
	
	//nested node class. static: Node class has NO access to anything in DoublyLinkedList class. But outer
	//class can always access the inner class.
	private static class Node <E> {
		private E element;
		private Node <E> prev;
		private Node <E> next;
		
		public Node (E e, Node <E> p, Node <E> n) {
			element = e;
			prev = p;
			next = n;
		}
		
		//getters
		public E getElement () {
			return element;
		}
		
		public Node <E> getPrev(){
			return prev;
		}
		
		public Node <E> getNext (){
			return next;
		}
		//setters
		
		public void setPrev(Node <E> p) {
			prev= p;
		}
		
		public void setNext(Node <E> n) {
			next= n;
		}
	}
//doubly linkedlist has two null sentinel values header and trailer
	
	private Node <E> header = null;
	private Node <E> trailer = null;
	private int size = 0;
	
	public DoublyLinkedList () {
		header = new Node <> (null, null, null); //last element is null because trailer is not set up yet
		trailer = new Node <> (null, header, null);
		header.setNext(trailer);
	}; 
	
	public int size () {
		return size;
	}
	
	public boolean isEmpty () {
		return size==0;
	}

	
	public E first () {
		return header.getNext().getElement ();
	}
	
	public E last () {
		return trailer.getPrev().getElement ();
	}
	
	public void addFirst (E e) {
		addBetween (e, header, header.getNext());
	}
	
	public void addLast (E e) {
		addBetween (e, trailer.getPrev(), trailer);
	}
	
	public E removeFirst () {
		if (isEmpty ()) return null;
		return remove (header.getNext());
	}
	
	public E removeLast () {
		if (isEmpty ()) return null;
		return remove (trailer.getPrev());
	}
	
	//For addBetween and remove methods, there is no need to check whether empty. 
	//The parameter passed in already shows that the list is not empty.
	//there is no need to set tail and head equal in case it is the last element because header and trailer nodes will always be there
	private void addBetween (E e, Node <E>p, Node <E> n) {
		
		Node <E> newest = new Node <> (e, p, n);
		p.setNext(newest);
		n.setPrev(newest);
		
		size++;
	}
	
	private E remove (Node <E> node) {
		Node <E> predecessor = node.getPrev();
		Node <E> successor = node.getNext();
		
		predecessor.setNext(node.getNext());
		successor.setPrev(node.getPrev());
		size--;
		
		return node.getElement ();
	}
	
	//nested nonstatic LinkedListIterator class
	private class LinkedListIterator implements Iterator <E> {
		
		boolean removable = false;
		Node <E> current = header;
		
		@Override
		public boolean hasNext () {
			return current.next != trailer;
		}
	
		@Override
		public E next () throws NoSuchElementException {
			if (current.next == trailer) throw new NoSuchElementException ("No more");
			
			removable = true;
			//because the first one is sentinel node. Update the walk to the next spot with element
			current= current.next;
			return current.element;
		}
		
		@Override
		public void remove () throws IllegalStateException{
			if(!removable) throw new IllegalStateException("Nothing to remove");
			DoublyLinkedList.this.remove (current);
			removable = false;
		}
	}
	
	  
	    public Iterator<E> iterator() {
	        return new LinkedListIterator();
	}
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
}
