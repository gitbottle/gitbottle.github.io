package project3_files;

import java.util.*;

public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) return 0;
        else return 1 + depth(parent(p));
    }

    /**
     * Returns the height of the subtree rooted at Position p
     * @return height
     */
    private int height(Position<E> p) {
        int h = 0;
        for (Position<E> c : children(p))
            h = Math.max(h, 1 + height(c));
        return h;
    }

    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> positionIterator = positions().iterator();//calls iterator method in arraylist

        @Override
        public boolean hasNext() {
            return positionIterator.hasNext();
        }

        @Override
        public E next() {
            return positionIterator.next().getElement();
        }

        @Override
        public void remove() {
            positionIterator.remove();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    /**
     * Adds positions of the subtree rooted at p to the snapshot
     */
    private void preOrderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p);
        for (Position<E> c : children(p))
            preOrderSubtree(c, snapshot);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in preorder
     */
    public Iterable<Position<E>> preorder() {
        //creates the Iterable collection, ArrayList in this case
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) //if our tree is not empty
            preOrderSubtree(root(), snapshot); //use recursive algorithm
        return snapshot;
    }

    private void postOrderSubtree(Position<E> p, List<Position<E>> snapshot)
    {
        for(Position<E> c: children(p))
            postOrderSubtree(c, snapshot);
        snapshot.add(p);
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in postorder
     */
    public Iterable<Position<E>> postorder()
    {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty())
            postOrderSubtree(root(), snapshot);
        return snapshot;
    }


    /**
     * Returns an iterable collection of positions of the tree in breadth-first order
     */
    public Iterable<Position<E>> breadthFirst()
    {
        //Replaced LinkedQueue with a java.util.Deque to
        //reduce local dependencies. Functionality remains the same.
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Deque<Position<E>> queue = new LinkedList<>();
            queue.addLast(root());
            while(!queue.isEmpty())
            {
                Position<E> p = queue.removeFirst();
                snapshot.add(p);
                for(Position<E> c: children(p))
                    queue.addLast(c);
            }
        }
        return snapshot;
    }
}
