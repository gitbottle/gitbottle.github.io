package tree;

import java.util.Iterator;

//interface cannot implement another interface- it extends.
public interface Tree <E> extends Iterator <E> {
	
	//Returns the position of the root of the tree
	//Is this position the same as the Position interface?
	Position <E> root ();
	
	//Returns its parent, or null for the root
	Position <E> parent (Position <E> p) throws IllegalArgumentException;
	
	//Returns an iterable collection containing the children of p*
	Iterable<Position<E>> children (Position<E> p) throws IllegalArgumentException;
	
	//Returns the number of children for a valid position
	int numChildren (Position<E> p) throws IllegalArgumentException;
	
	//Returns true if the position has at least one child.
	boolean isInternal (Position <E> p);
	
	//Returns true if the position has no children or is a leaf node.
	boolean isExternal (Position<E> p);
	
	//Returns true if the position passed is the root of the tree
	boolean isRoot (Position <E> p);
	
	//Returns number of positions or nodes in the tree
	int size ();
	
	//Returns true if the tree has no positions or nodes
	boolean isEmpty();
	
	//Returns an iterator for all elements in the tree (Tree itself is Iterable)
	Iterator <E> iterator ();
	
	//Returns an iterable collection of all positions of the tree
	Iterable <Position<E>> positions();
}
