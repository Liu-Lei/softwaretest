package cn.edu.tsinghua.util;

import cn.edu.tsinghua.gui.OPConstant;
import java.awt.Dimension;
import java.awt.Toolkit;
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
    
    /**
     * 刷新 名称+概率TextArea
     * @param name
     * @param possibility 
     */
    public static void refreshTheTextArea(JTextArea textArea,StringBuffer displayText, String name, String possibility){
        displayText.append(name).append(Constant.TAB__STRING).append(possibility).append(Constant.NEW_LINE_STRING);
        textArea.setText(null);
        textArea.setText(displayText.toString());
    }
    
    /**
     * 刷新 名称+概率TextArea
     * @param name
     * @param possibility 
     */
    public static void refreshTheTextArea(JTextArea textArea,StringBuffer displayText){
        textArea.setText(displayText.toString());
    }
    
    //设置界面在屏幕中居中显示
    public static void setFrameLocationToMiddle(JFrame frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)screenSize.getWidth()/2-OPConstant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-OPConstant.FRAME_HEIGHT/2);
    }
}