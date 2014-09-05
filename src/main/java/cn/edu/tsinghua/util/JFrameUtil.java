package cn.edu.tsinghua.util;

import javax.swing.*;

/**关于Frame的一些操作
 * Created by lei on 2014/8/16.
 */
public class JFrameUtil {

    /**
     * 通用初始化JFrame的操作
     */
    public static void init(JFrame frame,int width, int height){
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }
}