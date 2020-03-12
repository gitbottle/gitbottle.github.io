package priorityqueue;

import java.util.Comparator;
public abstract class AbstractPriorityQueue2 <K , V> implements PriorityQueue <K,V>{
	//nested Entry- Entry is an interface so you need to implement it in order to use it.
	public static class PQEntry <K,V> implements Entry <K,V>{
		private K key;
		private V value;
		
		public PQEntry (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey () {
			return key;
		}
		public V getValue() {
			return value;
		}
		
		//setters may not be necessary because once an entry is created, it does not change.
		//it is removed or replaced by another new entry node.
		//also the Entry interface does not require setters to be implemented.
	}
	
	//field of AbstrctPriorityQueue
	private Comparator <K> comp;// we put in K here instead of V because we will be comparing keys to determine priority.
	
	//constructor for AbstractPriorityQueue- protected so subclasses can use this constructor.
	
	protected AbstractPriorityQueue2 (Comparator <K> c) { // anything that extends Comparator can be passed in as parameter
		//so you can make your own class that extends Comparator and compare key to your own liking.
		comp = c;
	}
	//if you do not want to make your own Comparator class then use this DefaultComparator created for you. It uses natural ordering by using Comparable interface.
	protected AbstractPriorityQueue2 () {
		this (new DefaultComparator <K> ());//when passed in with above, combined sentence will be
		//Comparable <K> c = new DefaultCamparator<>(); but you specify K here because you are separating them, so you want to give them more details and context.
		
	}
	
	protected int compare (Entry <K,V> a, Entry<K,V> b) {//this one tells AbstractPriorityQueue class to invoke Comparator comp's compare method
		//by specifying/setting what can be compared with: Entry and Entry. AbstractPriorityQueue does not have
		//a compare method so it relies a Comparator object comp field to be able to do so.
		return comp.compare(a.getKey(), b.getKey());
	}
	
	protected boolean checkKey(K key) {
		try {
			return comp.compare(key, key) == 0;
		}catch (ClassCastException c) {
			throw new IllegalArgumentException ("Incompatible key");
		}
	}
	
	
	
	
	/*
	unimplemented methods to be implemented in HeapPriorityQueue class. 
	int size();
    boolean isEmpty();
    Entry<K, V> insert(K key, V value)  throws IllegalArgumentException;
    Entry<K, V> min();
    Entry<K, V> removeMin();
    */
}
