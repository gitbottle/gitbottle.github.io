package linkedlist;

public class DoublyLinkedListSingleSentinel <E> {
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
	
	private Node <E> sentinel= null;
	private int size = 0;
	
	public DoublyLinkedListSingleSentinel () {
		sentinel= new Node<> (null, null, null);
	}
	
	
	public int size () {
		return size;
	}
	
	public boolean isEmpty () {
		return size==0;
	}
	
	public E first () {
		if(isEmpty ()) return null;
		return sentinel.getNext().getElement();
	}
	
	public E last () {
		if (isEmpty ()) return null;
		return sentinel.getPrev().getElement();
	}
	
	public void addFirst (E e) {
		addBetween (e, sentinel, sentinel.getNext());
	}
	
	public void addLast (E e) {
		addBetween (e, sentinel.getPrev(), sentinel );
	}
	
	
	public E removeFirst () {
		if (isEmpty ()) return null;
		return remove (sentinel.getNext());
	}
	
	public E removeLast () {
		if (isEmpty ()) return null;
		return remove (sentinel.getPrev());
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
