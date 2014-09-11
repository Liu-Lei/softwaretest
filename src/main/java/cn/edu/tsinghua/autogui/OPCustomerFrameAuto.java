package cn.edu.tsinghua.autogui;

import javax.swing.*;

/**
 * Created by lei on 2014/9/4.
 */
public class OPCustomerFrameAuto extends JFrame{


    private JPanel panel1;
    private JTable table1;


    public static void main(String[] args) {
        JFrame frame = new JFrame("创建客户剖面");
        frame.setContentPane(new OPCustomerFrameAuto().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
