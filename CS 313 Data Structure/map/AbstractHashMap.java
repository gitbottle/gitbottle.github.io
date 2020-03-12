package map;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHashMap <K, V> extends AbstractMap <K,V> {
	//fields
	private static final int DEFAULT_PRIME = 109345121;
	private static final int CAPACITY = 17;
	protected int n= 0;
	protected int capacity; //size of the fixed table
	private int prime;
	private long scale, shift;
	
	//constructors
	public AbstractHashMap (int capacity, int prime) {
		this.capacity = capacity;
		this.prime = prime;
		Random random = new Random ();
		scale = random.nextInt(prime-1)+1;//1 to prime-1
		shift = random.nextInt(prime); //0 to prime
		createTable ();
	}
	
	public AbstractHashMap (int capacity) {
		this (capacity, DEFAULT_PRIME);
	}
	
	public AbstractHashMap() {
		this (CAPACITY, DEFAULT_PRIME);
	}
	
	public int size () {
		return n;
	}
	
	public V get (K key) {
		return bucketGet(hashValue(key), key);
	}
	public V remove (K key) {return bucketRemove (hashValue(key), key);}
	public V put (K key, V value) {
		V returnValue = bucketPut (hashValue(key), key, value);
		if (n>capacity/2)
			resize (2*capacity-1);
		return returnValue;
	}
	
	//determines which bucket index of the table the Entry is part of. 
	private int hashValue (K key) {
		return (int)((Math.abs(key.hashCode()*scale + shift)%prime)%capacity);
	}
	
	private void resize (int newCapacity) {
		List<Entry<K,V>> buffer = new ArrayList<>();
		for (Entry<K,V> entry:entrySet())
			buffer.add (entry);
		
		capacity = newCapacity;
		createTable();
		n=0;
		for (Entry<K,V> entry:buffer)
			put(entry.getKey(), entry.getValue());
	}
	
	//must be implemented by subclass
	protected abstract void createTable ();
	protected abstract V bucketRemove (int h, K key);
	protected abstract V bucketGet (int h, K key);
	protected abstract V bucketPut (int h, K key, V value);
	
	
}
