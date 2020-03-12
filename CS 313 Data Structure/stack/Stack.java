package stack;

public interface Stack <E>{
	/*
	 * Returns the number of elements in the stack
	 * @return number of elements in the stack
	 */
	int size();
	
	/*
	 * Tests whether the stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	boolean isEmpty();
	
	/*
	 * Adds an element to the top of the stack
	 * @param e element to add
	 */
	void push(E e);
	
	/*
	 * Returns but the remove the element at the top of the stack
	 * @return e element at the top of the stack, or null if empty
	 */
	E top ();
	
	/*
	 * Removes and returns the top item in the stack
	 * @Return E the top item of the stock or null if empty
	 */
	
	E pop ();
	
	
}
