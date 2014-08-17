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
    private JMenuBar menuBar;

    public OperationalProfileFrame(){
        super("构造操作剖面");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clickMeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showConfirmDialog(OperationalProfileFrame.this, "You clicked the button", "Confirm Button", JOptionPane.CANCEL_OPTION);
            }
        });

        JMenu[] menus = {
                new JMenu("文件"),
                new JMenu("编辑"),
                new JMenu("帮助"),
        };
        menuBar = new JMenuBar();
        for(JMenu jMenu : menus){
            menuBar.add(jMenu);
        }
        setJMenuBar(menuBar);
        setVisible(true);
        setSize(800,600);
    }
}
