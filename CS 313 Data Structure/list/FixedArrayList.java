package list;

public class FixedArrayList <E> implements List <E> {
	
	public static final int CAPACITY = 10;
	private int size;
	private E [] data;
	
	public FixedArrayList (int capacity) {
		data = (E []) new Object [capacity];
	}
	
	public FixedArrayList () {
		this (CAPACITY);
	}
	
	@Override
	public int size () {
		return size;
	}
	
	@Override
	public boolean isEmpty () {
		return size==0;
	}
	
	@Override
	public E get (int i) {
		
		checkIndex(i, size-1);
		return data[i];
	}
	
	@Override
	public E set (int i, E e) {
		checkIndex(i, size-1);
		E result = data[i];
		data[i]= e;
		return result;
	}
	
	@Override
	public void add (E e) {
		if (size==data.length) throw new IllegalStateException ("Array is full");
		data[size] = e;
		size++;
	}
	
	public void add (int i, E e) throws IndexOutOfBoundsException{
		checkIndex (i, size);
		if (size==data.length) throw new IllegalStateException ("Array is full");
		for (int k= size-1; k>=i; k--) {
			data[k+1]=data[k];
		}
		
		data[i] = e;
		size++;
	}
	
	@Override
	public E remove (int i) throws IndexOutOfBoundsException{
		checkIndex (i, size-1);
		E temp= data[i];
		for (int k=i; k<size-1; k++) {
			data[k] = data[k+1];
		}
		
		data[size-1] = null;
		size--;
		return temp;
	}
	
	/*
	 * Checks whether the index is valid
	 * @param index to be checked
	 * @ n top valid index
	 */
	private static void checkIndex (int index, int n) throws IndexOutOfBoundsException{
		if (index< 0 || index> n)
			throw new IndexOutOfBoundsException ("invalid index "+ index);
	}
	
	
}
