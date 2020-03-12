package project3_files;

import java.util.Comparator;

public class LinkedHeapPQ<K, V> extends AbstractPriorityQueue<K, V> {
    private LinkedBinaryTree<Entry<K, V>> heap = new LinkedBinaryTree<>();

    public LinkedHeapPQ()
    {
        super();
    }

    public LinkedHeapPQ(Comparator<K> comp)
    {
        super(comp);
    }

    public LinkedHeapPQ (K[] keys, V[] values) throws IllegalArgumentException{
    	super ();
    	for (int j=0; j< keys.length; j++) {
    		Entry<K,V> newest = new PQEntry <>(keys[j], values[j]);
    		addNewLast (newest);
    		heapify ();
    	}
    }
    
    private void heapify () {
    	//If I imagine that the tree LInkedBinaryTree has index values like array-based heap..
    	//get the index of the parent of the last Position and set it equal to startIndex
    	int startIndex = (heap.size()-1)/2;//truncating division from pg377
    	
    	for (int j=startIndex; j> 0; j--) {
    		Position<Entry<K,V>> current = anyPosition(j);
    		downheap(current);
    	}
    	
    }
    @Override
    public int size() {
        return heap.size();
    }
    
    private void swap (Position<Entry<K,V>> p1, Position<Entry<K,V>> p2) {
    	Entry<K,V> temp = p1.getElement();
    	heap.set(p1, p2.getElement());
    	heap.set(p2, temp);
    	
    }
    
    private void upheap(Position<Entry <K,V>> c) {
    	while (c!=heap.root()) {
    		Position<Entry<K,V>> parent = heap.parent(c);
    		Entry <K,V> parentEntry = parent.getElement();
    		Entry <K,V> cEntry = c.getElement();
    		if (compare (cEntry, parentEntry)>=0) break;
    			swap (c, parent);
    			c=parent;
    	}
    }
    
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        //TODO for students
    	checkKey(key);
    	Entry<K,V> newest = new PQEntry<>(key,value);
    	Position<Entry<K,V>> p = addNewLast(newest);
    	upheap (p);
    	return newest;
    	
    }

    @Override
    public Entry<K, V> min() {
        //TODO for students
    	if (heap.isEmpty())return null;
    	
        return heap.root().getElement();
    }

    protected void downheap (Position <Entry <K,V>> c) {
    	while (heap.left(c)!=null) {
    		//finding smaller of c's two children, if any
    		Position<Entry<K,V>> leftPosition = heap.left(c);
    		Position<Entry<K,V>> smallChildPosition = leftPosition;
    		
    		if (heap.right(c)!=null) {
    			Position<Entry<K,V>> rightPosition = heap.right(c);
    			if (compare (leftPosition.getElement(), rightPosition.getElement())>0)
    				smallChildPosition = rightPosition;
    		}
    		//now comparing the current position c with smaller children. If a child is smaller than c, swap
    		//otherwise, heap property is restored so break.
    		if (compare (smallChildPosition.getElement(), c.getElement()) >=0) break;
    			swap (c, smallChildPosition);
    			c = smallChildPosition;
    	}
    }
    
    @Override
    public Entry<K, V> removeMin() {
        //TODO for students
    	//swap root with the last node. then remove the last node.
    	if (heap.isEmpty()) return null;
    	Entry <K,V> answer= min ();
    	Position <Entry<K,V>> last = lastPosition();
    	swap (heap.root(), last);
    	heap.remove(lastPosition());
    	downheap (heap.root());
        return answer;
    }

    /** Finds the "last node" in the heap in O(log n) time. */
    private Position<Entry<K, V>> lastPosition()
    {
        if(heap.size()==0) return null;
        Position<Entry<K, V>> current = heap.root();
        String path = Integer.toBinaryString(heap.size());
        if(path.length()>1) {
            path = path.substring(1); //get rid of the first character
            //follow the path
            for(int i=0; i<path.length(); i++)
            {
                if(path.charAt(i)=='0') current = heap.left(current); //go left for 0
                else current = heap.right(current); //go right for 1
            }
        }
        return current;
    }
    
    private Position<Entry<K, V>> anyPosition(int j)
    {
        if(heap.size()==0) return null;
        Position<Entry<K, V>> current = heap.root();
        String path = Integer.toBinaryString(j);
        if(path.length()>1) {
            path = path.substring(1); //get rid of the first character
            //follow the path
            for(int i=0; i<path.length(); i++)
            {
                if(path.charAt(i)=='0') current = heap.left(current); //go left for 0
                else current = heap.right(current); //go right for 1
            }
        }
        return current;
    }

    /** Adds a new entry to the last position in the heap and returns it. Runs in O(log n) time */
    private Position<Entry<K, V>> addNewLast(Entry<K, V> entry)
    {
        if(heap.isEmpty())
            return heap.addRoot(entry);
        String path = Integer.toBinaryString(heap.size()+1);
        //follow the path to expecting parent
        Position<Entry<K, V>> parent = heap.root();
        if(path.length()>1) {
            //cut off first and last character, and it will be the path to the parent of new last
            path = path.substring(1, Math.max(path.length() - 1, 0));
            for (int i = 0; i < path.length(); i++) {
                if (path.charAt(i) == '0') parent = heap.left(parent); //go left for 0
                else parent = heap.right(parent); //go right for 1
            }
        }
        //if heap size was odd, we have to add as left child, else as right
        if(heap.size()%2==1)
            return heap.addLeft(parent, entry);
        else return heap.addRight(parent, entry);
    }
}
