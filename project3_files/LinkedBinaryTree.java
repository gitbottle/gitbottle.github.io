package project3_files;

public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    private static class Node<E> implements Position<E>
    {
        private E element;
        private Node<E> parent;
        private Node<E> left; //left child
        private Node<E> right; //right child

        public Node(E e, Node<E> parent, Node<E> left, Node<E> right)
        {
            element = e;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public E getElement() { return element; }
        public Node<E> getParent() { return parent; }
        public Node<E> getLeft() { return left; }
        public Node<E> getRight() { return right; }

        public void setElement(E e) { element = e; }
        public void setParent(Node<E> parent) { this.parent = parent; }
        public void setLeft(Node<E> left) { this.left = left; }
        public void setRight(Node<E> right) { this.right = right; }
    }

    private Node<E> root = null;
    private int size = 0;

    //start of accessor methods not implemented in AbstractBinaryTree
    @Override
    public Position<E> root() {
        return root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    @Override
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }
    //end of accessor methods not implemented in AbstractBinaryTree

    //start of update methods for this class

    /** adds a root to an empty tree */
    public Position<E> addRoot(E e) throws IllegalStateException
    {
        //cannot add a root to a tree that already has one
        if(!isEmpty()) throw new IllegalStateException("Tree is not empty");
        root = new Node<>(e, null, null, null);
        size = 1;
        return root;
    }

    /** Creates a new left child of Position p
     * @param p the parent position
     * @param e element to be stored
     * @return the new child
     * @throws IllegalArgumentException if specified child already exists
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> parent = validate(p);
        if(parent.getLeft()!=null) throw new IllegalArgumentException("p already has a left child");
        Node<E> child = new Node<>(e, parent, null, null);
        parent.setLeft(child);
        size++;
        return child;
    }

    /** Creates a new right child of Position p
     * @param p the parent position
     * @param e element to be stored
     * @return the new child
     * @throws IllegalArgumentException if specified child already exists
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> parent = validate(p);
        if(parent.getRight()!=null) throw new IllegalArgumentException("p already has a right child");
        Node<E> child = new Node<>(e, parent, null, null);
        parent.setRight(child);
        size++;
        return child;
    }

    /** Replaces element at position p, and returns replaced element */
    public E set(Position<E> p, E e) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }

    /** attaches trees t1 and t2 as left and right subtrees of an external node p **/
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2)
            throws IllegalArgumentException
    {
        Node<E>  node = validate(p);
        if(isInternal(node)) throw new IllegalArgumentException("p must be a leaf");
        size += t1.size() + t2.size();
        if(!t1.isEmpty())
        {
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty())
        {
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }

    /** Removes the node at position p and replaces it with its child if it has one.
     * Note that we cannot remove nodes with two children in a binary tree.
     * @return the element held by the removed node
     */
    public E remove(Position<E> p) throws IllegalArgumentException
    {
        Node<E> node = validate(p);
        if(numChildren(node)==2) throw new IllegalArgumentException("p has two children");
        //we will go over the syntax below in class if you are unfamiliar with it
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        //note that if leaf has no children, child is set to null in the line above.
        Node<E> parent = node.getParent();
        if(child!=null)
            child.setParent(parent); //childs parent becomes grandparent
        if(node==root) root=child; //if removed node was root, child inherits the throne
        else {
            if(node ==parent.getLeft()) parent.setLeft(child);
            else parent.setRight(child);
        }
        size--;
        E temp = node.getElement();
        node.setElement(null); //for garbage collection
        node.setLeft(null);
        node.setRight(null);
        //the textbook convention is to set a deleted nodes parent to itself,
        // in order to later check if the node was deleted
        node.setParent(node);
        return temp;
    }

    //end of updates methods for this class


    /**
     * Validates the position and returns it as a node
     * @throws IllegalArgumentException if given invalid node
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        //note that if this misc fails, it is still a Position, just note a Node
        if(!(p instanceof Node))
            throw new IllegalArgumentException("Not a valid position type");
        Node<E> node = (Node<E>) p;
        if(node.getParent() == node) //when we remove Nodes we set their parent to themselves.
            throw new IllegalArgumentException("p is no longer in the tree");
        return node;
    }
}
