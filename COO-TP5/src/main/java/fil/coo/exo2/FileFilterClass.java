package fil.coo.exo2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A class for the class files filter
 *
 * 
 * @author 
 */
public class FileFilterClass implements FilenameFilter {

    /**
     * Say if the file is a .class file or not
     *
     * @param dir the directory of the file
     * @param name the name of the file
     * @return a boolean
     */
    public boolean accept(File dir, String name) {
        return name.endsWith(".class");
    }
}
