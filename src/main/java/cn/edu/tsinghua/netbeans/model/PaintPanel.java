/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.netbeans.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author liulei
 */
public class PaintPanel extends JPanel {

    //在当前画板上应该展示的图形列表
    public LinkedList<Shape> shapeList = new LinkedList<Shape>();
    //下一步要画的图
    public Shape shape;
    //画图的起点和终点（圆形的形状只有一个点即可，因为点击一下即可出现一个图形，线条需要两个点）
    public Point start, end;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("paintComponent");
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setColor(Color.black);
        for (Shape s : shapeList) {
            g2.draw(s);
            System.out.println("Draw a shape");
        }
        if(shape != null){
            g2.draw(shape);    
        }
    }

}
