package linkedlist;

public class CircularLinkedList2 <E> {
	private static class Node <E>{
		private Node <E> next;
		private E element;
		public Node (E e, Node <E> n) {
			element=e;
			next= n;
		}
		
		public E getElement() {
			return element;
		}
		
		public Node <E> getNext(){
			return next;
		}
		
		public void setNext(Node <E> n){
			next= n;
			
		}
			
	}
	
	
	private int size = 0;
	private Node <E> tail = null;
	public int size () { return size;}
	
	public boolean isEmpty () {return size==0;}
	
	public E first () {
		if (isEmpty()) return null;
		return tail.getNext().getElement();
	}
	
	public E last (){
		if (isEmpty()) return null;
		return tail.getElement();
	}
	
	public void rotate (){
		if(tail!=null);
		tail = tail.getNext();
	}
	
	public void addFirst (E e) {
		if (isEmpty()) {
			tail = new Node <> (e, null);
			tail.setNext(tail);
		}else {
			Node<E> newest = new Node <>(e, tail.getNext());
			tail.setNext(newest);
		}
		
		size++;
	}
	
	public void addLast (E e) {
		addFirst (e);
		tail= tail.getNext();
	}
	
	public E removeFirst() {
		if(isEmpty()) {
			return null;
		}else {
			Node<E> head= tail.getNext();
			
			tail.setNext(head.getNext());
			size--;
			return head.getElement();
		}
		
	}
	
}
