package fil.coo.exo3;

/**
 * A class for the event
 *
 * @author Karti & Pelage
 */
public class FileEvent {

    private String fileName;

    /**
     * The constructor of the fileEvent
     *
     * @param s the name of the file of the event
     */
    public FileEvent(String s){
        this.fileName = s;
    }

    /**
     * Return the name of the file
     * @return a string with the name
     */
    public String getFileName(){
        return this.fileName;
    }
}
