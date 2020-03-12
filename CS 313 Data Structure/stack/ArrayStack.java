package stack;
/*
 * Array-based stack implementation
 * @param <E> the type of the elements in the stack
 */
public class ArrayStack <E> implements Stack <E>{
	//instance variables of array-based stack
	public static final int CAPACITY = 1000;
	private E [] data;
	private int t= -1;//Since array starts at index 0. 
	
	public ArrayStack (int capacity) {
		data = (E[]) new Object [capacity];
	}
	public ArrayStack () {
		this(CAPACITY);
	}
	
	@Override
	public int size() {
		return t+1;// Since array starts at 0. For actual number of items, add 1
	}
	
	@Override
	public boolean isEmpty () {
		return t<0;
	}
	
	@Override
	public void push (E e) throws IllegalStateException {
		if (size() == data.length) throw new IllegalStateException ("Stack is full");
		data[++t]= e;
	}
	
	@Override
	public E top () {
		if (isEmpty()) return null;
		return data[t];
	}
	
	@Override
	public E pop () {
		if (isEmpty()) return null;
		E result= data[t];
		data[t]=null;
		t--;
		return result;
	}

}
