package list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Dynamic array implementation of the ArrayList
 */
public class ArrayList <E> implements List <E>, Cloneable{
	
	public static final int CAPACITY = 10;
	
	private int size;
	private E []  data;
	
	public ArrayList () {
		this (CAPACITY);
	}
	
	public ArrayList (int n) {
		data = (E []) new Object [n];
	}
	
	//size is the current size, not capacity of the array
	//size is always one more (+1) of the last index: ex. 5 element array goes up to index 4 and the size is 5
	@Override
	public int size () {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size==0;
	}
	
	@Override
	public E get (int i) throws IndexOutOfBoundsException {
		checkIndex (i, size-1);
		return data[i];
	}
	
	@Override
	public E set (int i, E e) throws IndexOutOfBoundsException {
		checkIndex(i, size -1);
		E result = data[i];
		data[i] = e;
		return result;
	}
	
	@Override
	//add at the end of the array
	public void add (E e) {
		if (size==data.length) resize (size); // or resize (data.length)
		data[size++] = e;
	}
	
	@Override
	public void add (int i, E e) throws IndexOutOfBoundsException{
		checkIndex (i, size-1);
		if (size==data.length) resize (size);
		//shifting to the right, the loop should start from far right
		//k=size-1: the last data in the array. Copy this to box on the right.
		//k>=i because you want to keep the data at i and shift it right.
		for (int k = size-1; k>= i; k--) {
			data[k+1] = data[k];
		}
		
		data[i] = e;
		size++;
	}
	
	@Override
	public E remove (int i) throws IndexOutOfBoundsException {
		checkIndex(i, size-1);
		E result = data [i];
		//shifting to the left, the loop should start from far left.
		//k= i because you now have to fill this space once it is removed
		//k<size-1 because you want k to be one before the last data (size-1) of the array
		for (int k = i; k<size-1; k++) {
			data[k]= data[k+1];
		}
		size--;
		return result;
	}
	
	public void  resize (int capacity) {
		E [] temp  = (E []) new Object [capacity*2];
		for (int i=0; i<capacity; i++) {
			temp[i] = data[i];
		}
		
		data = temp;
	}
	
	public void checkIndex (int i, int n) throws IndexOutOfBoundsException{
		if (i> n || size<0) throw new IndexOutOfBoundsException ("there is no such element");
	}
	@Override
	public ArrayList <E> clone () {
				
		try {
				ArrayList <E> other = (ArrayList) super.clone();
				other.data = data.clone();
				return other;
				/*
				 * May have to do this:
				 * other.data = new E [data.length];
				 * for (int k=0; k< data.length; k++){
				 * 	other.data = (E) data[k].clone();
				 * }
				 */
				
				
		}catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//nonstatic inner class. This class has access to all the variables in ArrayList class
	private class ArrayIterator implements Iterator <E>{
		private int index = 0;
		private boolean removable= false; // refers to the item one step behind index.
		
		public boolean hasNext () {
			return index < size;
		}
		
		public E next () throws NoSuchElementException {
			if (index==size) throw new NoSuchElementException ("No such element");
			removable = true ; // saying that this data we are traversing exists and so remove method can be called on it.
			return data [index++];
	
		}
		
		//removes the data that iterator has JUST passed
		//So it can only be called after a call to next() 
		public void remove () throws IllegalStateException {
			if (index==size) throw new IllegalStateException ("Nothing to remove");
			ArrayList.this.remove (index-1);
			index--;
			removable = false; // since this current one has been removed already. 
		}
	}
	
	
	@Override
	//Everytime this is called, it creates a new Iterator object that can manipulate ArrayList fields and data	
	public Iterator <E> iterator (){
		return new ArrayIterator ();
	}
	//DoublyLinkedList next method: update to next then return
	//DoublyLinkedList remove method: delete the current
	//ArrayList next method: return then update to next.
	//ArrayList remove method: backtrack with minus one.
	private class ArrayListIterator2 implements Iterator <E>{
		private int index=0;
		private boolean removable = false;
		
		public boolean hasNext(){
			return index<size;
		}
		
		public E next () throws NoSuchElementException {
			if (index==size) throw new NoSuchElementException ("No more");
			removable = true;
			return data[index++];
		}
		
		public void remove () throws IllegalStateException {
			if (!removable) throw new IllegalStateException("Nothing to remove");
			ArrayList.this.remove(index-1);
			index--;
			removable = false;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
