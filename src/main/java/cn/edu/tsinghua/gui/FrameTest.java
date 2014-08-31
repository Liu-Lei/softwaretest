package cn.edu.tsinghua.gui;

import cn.edu.tsinghua.util.JFrameUtil;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Hello world!
 *
 */
public class FrameTest extends JFrame{
    private JButton startButton = new JButton(OPConstant.START_CREATE_OP);
    private JPanel rootPanel = new JPanel();
    private JMenuBar menuBar = new OPJMenuBar();

    private int buttonWidth = 200;
    private int buttonHeight = 50;

    //构造首个界面
    public FrameTest(){
        super(OPConstant.OP_CN_NAME);
        //设置界面在屏幕中居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()/2-OPConstant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-OPConstant.FRAME_HEIGHT/2);

        JFrameUtil.init(this, OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);

        setJMenuBar(menuBar);
        setResizable(false);

        TableModel dataModel = new AbstractTableModel() {
            public int getColumnCount() { return 3; }
            public int getRowCount() { return 3;}
            public Object getValueAt(int row, int col) { return new Integer(row*col); }
        };
        JTable table = new JTable(dataModel);
        JScrollPane scrollpane = new JScrollPane(table);


        rootPanel.setLayout(null);
        //rootPanel.add(startButton);
        rootPanel.add(scrollpane);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OPCustomerFrame opCustomerFrame = new OPCustomerFrame();
                FrameTest.this.dispose();
            }
        });
        startButton.setBounds((getWidth()-buttonWidth)/2,(getHeight()-buttonHeight-getHeight()/5)/2,buttonWidth,buttonHeight);
        scrollpane.setBounds((getWidth()-buttonWidth)/4,(getHeight()-buttonHeight-getHeight()/2),buttonWidth*2,buttonHeight*2);
        add(BorderLayout.CENTER,rootPanel);
    }

    public static void main( String[] args ){
        //设置控件格式适应当前系统
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        FrameTest mainFrame = new FrameTest();
    }
}
