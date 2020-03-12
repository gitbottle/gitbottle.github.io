package priorityqueue;

import java.util.Comparator;

public class DefaultComparator <E> implements Comparator<E> {
	public int compare (E a, E b) throws ClassCastException {
		//casts to Comparable. In order to use compareto method in Comparable, you need to cast it to one
		//Comparable can only compare natural order objects such as number of character sequence.
		return ((Comparable<E>)a).compareTo(b);//how come it does not cast b?
	}
}
