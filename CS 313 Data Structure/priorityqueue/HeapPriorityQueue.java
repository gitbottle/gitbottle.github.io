package priorityqueue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HeapPriorityQueue <K,V> extends AbstractPriorityQueue <K,V>{
	protected List <Entry <K,V>> heap = new ArrayList <> ();
	
	public HeapPriorityQueue () {
		super ();
	}
	
	public HeapPriorityQueue (Comparator <K> comparator) {
		super (comparator);
	}
	
	protected int parent (int j) {
		return (j-1)/2;
	}
	
	protected int left (int j) {
		return (j*2)+1;//may return value that does not exist on the heap (value greater than the size of the heap). It is simply just numerical calculation. Has left and has right determines whether this calculation result belongs in the heap
	}
	
	protected int right (int j) {
		return (j*2)+2;
	}
	
	protected boolean hasLeft (int j) {
		return left (j)< heap.size(); 
	}
	
	protected boolean hasRight (int j) {
		return right(j)<heap.size();
	}
	
	protected void swap (int i, int j) {
		Entry<K, V> temp = heap.get(j);
		heap.set(j, heap.get(i));
		heap.set(i, temp);
		
	}
	
	protected void upheap (int j) {
		while (j>0) {
			int p = parent (j);
			
			if (compare (heap.get(j), heap.get(p))>=0) break;//if j is greater than or equal to parent
			swap (j,p);
			j=p;
		}
	}
	
	protected void downheap (int j) {
		while (hasLeft(j)) {//you only need to check left because it is a heap; it fills up left first. If left is not there, there is really no more
			int leftIndex = left(j);
			int smallChildIndex= leftIndex;
			if (hasRight(j)) {
				int rightIndex=right(j);
				if (compare (heap.get(leftIndex), heap.get(rightIndex))>0)
					smallChildIndex=rightIndex;
			}
			
			if(compare (heap.get(smallChildIndex), heap.get(j))>=0)
					break;  //must break here. otherwise, it will keep going even if it reached heap property
			
			swap (j, smallChildIndex);
			j=smallChildIndex;
		}
	}
	
	public int size () {
		return heap.size();
	}
	
	public Entry <K,V> min (){
		if(heap.isEmpty()) return null;
		return heap.get(0);
	}
	//? throws IllegalStateException not indexoutof bounds ? Does it use Java ArrayList instead of the one we built in class?
	public Entry <K, V> insert (K key, V value) throws IllegalStateException {
		checkKey (key);
		Entry<K,V> newest = new PQEntry <>(key , value);
		heap.add(newest); //adds at the end of the ArrayList/heap
		upheap (heap.size()-1);
		return newest;
	}
	
	public Entry <K, V> removeMin (){
		if (heap.isEmpty()) return null;
		Entry<K,V> answer = heap.get(0);
		swap (0, heap.size()-1);
		heap.remove(size()-1);
		downheap (0);
		return answer;
	}
	
	
	
	
}

