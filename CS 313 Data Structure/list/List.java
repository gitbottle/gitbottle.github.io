package list;
/*
 * List defers from stack, queue, deques because list allows you to insert an item
 * in arbitrary positions, not just front and back.
 * Iterable
 * List
 * ArrayList
 */
public interface List <E> extends Iterable <E>{

	/*
	 * @return number of elements in the list
	 */
	int size ();
	
	/*
	 * @return true if list is empty, false otherwise
	 */
	boolean isEmpty ();
	
	/*
	 * @return element in the list
	 * @param index number
	 * @throws IndexOutofBoundsException
	 */
	E get(int i) throws IndexOutOfBoundsException;
	
	/*
	 * @return item before replacing
	 * @param i: index e: element
	 */
	E set (int i, E e) throws IndexOutOfBoundsException;
	
	/*
	 * Adds the specified element to the end of the list
	 */
	void add (E e);
	
	/*
	 * Adds the specified element at the specified location, shifts all that comes
	 * after to the right
	 * @throws IndexOutOfBoundsException
	 */
	void add (int i, E e) throws IndexOutOfBoundsException;
	
	/*
	 * @throws IndexOutOfBoundsException if the index is not in the range.
	 * Removes item at the specified location
	 */
	E remove (int i);
	
}
