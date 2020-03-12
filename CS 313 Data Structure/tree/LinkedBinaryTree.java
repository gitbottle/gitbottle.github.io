package tree;



public class LinkedBinaryTree <E> extends AbstractBinaryTree <E>{
	//nested Node
	
	
	
	
	public E remove (Position <E> p) throws IllegalStateExeption {
		Node<E> node = validate(p);
		
		if (numChildren(p)==2) throw new IllegalStateException ("has two children");
		//what if this node has no child?
		Node <E> child = (node.getLeft()!=null? node.getLeft(): node.getRight());
		Node<E> parent= node.getParent();
		
		if (child!=null) child.setParent (parent);
		if (node==root) root = child;
		else {
			if(node==parent.getLeft()) parent.setLeft (child);
			else parent.setRight(child);
		}
		
		size--;
		E temp = node.getElement();
		node.setLeft = null;
		node.setRight=null;
		node.setElement=null;
		
		node.setParent(node);
		return temp;
	
	
	}
	
}
