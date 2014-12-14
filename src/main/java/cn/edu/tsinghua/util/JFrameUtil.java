package cn.edu.tsinghua.util;

import cn.edu.tsinghua.testcase.model.OperationObject;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
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
        frame.setLocation((int)screenSize.getWidth()/2-Constant.FRAME_WIDTH/2,(int)screenSize.getHeight()/2-Constant.FRAME_HEIGHT/2);
    }
    
    //根据宽度平分两个字符的展示空间
    public static String getFormatJListText(String firstStr, String secondStr, int width) {
        int halfWidth = width / 2;
        char[] charArray = new char[width];
        for(int i = 0; i < width; i++){
            charArray[i] = ' ';
        }
        int firstLength = firstStr.length() < halfWidth ? firstStr.length() : halfWidth;
        for(int i = 0; i < firstLength; i++){
            charArray[i] = firstStr.charAt(i);
        }
        int secondLength = (halfWidth+secondStr.length()) > width ? width : (halfWidth+secondStr.length());
        for(int j = halfWidth; j < secondLength; j++){
            charArray[j] = secondStr.charAt(j-halfWidth);
        }
        return new String(charArray);
    }
    
    //增加item至jList
    public static void addOperationObjectToJList(JList<String> jList, OperationObject operationObject, String profileCNName){
        String jListTitle =getFormatJListText(profileCNName, "概率", 32);
        DefaultListModel<String> listModel;
        if(jList.getModel().getSize() == 0){
            listModel = new DefaultListModel<String>();
            listModel.add(0,jListTitle);
        }else{
            listModel = (DefaultListModel<String>) jList.getModel();
        }
        
        if(operationObject != null){
            String newOP = getFormatJListText(operationObject.getName(), operationObject.getPossibility().toString(), 40);
            listModel.add(listModel.size(), newOP);
        }
        
        jList.setModel(listModel);
    }
    
    //增加item至jList
    public static void removeObjectFromJList(JList<String> jList, int index){
        DefaultListModel<String> listModel = (DefaultListModel<String>) jList.getModel();
        
    }
    
    //操作剖面对象的右键菜单
    public static void opRightClick(final JList<String> jList1, final String profileCNShortName, final JRootPane rootPane, java.awt.event.MouseEvent evt, final List<OperationObject> operationObjectList){
        int leadSelectedIndex = jList1.getLeadSelectionIndex();
        final int[] selectedIndex = jList1.getSelectedIndices();
        if(selectedIndex == null || selectedIndex.length == 0){
            return;
        }
        //判断是否为右键单击，以便实现右键弹出菜单
        if (evt.isPopupTrigger() && leadSelectedIndex != 0) {
            JPopupMenu popMenu = new JPopupMenu();
            JMenuItem menuItemDelete = new JMenuItem("删除"+profileCNShortName);
            //执行删除动作
            menuItemDelete.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int confirmFlag = JOptionPane.showConfirmDialog(rootPane, "要删除选中的"+profileCNShortName+"吗？", "删除"+profileCNShortName, JOptionPane.YES_NO_OPTION);
                    if(confirmFlag != 0){
                        return;
                    }
                    DefaultListModel<String> listModel = (DefaultListModel<String>)jList1.getModel();
                    for(int i = selectedIndex.length - 1; i >= 0; i--){
                        String valueString = listModel.getElementAt(selectedIndex[i]);
                        String[] splitArray = valueString.split(" ");
                        String possilibityString = "";
                        if(splitArray.length > 1){
                            for(int j = 1; j < splitArray.length; j++){
                                if(!splitArray[j].trim().isEmpty()){
                                    possilibityString = splitArray[j];
                                }
                            }
                        }
                        if(possilibityString.trim().isEmpty()){
                            possilibityString = "0.0";
                        }
                        OperationObject operationObject = new OperationObject(splitArray[0], Float.parseFloat(possilibityString));
                        operationObjectList.remove(operationObject);
                        listModel.remove(selectedIndex[i]);
                        jList1.setModel(listModel);
                    }
                    
                }
            });
            popMenu.add(menuItemDelete);
            popMenu.show(evt.getComponent(), evt.getX(), evt.getY()); //弹出菜单的显示位置
        }
    }
}