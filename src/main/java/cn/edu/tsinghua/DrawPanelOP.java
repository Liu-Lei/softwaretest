/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua;

import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.JFrameUtil;
import java.awt.geom.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

/**
 * 简单的画图程序
 *
 * @author LiuLei
 * @Edit by LiuLei
 * @version .1
 */
public class DrawPanelOP extends JFrame {

    LinkedList<Shape> shapeList = new LinkedList<Shape>();
    Shape shape;
    Point start, end;
    final String[] type = new String[]{"顺序转移","概率转移", "包", "操作"};
    JComboBox comboBox = new JComboBox(type);

    public DrawPanelOP() {
        super("DrawPanel");
        setPreferredSize(new Dimension(Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT));
        JFrameUtil.setFrameLocationToMiddle(this);
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.white);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.setColor(Color.black);
                for (Shape s : shapeList) {
                    g2.draw(s);
                }
                g2.draw(shape);
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                start = e.getPoint();
            }

            public void mouseReleased(MouseEvent e) {
                shapeList.add(shape);
            }
            
            public void mouseClicked(MouseEvent e){
                Point clickPoint = e.getPoint();
                int widthPlus = 70;
                int heightPlus = 50;
                Point endPoint = new Point(clickPoint.x+widthPlus/2,clickPoint.y+heightPlus/2);
                Point startPoint = new Point(clickPoint.x-widthPlus/2,clickPoint.y-heightPlus/2);
                Object select = comboBox.getSelectedItem();
                if (select.equals(type[0]) || select.equals(type[1])) {
                    //shape = new Line2D.Float(start, end);
                } else {
                    if (select.equals(type[2])) {
                        shape = new Rectangle();
                    } else {
                        shape = new Ellipse2D.Float();
                    }
                    ((RectangularShape) shape).setFrameFromDiagonal(startPoint, endPoint);
                }
                repaint();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                end = e.getPoint();
                Object select = comboBox.getSelectedItem();
                if (select.equals(type[0]) || select.equals(type[1])) {
                    shape = new Line2D.Float(start, end);
                } else {
//                    if (select.equals(type[1])) {
//                        shape = new Rectangle();
//                    } else {
//                        shape = new Ellipse2D.Float();
//                    }
//                    ((RectangularShape) shape).setFrameFromDiagonal(start, end);
                }
                repaint();
            }
        });
        
        
        
        add(panel, BorderLayout.CENTER);
        shape = new Rectangle();

        add(comboBox, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new DrawPanelOP();
    }
}
