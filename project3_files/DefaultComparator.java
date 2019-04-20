package project3_files;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E> {
    /**
     * Compares two objects based on their natural ordering.
     * Both objects must be of the same type, and implement comparable.
     */
    @Override
    public int compare(E a, E b) throws ClassCastException {
        return ((Comparable<E>) a).compareTo(b);
    }
}
