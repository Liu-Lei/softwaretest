package cn.edu.tsinghua.gui;

import cn.edu.tsinghua.util.JFrameUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class OPCustomerFrame extends JFrame{
    private JButton nextButton = new JButton(OPConstant.NEXT);
    private JButton previousButton = new JButton(OPConstant.PREVIOUS);
    private JLabel tipsLabel = new JLabel("请添加被测软件的客户剖面:");
    private JPanel rootPanel = new JPanel();
    private JMenuBar menuBar = new OPJMenuBar();

    private int buttonWidth = 100;
    private int buttonHeight = 30;

    //构造首个界面
    public OPCustomerFrame(){
        super(OPConstant.OP_CN_NAME);
        //设置界面在屏幕中居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()/2-OPConstant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-OPConstant.FRAME_HEIGHT/2);

        JFrameUtil.init(this, OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);

        setJMenuBar(menuBar);

        rootPanel.setLayout(null);
        rootPanel.add(tipsLabel);
        rootPanel.add(previousButton);
        rootPanel.add(nextButton);
        tipsLabel.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-buttonHeight-getHeight()/5)/2-6*buttonHeight,2*buttonWidth,buttonHeight);
        previousButton.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-buttonHeight-getHeight()/5)/2,buttonWidth,buttonHeight);
        nextButton.setBounds((getWidth()-buttonWidth)/2+buttonWidth,(getHeight()-buttonHeight-getHeight()/5)/2,buttonWidth,buttonHeight);
        add(BorderLayout.CENTER,rootPanel);

        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OPMainFrame();
                OPCustomerFrame.this.dispose();
            }
        });
    }

    public static void main( String[] args ){
        OPCustomerFrame mainFrame = new OPCustomerFrame();
    }
}
