package sorting;

import priorityqueue.Entry;
import queue.LinkedQueue;
import queue.Queue;
import linkedlist.DoublyLinkedList;


public class BucketSort {
	
	public static void bucketSort (Queue<Integer> queue, int N) {
		int n = queue.size();
		if(n<2) return;
		Queue [] Bucket = new LinkedQueue [N];
		
		
		for (int i=0; i< n; i++) {
			int value= queue.dequeue();
			if (Bucket[value] == null) Bucket[i] = new LinkedQueue<>();
			Bucket[value].enqueue(value);
		}
		
		for (int j=0; j<N ; j++) {
			if(Bucket[j]!=null) {
				for(int k=0; k<Bucket[j].size(); k++) {
					queue.enqueue((Integer)Bucket[j].dequeue());
				}
			}
		}
		
	}
	
	
	public static void bucketSort (DoublyLinkedList<Integer> list, int N) {
		int n = list.size();
		if(n<2) return;
		Queue [] Bucket = new LinkedQueue[N];
		
		
		for(int i=0; i<n; i++) {
			int value = list.removeFirst();
			if (Bucket[value]==null) Bucket[value] = new LinkedQueue<>();
			Bucket[value].enqueue(value);
		}
		
		for (int j=0; j<N; j++) {
			if(Bucket[j]!=null) {
				for(int k=0; k<Bucket[j].size(); k++) {
					list.addLast((Integer)Bucket[j].dequeue());
				}
			}
		}
		
		
	}
	
	
	

	public static void bucketSortEntries (Queue <Entry <Integer,? extends Object>> queue, int N) {
		int n = queue.size();
		if(n<2) return;
		Queue [] Bucket = new LinkedQueue [N];
		
		
		for (int i=0; i< n; i++ ) {
			Entry entry = queue.dequeue();
			int value = (Integer) entry.getKey();
			if (Bucket[value]==null) Bucket[value] = new LinkedQueue<Entry<Integer, ?>>();
				Bucket[value].enqueue(entry);
		}
		
		for (int j=0; j<N; j++) {
			if (Bucket[j] != null) {
				for (int k=0; k< Bucket[j].size(); k++) {
					queue.enqueue((Entry<Integer, ?>) Bucket[j].dequeue());
				}
			}
		}
		
		
		
	}
	
	public static void bucketSortEntries (DoublyLinkedList <Entry<Integer, ? extends Object>> list, int N) {
		int n = list.size();
		if(n<2) return;
		Queue[] Bucket = new LinkedQueue [N];
		
		
		for(int i=0; i< n; i++) {
			Entry entry = list.removeFirst();
			int value = (Integer)entry.getKey();
			if(Bucket[value]==null) Bucket[value] = new LinkedQueue<Entry<Integer,?>>();
			Bucket[value].enqueue(entry);
		}
		
		for (int j=0; j<N; j++) {
			if(Bucket[j]!=null) {
				for (int k=0; k<Bucket[j].size();j++) {
					list.addLast((Entry<Integer,?>)Bucket[j].dequeue());
				}
			}
		}
		
		
	}
	
	
	
}
