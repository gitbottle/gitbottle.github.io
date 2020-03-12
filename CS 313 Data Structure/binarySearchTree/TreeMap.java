package binarySearchTree;

import project3_files.Entry;

public class TreeMap <K,V> extends AbstractSortedMap <K,V>{
	
	
	public V remove (K key) throws illegalArgumentExceptionEntry{
		checkKey (key);
		Position<Entry<K,V>> p = treeSearch (root(), key);
		//external: leaf/sentinel node  internal: actual Entry
		if (isExternal(p)) {
			//rebalances the tree after an access of specified position
			rebalanceAccess (p);
			return null;
		}else { // if p is an entry on the tree
			V old = p.getElement().getValue();
			
			if(isInternal(left(p)) && isInternal(right(p))) {//both children are internal
				Position<K,V> replacement = treeMax (left(p));//get the next highest key - always rightmost of the left child
				set (p , replacement.getElement());//p: to be removed. put the replacement in p
				p= replacement; // what is the reason for this step?- so you can remove it
			}
			//now there is at most one child that is an internal node
			Position<Entry<K,V>> leaf = (isExternal(left(p))? left(p): right(p));//sentinel
			Position<Entry<K,V>> sib = sibling(leaf);
			remove(leaf);  //sib is prmoted in p's place? how?
			remove(p);
			rebalanceDelete (sib);
			return old;
		}
	}
	
	protected Position<Entry<K,V>> treeMax (Position<Entry<K,V>> p){
		Position<Entry<K,V>> walk = p;
		while (isInternal(walk))
			walk= right(walk);
		
		return parent (walk);
	}
	
	public Entry<K,V> lastEntry(){
		if(isEmpty()) return null;
		return treeMax(root())
	}
	
	
	
	
}
