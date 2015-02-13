/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.netbeans.model;

import java.awt.Graphics;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author liulei
 */
public class PaintPanel extends JPanel{

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        System.out.println("paint");
    //    JOptionPane.showMessageDialog(this, "paint");
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
    //    JOptionPane.showMessageDialog(this, "paintComponent");
        System.out.println("paintComponent");
    }
    
}
