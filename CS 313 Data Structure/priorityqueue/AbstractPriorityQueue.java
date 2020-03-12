package priorityqueue;

import java.util.Comparator;

public abstract class AbstractPriorityQueue <K,V> implements PriorityQueue<K,V>{
	
	protected static class PQEntry<K,V> implements Entry<K,V>{
		private K key;
		private V value;
		public PQEntry (K key, V value) {
			this.key = key;
			this.value= value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		//setters may not be necessary because once an entry is created, it does not change.
		//it is removed or replaced by another new entry node. 
	}
	
	private Comparator <K> comp;
	
	protected AbstractPriorityQueue (Comparator<K> c) {
		comp = c;
	}
	
	protected AbstractPriorityQueue (){
		this (new DefaultComparator<K> ());
	}
	
	protected int compare (Entry <K,V> a, Entry <K,V> b ) {
		return comp.compare(a.getKey(), b.getKey());//you are comparing which has higher priority; you are not comparing the elements
	}
	
	protected boolean checkKey (K key) {
		try {
			return comp.compare(key, key) == 0;
		
		}catch (ClassCastException c) {
			throw new IllegalArgumentException ("Incompatible key");
		}
	}
	
	@Override
	public boolean isEmpty () {
		return size()==0;
	}
	
}
