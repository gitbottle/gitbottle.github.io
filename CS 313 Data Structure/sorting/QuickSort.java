package sorting;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;
import queue.Queue;
import queue.LinkedQueue;

import linkedlist.DoublyLinkedList;
import list.ArrayList;

public class QuickSort {
	
	public static <K> void quickSort (Queue<K> data, Comparator<K> comp) {
		int n= data.size();
		if(n<2) return;
		
		K pivot = data.first();
		Queue<K> less = new LinkedQueue<>();
		Queue<K> equal = new LinkedQueue<>();
		Queue<K> greater= new LinkedQueue<>();
		
		while (!data.isEmpty()) {
			K element= data.dequeue();
			int c = comp.compare(element, pivot );
			if (c<0) less.enqueue(element);
			else if (c==0) equal.enqueue(element);
			else greater.enqueue(element);
		}
		
		quickSort(less, comp);
		quickSort(greater,comp);
		
		while (!less.isEmpty())
			data.enqueue(less.dequeue());
		while(!equal.isEmpty())
            data.enqueue(equal.dequeue());
        while(!greater.isEmpty())
        	data.enqueue(greater.dequeue());
		
	}
	

	
	
	public static <K> void quickSort (DoublyLinkedList <K> data, Comparator <K> comp) {
		int n = data.size();
		if (n<2) return;
		
		K pivot = data.first();
		DoublyLinkedList<K> less = new DoublyLinkedList<>();
		DoublyLinkedList<K> equal = new DoublyLinkedList<>();
		DoublyLinkedList<K> greater = new DoublyLinkedList<>();
		
		while (!data.isEmpty()) {
			K element = data.removeLast();
			int c = comp.compare(element, pivot);
			if (c<0) less.addLast(element);
			else if (c==0) equal.addLast(element);
			else greater.addLast(element);
		}
		
		quickSort(less, comp);
		quickSort(greater,comp);
		
		while (!less.isEmpty())
			data.addLast(less.removeFirst());
		while (!equal.isEmpty()) 
			data.addLast(equal.removeFirst());
		while (!greater.isEmpty()) 
			data.addLast(greater.removeFirst());
		
	}
	
	public static <K> void quickSort (ArrayList<K> data, Comparator<K> comp) {
		
		
		
		int n= data.size();
		if (n<2) return;
		
		Random rand = new Random ();
		int pivot;
		pivot= rand.nextInt (n);
		
		ArrayList <K> less = new ArrayList<>();
		ArrayList <K> equal = new ArrayList<>();
		ArrayList <K> greater = new ArrayList<>();
		
		for (int i=0; i< n; i++){
			K element = data.get(i);
			int c = comp.compare(element, data.get(pivot));
			if (c<0) less.add(element);
			else if (c==0) equal.add(element);
			else greater.add(element);
		}
		
		quickSort (less, comp);
		quickSort (greater, comp);
		
		Iterator <K> lessIterator = less.iterator ();
		Iterator <K> equalIterator = equal.iterator ();
		Iterator <K> greaterIterator = greater.iterator ();

		int j = 0;

		while (lessIterator.hasNext()){
		    data.set (j, lessIterator.next());   
		    j++;
		}

		while (equalIterator.hasNext()){
		    data.set (j, equalIterator.next());   
		    j++;
		}

		while (greaterIterator.hasNext()){
		    data.set (j, greaterIterator.next());   
		    j++;
		}
		
	}
	
}
