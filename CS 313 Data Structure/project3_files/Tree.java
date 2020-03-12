package project3_files;

import java.util.Iterator;

public interface Tree<E> extends Iterable<E> {

    //Returns the position of the root of the tree
    Position<E> root();

    //For any valid position, returns its parent, or null for the root
    Position<E> parent(Position<E> p) throws IllegalArgumentException;

    //Returns an iterable collection containing the children of p*
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;

    //Returns the number of children for a valid position
    int numChildren(Position<E> p) throws IllegalArgumentException;

    //Returns true if the position passed is internal (i.e. has at least one child)
    boolean isInternal(Position<E> p) throws IllegalArgumentException;

    //Returns true if the position passed is a leaf node (i.e. has no children)
    boolean isExternal(Position<E> p) throws IllegalArgumentException;

    //returns true if the position passed is the root of the tree
    boolean isRoot(Position<E> p) throws IllegalArgumentException;

    //returns the number of positions (i.e. nodes) in the tree
    int size();

    //returns true is the tree has no positions (nodes)
    boolean isEmpty();

    //returns an iterator for all elements in the tree (Tree is Iterable)
    Iterator<E> iterator();

    //Returns an iterable collection of all positions of the tree
    Iterable<Position<E>> positions();
}
