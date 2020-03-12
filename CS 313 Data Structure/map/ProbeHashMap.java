package map;

import list.ArrayList;

public class ProbeHashMap <K,V> extends AbstractHashMap <K,V> {
	private final MapEntry <K,V> DEFUNCT = new MapEntry <>(null, null);
	private MapEntry<K,V> [] table;
	public ProbeHashMap () {super ();}
	public ProbeHashMap (int cap) {super (cap);}
	public ProbeHashMap (int cap, int prime) {super (cap, prime);}
	
	protected void createTable () {
		table = (MapEntry<K,V>[]) new MapEntry[capacity];
		
	}
	
	protected V bucketRemove (int h, K key) {
		int j= search (h, key);
		if (j<0) return null;
		V result = table[j].getValue();
		table[j] = DEFUNCT;
		n--;
		return result;
	}
	
	protected V bucketGet (int h, K key) {
		int j = search (h,key);
		if (j<0) return null;
		return table[j].getValue();
	}
	
	protected V bucketPut (int h, K key, V value) {
		int j = search (h, key);
		if (j>=0) //already exists
			return table[j].setValue(value);//returns the old value while updating it to new value
		int index = findSlot (h);
		table[index] = new MapEntry<>(key,value);
		n++;
		return null;
	}
	//checks to see if a new entry could be placed in the location
	private boolean isAvailable (int j) {
		return (table[j]== null || table[j]== DEFUNCT );
	}
	
	private int findSlot (int h) {
		int j =h;
		do {
			if (isAvailable (j)) return j;
			j = (j+1)% capacity;
		}while (j!=h);
		
		return -1;
	}
	private int search (int h, K key) {
		int j = h;
		do {	
			if (table[j]== null) return -1; //nothing was initiated
			if (table[j].getKey().equals(key)) return j; //found at index
			//otherwise, move to the next index
			j = (j+1) % capacity;
		}while (j!=h); //if j==h, that means it circled around the array.
		return -2;
	}
	
	public Iterable <Entry<K,V>> entrySet (){
		ArrayList<Entry<K,V>> buffer = new ArrayList<>(size());
		for (int h=0; h<capacity; h++) {
			if (!isAvailable(h)) buffer.add(table[h]);
		}
		return buffer;
	}
	
}
