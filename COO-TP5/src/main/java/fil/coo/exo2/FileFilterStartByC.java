package fil.coo.exo2;

import java.io.File;
import java.io.FilenameFilter;

/**
 * A File filter class for the file starting by C
 *
 * 
 * @author 
 */
public class FileFilterStartByC implements FilenameFilter {

    /**
     * The accept method of the interface
     *
     * @param dir the directory of the file
     * @param name the name of the file
     * @return if the file is acceptable or not
     */
    public boolean accept(File dir, String name) {
        char c = name.charAt(0);
        return c == 'C';
    }
}
