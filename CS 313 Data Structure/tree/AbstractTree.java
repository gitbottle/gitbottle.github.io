package tree;

import queue.LinkedQueue;
import queue.Queue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Abstract because it implements SOME not ALL of Tree methods
 * For example, it does not implement, size, root, parent, children methods
 */
public abstract class AbstractTree <E> implements Tree <E> {
	public boolean isInternal (Position <E> p) {
		return numChildren (p) > 0;
	}
	
	public boolean isExternal (Position <E> p) {
		return numChildren(p) == 0;
	}
	
	public boolean isRoot (Position <E> p) {
		return p == root ();
	}
	
	public boolean isEmpty () {
		return size () == 0;
	}
	/*
	 * Depth: length of the unique path from root to the current node
	 */
	public int depth (Position <E> p) {
		if (isRoot(p)) return 0;
		else return 1+depth(parent(p));
	}
	
	/*
	 * Height: Maximum of the depths
	 * Returns the height of the tree. It checks every node
	 * @return height
	 */
	
	private int heightBad () {
		int height =0;
		for (Position <E> p: positions ()) {
			if (isExternal(p))
				height = Math.max(height, depth(p));
		}
		
		return height;
	}
	/*
	 * Returns the height of the subtree rooted at Position p
	 * @return height
	 */
	private int height (Position <E> p) {
		int h=0;
		for (Position <E> c: children(p)) {
			//getting the highest height among p's children
			h= Math.max(h, 1+height(c));
		}
		return h;
	}
	
	private class ElementIterator implements Iterator<E>{
		Iterator<Position<E>> positionIterator = positions().iterator();
		
		public boolean hasNext() {
			//calls on ArrayList's Iterator
			return positionIterator.hasNext();
		}
		
		public E next() {
			return positionIterator.next().getElement();
		}
		
		public void remove() {
			positionIterator.remove();
		}
			
		
	}
	
	public Iterator<E> iterator(){
		return new ElementIterator();
	}
	
	private void preOrderSubtree (Position<E>p, List<Position<E>> snapshot) {
		
	}
	
}
