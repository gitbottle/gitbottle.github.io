package project3_files;

public interface PriorityQueue<K, V> {
    int size();
    boolean isEmpty();
    /**Creates and returns a new Entry, which is inserted in the appropriate place */
    Entry<K, V> insert(K key, V value)  throws IllegalArgumentException;
    /**Returns but does not remove the Entry with the minimal key, or null if queue is empty */
    Entry<K, V> min();
    /**Removes and returns the Entry with the minimal key, or null if queue is empty */
    Entry<K, V> removeMin();
}
