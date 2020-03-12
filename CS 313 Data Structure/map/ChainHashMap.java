package map;

import java.util.ArrayList;
import java.util.List;

public class ChainHashMap <K,V> extends AbstractHashMap <K,V> {
	//the overall table is a fixed array unlike its bucket, which is Arraylist of Entries.
	private UnsortedTableMap <K,V> [] table;
	
	public ChainHashMap () {super ();}
	public ChainHashMap (int cap) {
		super (cap);
	}
	
	public ChainHashMap (int cap, int prime) {
		super (cap, prime);
	}
	//called within superclass constructors and resize method
	protected void createTable () {
		table = (UnsortedTableMap <K,V> []) new UnsortedTableMap [capacity]; 
		//capacity is the size of the table, fixed.
	}
	
	protected V bucketGet (int h, K key) {
		UnsortedTableMap <K,V> bucket = table[h];
		if (bucket==null) return null;
		return bucket.get(key); //key of the Entry is the index of the bucket arraylist.
	}
	
	protected V bucketPut (int h, K key, V value) {
		UnsortedTableMap <K,V> bucket = table[h];
		if (bucket==null) {
			table[h] = new UnsortedTableMap<>();
			bucket = table[h];
		}
		
		int oldSize = bucket.size();
		V result = bucket.put(key, value);
		n+= (bucket.size() - oldSize); //if 0, there was no change. If 1, one item is added. 
		//0 means that something replaced an existing entry because the same key existed
		//1 means that a brand new entry was added instead of replacing the old one.
		return result;
	}
	
	protected V bucketRemove (int h, K key) {
		UnsortedTableMap<K,V> bucket = table[h];
		if (bucket==null) return null;
		int oldSize = bucket.size();
		V result = bucket.remove(key);
		n-= (oldSize - bucket.size()); //size may have decreased. If it did not, that means
		//there was no entry that matched the key. bucket.remove(key) simply returns null.
		return result;
	}
	
	public Iterable<Entry<K,V>> entrySet (){
		//snapshot iterator since it makes a copy - gets everything, all entries from every bucket that is not empty
		List <Entry<K,V>> buffer = new ArrayList<>(size());
		for (int h=0; h<capacity; h++) {
			if (table[h]!= null)
				for(Entry<K,V> entry: table[h].entrySet())
					buffer.add(entry);
		}
		return buffer;
	}
	
	
	
}
