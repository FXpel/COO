package fil.coo.exo3;


/**
 * An interface for the file listeners
 *
 * 
 */
public interface FileListener {

    /**
     * The event when a file is added
     * @param fe the file event added
     */
    void fileAdded(FileEvent fe);

    /**
     * The event when the file is removed
     * @param fe the file event removed
     */
    void fileRemoved(FileEvent fe);
}
