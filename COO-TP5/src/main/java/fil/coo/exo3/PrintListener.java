package fil.coo.exo3;

import fil.coo.exo3.FileEvent;

/**
 * A class for the printing event
 *
 * @author 
 * 
 */
public class PrintListener implements FileListener {

    /**
     * The event when a file is added
     * @param fe the file event added
     */
    public void fileAdded(FileEvent fe) {
        System.out.println("nouveau .class : " + fe.getFileName() + " détecté");
    }

    /**
     * The event when the file is removed
     * @param fe the file event removed
     */
    public void fileRemoved(FileEvent fe) {
        System.out.println(".class : " + fe.getFileName() + " supprimé détecté");
    }
}
