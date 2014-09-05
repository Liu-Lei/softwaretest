package cn.edu.tsinghua.autogui;

import cn.edu.tsinghua.gui.OPConstant;
import cn.edu.tsinghua.gui.OPMainFrame;
import cn.edu.tsinghua.util.JFrameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lei on 2014/9/4.
 */
public class OPMainFrameAuto extends JFrame{
    private JButton Button;
    private JPanel panel1;


    public OPMainFrameAuto() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String projectName = JOptionPane.showInputDialog("请输入需要创建的项目名字","");
                if(projectName.trim().isEmpty()){
                    JOptionPane.showMessageDialog(OPMainFrameAuto.this,"格式不正确，请重新输入。");
                }else {

                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("操作剖面");
        //设置界面在屏幕中居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int) screenSize.getWidth() / 2 - OPConstant.FRAME_WIDTH / 2, (int) screenSize.getHeight() / 2 - OPConstant.FRAME_HEIGHT / 2);

        //JFrameUtil.init(frame, OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);
        frame.setSize(OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setContentPane(new OPMainFrameAuto().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
