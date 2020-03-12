package sorting;
import list.List;
import linkedlist.DoublyLinkedList;
import priorityqueue.PriorityQueue;

public class PQSort {
	/*
	 * sorts array of type T
	 * @param <T> element type
	 * key is the element that will be compared. 
	 */
	//This is saying that it will take class that implements PriorityQueue. Key will be
	//the element we are comparing in this method. ? value can be anything. In PriorityQueues,
	//we do not compare the value, we determine priority based on the numerical key. 
	public static <T> void pqSort (T[] data, PriorityQueue <T, ?> priorityqueue) {
		//T[]data will be storing the keys
		int n = data.length;
		//phase 1- transferring data from data array to priorityqueue
		for (int i = 0; i<n; i++) {
			T element = data[i];
			priorityqueue.insert(element, null);
		}
		//phase 2 - finding the min in priorityqueue than transferring the min to data array
		for (int i = 0; i<n; i++) {
			T element = priorityqueue.removeMin().getKey();//again, element is the key
			data[i] = element;
		}
	}
	/*
	 * sorts DoublyLInkedList
	 * @param<T>
	 */
	public static <T> void pqSort (DoublyLinkedList <T> data, PriorityQueue<T, ?> priorityqueue) {
		int n = data.size();
		for (int j=0; j< n; j++) {
			T element = data.removeFirst();
			priorityqueue.insert(element, null);
		}
		
		for (int j=0; j<n; j++) {
			T element= priorityqueue.removeMin().getKey();
			data.addLast (element); 
		}
	}
	
	/*
	 *Sorts a List
	 */
	public static <T> void pqSort (List <T> data, PriorityQueue <T, ?> priorityqueue) {
		int n = data.size();
		for (int j = 0; j< n ; j++) {
			T element = data.get(j); // the element is Entry
			priorityqueue.insert(element, null);
		}
		for (int j = 0; j < n; j++) {
			T element = priorityqueue.removeMin().getKey();//ProrityQueue uses Entry interface. Element is the Entry. You are getting a key of entry.
			data.set (j, element);
		}
	}
	
	
	
}
