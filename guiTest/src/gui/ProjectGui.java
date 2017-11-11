package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectGui {
    private JButton useItAsapButton;
    private JButton deleteCouponButton;
    private JButton searchCouponsButton;
    private JButton listCouponsButton;
    private JButton insertCouponButton;
    private JCheckBox providerCheckBox;
    private JCheckBox nameCheckBox;
    private JCheckBox priceCheckBox;
    private JCheckBox discountCheckBox;
    private JCheckBox expirationCheckBox;
    private JCheckBox useCheckBox;
    private JTextArea textArea1;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel jp;
    private JScrollBar scrollBar1;

    public ProjectGui() {
        useItAsapButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        listCouponsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        insertCouponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        searchCouponsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteCouponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setContentPane(new ProjectGui().jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
