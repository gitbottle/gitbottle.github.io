package map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap <K,V> extends AbstractMap <K,V>{
	ArrayList <MapEntry<K,V>> table = new ArrayList<>();
	
	public UnsortedTableMap() {};
	
	public int size() {
		return table.size();
	}
	
	private int findIndex (K key) {
		int n= table.size();
		for(int i=0; i<n; i++) {
			if (table.get(i).getKey().equals(key))
				return i;
		}
		return -1;
	}
	
	public V get(K key) {
		int i= findIndex(key);
		if (i==-1) return null;
		else return table.get(i).getValue();
	}
	
	public V put (K key, V value) {
		int i = findIndex(key);
		if(i==-1) {
			table.add(new MapEntry<> (key,value));
			return null;
		}
		else return table.get(i).setValue(value);
	}
	
	public V remove(K key) {
		int i=findIndex(key);
		if(i==-1) return null;
		V val= table.get(i).getValue();
		if (i!=table.size()-1) 
			table.set(i, table.get(table.size()-1)); //swapping the entry to be removed with the last entry--making sure that there is no null entry in the middle of the array
		table.remove(size()-1);
		return val;
	}
	@Override
	public Iterable <Entry<K,V>> entrySet(){
		return new EntryIterable();
	}
	
	private class EntryIterable implements Iterable<Entry<K,V>>{
		public Iterator<Entry<K,V>> iterator(){
			return new EntryIterator();
		}
		
	}
	
	public class EntryIterator implements Iterator<Entry<K,V>>{
		private int i=0;
		
		public boolean hasNext() {
			return i<table.size();
		}
		
		public Entry<K,V> next(){
			if(i>=table.size()) throw new NoSuchElementException ("no next element");
			return table.get(i++);
		}
	}
	
}
