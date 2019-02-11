package fil.coo.exo4;

import fil.coo.exo3.FileEvent;
import fil.coo.exo3.FileListener;

public class SimplePluginObserver implements FileListener {
	public void fileAdded(FileEvent fe) {
        System.out.println("Nouveau plugin détecté : " + fe.getFileName().substring(0,fe.getFileName().length()-".class".length()));
    }

    public void fileRemoved(FileEvent fe) {
        System.out.println("Plugin supprimé : " + fe.getFileName().substring(0,fe.getFileName().length()-".class".length()));
    }
}
