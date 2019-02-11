package fil.coo.exo2;

import java.io.File;


/**
 * An exploration dir class
 *
 * 
 * @author
 */
public class ExploreDir {

    private File file;

    /**
     * A constructor for the dir explorer
     * @param path the directory to explore
     */
    public ExploreDir(String path){
        this.file = new File(path);
    }

    /**
     * Give the list of file with a name starting by C
     *
     * @return a list of string
     */
    public String[] getStrartingByC(){
        FileFilterStartByC fc = new FileFilterStartByC();
        String[] st = this.file.list(fc);
        return st;
    }

    /**
     * Give the list of the .class file in the directory
     *
     * @return a list of string
     */
    public String[] getClassFile(){
        FileFilterClass fc = new FileFilterClass();
        String[] st = this.file.list(fc);
        return st;
    }
}
