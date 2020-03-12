package tree;

	/*
	 * Will represent a node in our tree implementation
	 * @param <E>
	 */

public interface Position <E>{
	/*
	 * Returns the element stored at this position
	 * @return the element stored
	 * @throws IllegalStateException if position is not valid
	 */
	E getElement () throws IllegalStateException;
	
	

}
