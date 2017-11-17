package list;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

public class MyWindow {
    private JTextField textField1;
    private JButton button1;
    private JTextArea textArea1;
    private JPanel myPanel;

    public MyWindow() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             String s= textField1.getText();
             textArea1.setText("");
             textArea1.setText(show(s));
            }
        });
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String s= textField1.getText();
                 if(e.getKeyCode()==KeyEvent.VK_ENTER){
                     textArea1.setText("");
                     textArea1.setText(show(s));
                 }

            }

        });
    }
    private String show(String s){
        File dir = new File(s);
        StringBuffer sb= new StringBuffer();
        if(dir.exists()&&dir.isDirectory()){
            String[] names= dir.list();
            for (String temp:names){
                sb.append(temp);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MyWindow");
        frame.setContentPane(new MyWindow().myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
