package cn.edu.tsinghua.gui;

import javax.swing.*;

/**
 * Created by lei on 2014/8/17.
 */
public class OPJMenuBar extends JMenuBar {

    private JMenu opMenu = new JMenu(OPConstant.OP_CN_NAME);
    private JMenu fileMenu = new JMenu(OPConstant.FILE_CN_NAME);
    private JMenu helpMenu = new JMenu(OPConstant.HELP_CN_NAME);

    private JMenuItem createOpMenu = new JMenuItem(OPConstant.START_CREATE_OP);

    public OPJMenuBar(){
        super();
        opMenu.add(createOpMenu);
        add(fileMenu);
        add(opMenu);
        add(helpMenu);
    }
}
