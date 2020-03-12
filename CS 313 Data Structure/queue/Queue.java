package queue;

public interface Queue<E> {
    int size(); //number of elements in queue
    boolean isEmpty(); //true if queue is empty, false otherwise
    void enqueue(E e); //inserts an element to the end of queue
    E dequeue(); //returns and removes the first element
    E first(); //returns but does not remove the first element
}