package linkedlist;

public class SinglyLinkedList <E> implements Cloneable {
	private static class Node <E> {
		private E element;
		private Node <E> next;
		
		//constructor
		public Node (E e, Node <E> n) {
			element = e;
			next= n;
		}
		
		//getters
		public E getElement() {
			return element;
		}
		
		public Node <E> getNext (){
			return next;
		}
		
		public void setNext(Node <E> n) {
			next = n;
		}
		
	}
	
	private Node <E> head= null;
	private Node <E> tail= null;
	private int size=0;
	
	public SinglyLinkedList() {};
	
	public int size() { return size; }
	public boolean isEmpty() { 
		return size==0;
	} 	
	
	public E first () {
		if (isEmpty()) return null;
		return head.getElement();
	}
	
	public E last () {
		if (isEmpty()) return null;
		return tail.getElement ();
	}
	
	public void addFirst (E e) {
		head = new Node <> (e, head);
		if (size==0) tail=head;
		size++;
	}
	
	public void addLast (E e) {
		Node <E> newest = new Node <> (e, null);
		if (isEmpty()) {
			
			head = newest;
		}
		
		else {
			
			tail.setNext(newest);
			
		}
		
		tail = newest;
		size++;
	}
	
	public E removeFirst() {
		
		if (isEmpty()) return null;
		E result = head.getElement();
		head = head.getNext();
		size--;
		
		if (size==0) tail= null;
		return result;
	}

	//Equivalence testing: test 1. null 2. same type? Then casting 3. size 4. set two heads to traverse and test if each element is equal. 
	//Overrides the Object equals method
	
	
	@Override
	public boolean equals (Object o){
		if (o == null) return false;
		if (getClass()!= o.getClass()) return false;
		//At this point, Object o has passed the getClass() type test, meaning it is a SinglyLInkedList. We can perform casting
		SinglyLinkedList other = (SinglyLinkedList) o;
		if (size()!= other.size()) return false;
		Node <E> walkA = head;
		Node <E> walkB = other.head;
		
		while (walkA != null) {
			if (!walkA.getElement().equals(walkB.getElement())) return false; //calling the equals element that correspond to the type of the element
			walkA = walkA.getNext();
			walkB = walkB.getNext();
		}
		
		return true;
	}
	
	/*
	 * super.clone() returns Object. So casting necessary
	 *  
	 * clone () method will work as a deep copy for primitive types. However, it will not make a deep copy for reference types.
	 * For example
	 * int [] data = {2, 5, 8}
	 * int [] backup;
	 * backup = data.clone (); this works for primitive type arrays. If the elements in the array were reference types, the backup cells will reference the same objects referenced in data array.
	 * Deep copy code for reference types:
	 * Person []  guests = new Person [contacts.length];
	 * for (int k=0; k< contacts.length; k++){
	 * 		guests[k]= (Person) contacts[k].clone(); casting necessary because clone () returns Object. 
	 * 
	 * }
	 * 
	 * clone () in LinkedList
	 * clone() method is protected class. So you need to implement Cloneable interface to use this method. 
	 * clone () also throws CloneNotSupported Exception. Either catch it using try and catch block or throw it.
	 * 1. call clone () from the object class to create a new instance (performs a shallow copy)
	 * 2. perform a narrowing cast
	 * 3. then perform a deep copy using a for loop.
	 * 
	 */
	
	public SinglyLinkedList <E> clone (){
		try {
			
			SinglyLinkedList <E> other = (SinglyLinkedList <E>) super.clone (); //calling clone method in parent class Object
			//simply calling super () will call the constructor of the parent object.
			
			if (size>0) {
				other.head = new Node <> (head.getElement(), null);
				Node <E> walk = head.getNext(); // walk through the remainder of original list
				Node <E> otherTail = other.head; //remember the most recently created node
				while (walk!=null) {
					Node <E> newest = new Node<> (walk.getElement(), null); // the next new node
					otherTail.setNext(newest); //link previous node to this one
					walk= walk.getNext ();// walk through the remainder of original list
					otherTail = newest; //remember the most recently created node
				}
				
				
			}
			
			return other;
			
		} catch (CloneNotSupportedException e){
			e.printStackTrace ();
			return null;
		}
	}
	
	
	public E secondToLast (){
		Node<E> walk = head;
		for (int i=2; i<size; i++) {
			walk= walk.getNext();
		}
		
		return walk.getElement();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
}
