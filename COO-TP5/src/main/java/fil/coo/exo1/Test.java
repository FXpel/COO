package fil.coo.exo1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Test {

    public void exec(){
        ActionListener a = new Shittylistener();
        Timer t = new Timer(1000,a);
        t.start();
        while(true);
    }

    private class Shittylistener implements ActionListener {

        public void actionPerformed(ActionEvent actionEvent) {
            System.out.println(java.util.Calendar.getInstance().getTime());
        }
    }
}
