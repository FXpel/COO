package fil.coo;

import javax.swing.*;

import fil.coo.exo2.FileFilterClass;
import fil.coo.exo3.FileChecker;
import fil.coo.exo3.PrintListener;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FileFilterClass ffc = new FileFilterClass();
        FileChecker fc = new FileChecker(ffc,"/home/l3/pelage/Bureau/COO/COO-TP5/classes");
        PrintListener pl = new PrintListener();
        fc.addListener(pl);
        javax.swing.Timer t = new Timer(1000,fc);
        t.start();
        while(true);
        
        
    }
}
