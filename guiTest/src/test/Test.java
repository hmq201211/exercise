package test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Test {
    public static void main(String[] args) {
        Frame f= new Frame("my frame");
        f.setSize(800,800);
        f.setVisible(true);
        f.setLocation(200,100);
//        f.setBounds(200,100,800,800);
        f.setLayout(null);
        Button but= new Button("my button");
        f.add(but);
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}
