package fil.coo;

import javax.swing.*;

import fil.coo.exo3.FileChecker;
import fil.coo.exo4.PluginFilter;
import fil.coo.exo4.SimplePluginObserver;

/**
 * Hello world!
 *
 */
public class Exercice4main 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {	 PluginFilter pf = new PluginFilter();
        FileChecker fc = new FileChecker(pf,"/home/l3/pelage/Bureau/COO/COO-TP5/classes");
        SimplePluginObserver spo = new SimplePluginObserver();
        fc.addListener(spo);
        javax.swing.Timer t = new Timer(1000,fc);
        t.start();
        while(true);
    }
}
