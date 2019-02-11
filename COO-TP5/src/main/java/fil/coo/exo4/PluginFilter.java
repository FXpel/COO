package fil.coo.exo4;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;

import fil.coo.exo4.Plugin;

public class PluginFilter implements FilenameFilter {
	
	public PluginFilter(){
		
	}
	
	public boolean accept(File dir, String name) {
		if (!name.endsWith(".class")) {
            return false;
        }
        try {
            String className = "fil.coo.exo4" + name.substring(0,name.length()-".class".length());
            Class c = Class.forName(className);
            if(c.isInterface()){
                return false;
            }
            Constructor constructor = c.getConstructor();
            return Plugin.class.isAssignableFrom(c);
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}
	
}
