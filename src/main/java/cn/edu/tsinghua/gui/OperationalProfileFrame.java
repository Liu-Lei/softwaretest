package cn.edu.tsinghua.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lei on 2014/8/14.
 */
public class OperationalProfileFrame extends JFrame{
    private JButton clickMeButton;
    private JPanel rootPanel;

    public OperationalProfileFrame(){
        super("Test GUI");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(OperationalProfileFrame.this, "You clicked the button", "Confirm Button", JOptionPane.CANCEL_OPTION);
            }
        });

        setVisible(true);
        setSize(400,300);
    }
}
