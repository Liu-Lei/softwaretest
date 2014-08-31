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
public class OPCustomerFrame extends JFrame{
    private JButton nextButton = new JButton(OPConstant.NEXT);
    private JButton previousButton = new JButton(OPConstant.PREVIOUS);
    private JButton addObjectButton = new JButton(OPConstant.ADD_CN);
    private JLabel tipsLabel = new JLabel("请添加被测软件的客户剖面:");
    private JPanel rootPanel = new JPanel();
    private JTable table;
    private JMenuBar menuBar = new OPJMenuBar();

    private int buttonWidth = 100;
    private int buttonHeight = 30;
    private int tableRow = 3;
    private int tableColumn = 3;


    //构造首个界面
    public OPCustomerFrame(){
        super(OPConstant.OP_CN_NAME);
        //设置界面在屏幕中居中显示
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int)screenSize.getWidth()/2-OPConstant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-OPConstant.FRAME_HEIGHT/2);

        //初始化此Frame
        JFrameUtil.init(this, OPConstant.FRAME_WIDTH, OPConstant.FRAME_HEIGHT);

        //设置菜单
        setJMenuBar(menuBar);

        //设置表格
        JScrollPane scrollpane = new JScrollPane(table);




        rootPanel.setLayout(null);
        rootPanel.add(tipsLabel);
        rootPanel.add(addObjectButton);
        rootPanel.add(scrollpane);
        rootPanel.add(previousButton);
        rootPanel.add(nextButton);

        //设置标签位置和大小
        tipsLabel.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-buttonHeight-getHeight()/5)/2-6*buttonHeight,2*buttonWidth,buttonHeight);
        //设置增加按钮位置和大小
        addObjectButton.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-getHeight()/2)/3,buttonWidth,buttonHeight);
        //设置增加按钮位置和大小
        scrollpane.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-getHeight()/3)/3,buttonWidth*3,buttonHeight*3);
        //设置上一步按钮位置和大小
        previousButton.setBounds((getWidth()-buttonWidth)/2-buttonWidth,(getHeight()-buttonHeight-getHeight()/4),buttonWidth,buttonHeight);
        //设置下一步按钮位置和大小
        nextButton.setBounds((getWidth()-buttonWidth)/2+buttonWidth,(getHeight()-buttonHeight-getHeight()/4),buttonWidth,buttonHeight);

        add(BorderLayout.CENTER,rootPanel);

        //点击上一步按钮回到上一个界面
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new OPMainFrame();
                OPCustomerFrame.this.dispose();
            }
        });
    }

    private void initJTable(){
        TableModel tableModel = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return tableRow;
            }

            @Override
            public int getColumnCount() {
                return tableColumn;
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return new Integer(rowIndex*columnIndex);
            }
        };
        table = new JTable(tableModel);
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
        OPCustomerFrame mainFrame = new OPCustomerFrame();
    }
}
