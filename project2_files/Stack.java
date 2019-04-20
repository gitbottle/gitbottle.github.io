package project2_files;
public interface Stack<E> {
    /**Returns the number of elements in the stack */
    int size();

    /** returns true if the stack is empty, false otherwise */
    boolean isEmpty();

    /** Adds an element to the top of the stack */
    void push(E e);

    /** Returns, but does not remove, the element at the top of the stack, or null if empty */
    E top();

    /** Returns and removes the top element in the stack, or null if empty */
    E pop();
}
