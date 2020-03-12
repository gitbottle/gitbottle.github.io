package project3_files;

/**
 * Will represent a node in our tree implementations
 * @param <E>
 */
public interface Position<E> {
    /**
     * Returns the element stored at this position
     * @return the element stored
     * @throws IllegalStateException if position is not valid
     */
    E getElement() throws IllegalStateException;
}
