package project3_files;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    //Nested Entry class
    protected static class PQEntry<K, V> implements Entry<K, V>
    {
        private K key;
        private V value;
        public PQEntry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
        public K getKey() { return key; }
        public V getValue() { return value; }
    }
    //end of nested Entry class

    //constructor to pass a custom comparator for comparing keys
    protected AbstractPriorityQueue(Comparator<K> c)
    {
        comp = c;
    }

    protected AbstractPriorityQueue() //default constructor
    {
        this(new DefaultComparator<K>());
    }
    //why protected constructors? ^
    //Because it is abstract class, subclasses must provide their own constructors which call these.

    private Comparator<K> comp;

    protected int compare(Entry<K, V> a, Entry<K, V> b)
    {
        return comp.compare(a.getKey(), b.getKey());
    }

    protected boolean checkKey(K key)
    {
        try {
            return comp.compare(key, key) == 0; //key should be equal to itself
        }
        catch (ClassCastException c) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
