package cn.edu.tsinghua.gui;

import cn.edu.tsinghua.util.JFrameUtil;
import sun.font.GlyphLayout;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class OPMainFrame extends JFrame{
    private JButton startButton = new JButton(OPConstant.START_CREATE_OP);
    private JPanel rootPanel = new JPanel();
    private JMenuBar menuBar = new OPJMenuBar();

    private int buttonWidth = 200;
    private int buttonHeight = 50;

    //构造首个界面
    public OPMainFrame(){
        super(OPConstant.OP_CN_NAME);
        //设置界面在屏幕中居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()/2-OPConstant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-OPConstant.FRAME_HEIGHT/2);

        JFrameUtil.init(this, OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);

        setJMenuBar(menuBar);

        rootPanel.setLayout(null);
        rootPanel.add(startButton);
        startButton.setBounds((getWidth()-buttonWidth)/2,(getHeight()-buttonHeight-getHeight()/5)/2,buttonWidth,buttonHeight);
        add(BorderLayout.CENTER,rootPanel);
    }

    public static void main( String[] args ){
        OPMainFrame mainFrame = new OPMainFrame();
    }
}
