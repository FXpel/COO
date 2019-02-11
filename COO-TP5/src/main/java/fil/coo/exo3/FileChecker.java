package fil.coo.exo3;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A file checker class
 *
 * @author 
 * 
 */
public class FileChecker implements ActionListener{

    private FilenameFilter f;
    private File dir;
    private ArrayList<FileListener> listeners;
    private ArrayList<String> knownFile;

    /**
     * the constructor of the file checker
     *
     * @param f the file filter to define the condition of filtration
     * @param dir the directory to check
     */
    public FileChecker(FilenameFilter f,String dir) {
        this.f = f;
        this.dir = new File(dir);
        this.listeners = new ArrayList<FileListener>();
        this.knownFile = new ArrayList<String>();
        for (String s : this.dir.list(f)){
            this.knownFile.add(s);
        }
    }

    /**
     * Add a listener to the checker
     *
     * @param f the listener to add
     */
    public void addListener(FileListener f){
        this.listeners.add(f);
    }

    /**
     * Remove a listener from the checker
     *
     * @param f the listener to remove
     * @return a boolean to say if the listener was removed correctly or not
     */
    public boolean removeListener(FileListener f){
        return this.listeners.remove(f);
    }

    /**
     * Send the event to all of the listeners
     *
     * @param fileName the name of the added file
     */
    public void fireFileAdded(String fileName){
        FileEvent fe = new FileEvent(fileName);
        for(FileListener fl : this.listeners){
            fl.fileAdded(fe);
        }
    }

    /**
     * Send the event to all of the listeners
     *
     * @param fileName the name of the removed file
     */
    public void fireFileRemoved(String fileName){
        FileEvent fe = new FileEvent(fileName);
        for(FileListener fl : this.listeners){
            fl.fileRemoved(fe);
        }
    }

    /**
     * Check if the file was already there or not
     * @param fileName the name of the file to check
     * @return true if the file is new and false if it was already there
     */
    private boolean checkAdded(String fileName){
        return !this.knownFile.contains(fileName);
    }

    /**
     * Retunr if the file has been removed
     * @param fileName the name of the file to check
     * @param list the list of files in directory
     * @return true if the file has bee removed and false if it still there
     */
    private static boolean checkRemoved(String fileName, List<String> list){
        return !list.contains(fileName);
    }

    /**
     * The check of the directory
     * @param e the actionEvent
     */
    public void actionPerformed(ActionEvent e) {
        List<String> list = Arrays.asList(this.dir.list(this.f));
        
        for(String fileName : list){
            if (this.checkAdded(fileName)){
                this.knownFile.add(fileName);
                this.fireFileAdded(fileName);
            }
        }
        List<String> copy = (List<String>) this.knownFile.clone();
        for (String fileName : copy){
            if (this.checkRemoved(fileName,list)){
                this.knownFile.remove(fileName);
                this.fireFileRemoved(fileName);
            }
        }
    }
}
