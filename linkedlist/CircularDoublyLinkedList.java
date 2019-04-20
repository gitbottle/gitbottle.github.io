package linkedlist;


public class CircularDoublyLinkedList <E> {
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
	
	private Node <E> tail = null;
	private int size= 0;
	
	public CircularDoublyLinkedList () { }
	
	public int size () {
		return size;
	}
	
	public boolean isEmpty () {
		return size==0;
	}
	
	public E first () {
		if(isEmpty ()) return null;
		return tail.getNext().getElement();
	}
	
	public E last () {
		if(isEmpty ()) return null;
		return tail.getElement();
	}
	
	public void rotate () {
		if (tail!=null) {
			tail = tail.getNext();
		}
	}
	
	private void rotateBackward () {
		if (tail!=null) {
			tail= tail.getPrev();
		}
	}
	
	
	public void addFirst (E e) {
		if (size==0) {
			tail = new Node <>(e, null, null);
			tail.setNext(tail);
			tail.setPrev(tail);
			size++;
		}
		else {
			addBetween (e, tail, tail.getNext());
		}
		
	}
	
	public void addLast (E e) {
		addFirst (e);
		rotate ();
	}
	
	public E removeFirst() {
		if(isEmpty()) return null;
		if (size==1) {
			
			E result= tail.getNext().getElement();
			tail=null;
			return result;
		}
		else {
			return remove (tail.getNext());
		}
		
	}
	
	public E removeLast () {
		if(isEmpty()) return null;
		
		Node <E> temp = tail;
		if (size==1) {
			
			
			tail=null;
			return temp.getElement ();
		}
		else {
			rotateBackward ();//update the tail 
			return remove (temp);
		}
	}
		
	private void addBetween(E e, Node<E> predecessor, Node<E> successor)
    {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
		
	private E remove(Node <E> node)
    {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
	}
		
		
	
	
	
	
	
	
	
	
}
