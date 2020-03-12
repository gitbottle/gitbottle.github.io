package sorting;
import linkedlist.DoublyLinkedList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import list.ArrayList;
import java.util.Iterator;
import queue.Queue;
import priorityqueue.Entry;
import queue.LinkedQueue;

public class MergeSort {
	private MergeSort () {}
	
	 public static <K> void merge (K[] array1, K[] array2, K[]result, Comparator<K> comp) {
		 int i=0, j=0;
		 while(i+j<result.length) {
			 if (j==array2.length || //has reached the end of second array or
					 //have not reached the end of either array
					 //and element in the first array is smaller
					 (i<array1.length && comp.compare(array1[i], array2[j])<0))
				 result[i+j]= array1[i++];
			 else
				 result[i+j] = array2[j++];
		 }
	 }
	 
	
	public static <K> void mergeSort (K[] array, Comparator<K> comp) {
		int n= array.length;
		if(n<2) return;
		
		//divide
		int mid = n/2;
		K[] part1 = Arrays.copyOfRange(array, 0, mid);
		K[] part2= Arrays.copyOfRange(array, mid, n);
		
		//conquer
		mergeSort (part1, comp);
		mergeSort (part2, comp);
		merge (part1, part2, array, comp);
	}
	

	public static <K> void merge(Queue<K> q1, Queue<K> q2, Queue<K> q, Comparator<K> comp) {
		while (!q1.isEmpty()&& !q2.isEmpty()) {
			if(comp.compare(q1.first(), q2.first())<0)
				q.enqueue(q1.dequeue());
			else 
				q.enqueue(q2.dequeue());
		}
		
		while (!q1.isEmpty()) {//if we reached here, q2 is finished and we still have elements left in q1
			q.enqueue(q1.dequeue());
		}
		
		while (!q2.isEmpty()) {//if we reached here, q1 must be finished
			q.enqueue(q2.dequeue());
		}
	}
	

	public static <K> void mergeSort (Queue<K> queue, Comparator<K> comp){
		int n= queue.size();
		if (n<2) return;
		int mid= n/2;
		
		//divide
		Queue<K> part1 = new LinkedQueue<>();
		Queue<K> part2 = new LinkedQueue<>();
		
		for(int i=0; i<mid; i++) {
			part1.enqueue(queue.dequeue());
		}
		
		for(int j=mid; j<n; j++) {
			part2.enqueue(queue.dequeue());
		}
		
		//conquer
		mergeSort (part1, comp);
		mergeSort (part2, comp);
		merge (part1, part2, queue, comp);
	}

	
	
	
	
	
	
		 
}
