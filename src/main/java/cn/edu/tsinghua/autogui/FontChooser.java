package cn.edu.tsinghua.autogui;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Created by lei on 2014/9/2.
 */
public class FontChooser {
    private JPanel panel1;
    private JList fontNameList;
    private JList fontSizeList;
    private JRadioButton regularRadioButton;
    private JRadioButton boldRadioButton;
    private JRadioButton italicRadioButton;
    private JRadioButton boldItalicRadioButton;
    private JLabel fontNameLabel;

    public FontChooser() {
        fontNameList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                updateFont();
            }
        });
    }

    private void updateFont() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FontChooser");
        frame.setContentPane(new FontChooser().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
