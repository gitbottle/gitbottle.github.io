package priorityqueue;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;

public class HeapPriorityQueue2 <K,V> extends AbstractPriorityQueue2 <K,V> {
	//field of HeapPriorityQueue2
	protected List <PQEntry <K,V>> heap = new ArrayList <>();
	
	//constructors
	public HeapPriorityQueue2(Comparator <K> c) {
		super (c);
	}
	
	public HeapPriorityQueue2 () {
		super ();
	}
	
	//another constructor that constructs a heap with an array of keys and an array of values.
	public HeapPriorityQueue2 (K [] keys, V[] values) {
		
		if (keys.length != values.length) throw new IllegalArgumentException ("sizes do not match");
		for (int i = 0 ; i < keys.length; i++) {
			heap.add (new PQEntry<> (keys[i], values[i]));// add to the end of the list
		}
		
		heapify ();
	}
	
	//once the key and value arrays are inserted, we need to restore arraylist to heap properities
	public void heapify () {
		//start with the parent of the last node
		int startIndex= parent (size()-1);
		for (int j = startIndex; j>=0; j--) {
			downheap(j);
		}
	}
	
	public int size () {
		return heap.size();
	}
	
	//position methods- protected to allow subclasses to use them to find positions of PQEntries.
	protected int parent (int j) {
		return (j-1)/2;
	}
	
	protected int left (int j) {
		return j*2 +1;
	}
	
	protected int right (int j) {
		return j*2 +2;
	}
	
	protected boolean hasLeft(int j) { // in heap, you can assume that every position is filled.
		return left(j) < heap.size();
	}
	
	protected boolean hasRight(int j) {
		return right(j) < heap.size();
	}
	
	protected void swap (int i, int j) {
		PQEntry <K,V> temp = heap.get(j);
		heap.set(j, heap.get(i));
		heap.set(i, temp);
	}
	
	protected void upheap (int j) {
		while(j > 0) {
			int p = parent (j);
			if (compare(heap.get(j), heap.get(p)) >= 0) break;//parent is smaller in heap
			swap (j, p);
			j = p;
			
		}
	}
	
	protected void downheap (int j) {
		while (hasLeft(j)) {
			int leftChildIndex = left(j);
			int smallChildIndex = leftChildIndex;
			while(hasRight(j)) {
				int rightChildIndex = right(j);
				if(compare (heap.get(smallChildIndex), heap.get(rightChildIndex)) > 0)
					smallChildIndex = rightChildIndex;
			}
			
			if (compare (heap.get(smallChildIndex), heap.get(j)) >= 0) break;
			swap (j, smallChildIndex);
			j = smallChildIndex;
			
		}
	}
	
	public Entry <K,V> insert (K key, V value) throws IllegalArgumentException {
		checkKey (key);
		PQEntry <K, V> newest = new PQEntry <> (key, value);
		heap.add (newest);
		upheap (size()-1);
		return newest;
	}
	
	public Entry <K,V> min (){
		if (heap.isEmpty()) return null;
		else return heap.get(0);
		
	}
	
	public Entry <K,V> removeMin (){
		if (heap.isEmpty()) return null;
		PQEntry <K,V> min = heap.get(0);
		swap (0, heap.size()-1);
		heap.remove (heap.size()-1);
		downheap (0);
		
		return min;
	}
	
	public boolean isEmpty () {
		return heap.isEmpty();
	}
}
