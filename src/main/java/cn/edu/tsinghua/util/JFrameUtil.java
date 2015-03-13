package cn.edu.tsinghua.util;

import cn.edu.tsinghua.netbeans.BaseJFrame;
import cn.edu.tsinghua.netbeans.OPCustomerUI;
import cn.edu.tsinghua.netbeans.OPSystemModeUI;
import cn.edu.tsinghua.testcase.model.OperationEnum;
import cn.edu.tsinghua.testcase.model.OperationObject;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
     * 通用初始化JFrame的操作,并把frame位置设置到屏幕的中间
     */
    public static void initAndSetToMiddle(JFrame frame){
        init(frame, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
        setFrameLocationToMiddle(frame);
    }
    /**
     * 通用初始化JFrame的操作,并把frame位置设置到屏幕的中间
     */
    public static void initAndSetToMiddle(JFrame frame,int width, int height){
        init(frame, width, height);
        setFrameLocationToMiddle(frame);
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
        setFrameLocationToMiddle(frame, Constant.FRAME_WIDTH, Constant.FRAME_HEIGHT);
    }
    
    //设置界面在屏幕中居中显示
    public static void setFrameLocationToMiddle(JFrame frame, int frameWidth, int frameHeight) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((int)screenSize.getWidth()/2-frameWidth/2,(int)screenSize.getHeight()/2-frameHeight/2);
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
        DefaultListModel<String> listModel;
        if(jList.getModel().getSize() == 0){
            listModel = getJListModelByOperationObject(new DefaultListModel(), operationObject, profileCNName);
        }else{
            listModel = getJListModelByOperationObject((DefaultListModel) jList.getModel(), operationObject, profileCNName);
        }
        jList.setModel(listModel);
    }
    
    //增加item至jListModel
    public static DefaultListModel getJListModelByOperationObject(DefaultListModel listModel, OperationObject operationObject, String profileCNName){
        String jListTitle =getFormatJListText(profileCNName, "概率", 32);
        if(listModel.getSize() == 0){
            listModel = new DefaultListModel<String>();
            listModel.add(0,jListTitle);
        }
        
        if(operationObject != null){
            String newOP = getFormatJListText(operationObject.getName(), operationObject.getPossibility().toString(), 40);
            listModel.add(listModel.size(), newOP);
        }
        return listModel;
    }
    
    /**
     * 操作剖面List右键菜单
     * @param jList1
     * @param profileCNShortName
     * @param rootPane
     * @param evt
     * @param operationObjectList 
     */
    public static void opRightClick(final JList<String> jList1, final String profileCNShortName, 
            final JRootPane rootPane, java.awt.event.MouseEvent evt, final List<OperationObject> operationObjectList){
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
    /**
     * 操作对象JList右键菜单
     * @param jList1 容器
     * @param profileCNShortName 剖面名称
     * @param rootPane rootPane
     * @param evt 事件
     * @param userProfileMap 操作对象对应map
     * @param obj jCombox选择的父级对象
     */
    public static void opRightClick(final JList<String> jList1, final String profileCNShortName, final JRootPane rootPane, 
            java.awt.event.MouseEvent evt, final Map<OperationObject,List<OperationObject>> profileMap, Object obj){
        if(obj instanceof OperationObject){
            OperationObject selectedOperationObject = (OperationObject)obj;
            opRightClick(jList1, profileCNShortName, rootPane, 
                    evt, profileMap.get(selectedOperationObject));
        }
    }
    
    
    /**
     * 初始化JFrame
     * @param currentFrame
     * @param projectName
     * @param fatherProfileList
     * @param operationEnum
     * @param defaultListModel
     * @param jList
     * @param jComboBox 
     */
    public static void initTheJFrame(BaseJFrame currentFrame, String projectName, List<OperationObject> fatherProfileList, OperationEnum fatherEnum,
            OperationEnum currentEnum, JList<String> jList, JComboBox<OperationObject> jComboBox, JFrame previousUI, JLabel label) {
        //设置项目名称
        label.setText(projectName);
        DefaultListModel<String> defaultListModel = currentFrame.getDefaultListModel();
        defaultListModel.addElement("请先选择"+OperationEnum.getValue(fatherEnum.name())+"操作剖面");
        currentFrame.setPreviousUI(previousUI);
        jList.setModel(defaultListModel);
        //设置界面在屏幕中居中显示
        JFrameUtil.setFrameLocationToMiddle(currentFrame);
        currentFrame.setProjectName(projectName);
        currentFrame.setResizable(false);
        currentFrame.setProfileCNShortName(OperationEnum.getValue(currentEnum.name()));
        currentFrame.setProfileCNName(OperationEnum.getValue(currentEnum.name())+"名称");
        
        //设置客户剖面列表和用户剖面列表
        currentFrame.setFatherProfileList(fatherProfileList);
        currentFrame.setProfileMap(new HashMap<OperationObject, List<OperationObject>>());
        
        //init the list Model map
        currentFrame.setListModelmap(new HashMap<OperationObject, DefaultListModel<String>>());
        //初始化下拉框等信息
        for(OperationObject fatherOperationObject : fatherProfileList){
            jComboBox.addItem(fatherOperationObject);
            currentFrame.getProfileMap().put(fatherOperationObject, new ArrayList<OperationObject>());
            currentFrame.getListModelmap().put(fatherOperationObject, 
                    JFrameUtil.getJListModelByOperationObject(new DefaultListModel<String>(), null, currentFrame.getProfileCNName()));
        }
    }
    
    /**
     * 下拉框变动事件
     * @param currentJFrame
     * @param jList
     * @param jComboBox 
     */
    public static void jComboBoxItemChanged(BaseJFrame currentJFrame, JList<String> jList, JComboBox<OperationObject> jComboBox){
        Object selectedObject = jComboBox.getSelectedItem();
        if(selectedObject instanceof OperationObject){
            OperationObject customerObject = (OperationObject) selectedObject;
            jList.setModel(currentJFrame.getListModelmap().get(customerObject));
        }else{
            jList.setModel(currentJFrame.getDefaultListModel());
        }
    }
    
    public static void nextStepAction(BaseJFrame currentJFrame){
        currentJFrame.dispose();
        Map<String, Float> OPMap = OPUtil.getOverallOperationList(currentJFrame.getProfileMap());
    }
    
    public static void addNewOperationObject(BaseJFrame currentJFrame, JComboBox<OperationObject> jComboBox, JRootPane rootPane, OperationEnum fatherEnum){
        Object selectedObject = jComboBox.getSelectedItem();
        if(selectedObject instanceof OperationObject){
            String userName = JOptionPane.showInputDialog(currentJFrame,"请输入"+currentJFrame.getProfileCNName()
                    +"（不同"+OperationEnum.getValue(fatherEnum.name())+"的同一类别"+currentJFrame.getProfileCNName()+
                    "需用同一个"+currentJFrame.getProfileCNName()+"）");
            String userPro = JOptionPane.showInputDialog(currentJFrame,"请输入"+currentJFrame.getProfileCNShortName()+"使用概率");
            //检查输入的名称和概率是否合法
            if(CheckUtil.checkNameAndPossibility(currentJFrame.getProfileCNShortName(), userName, userPro, rootPane)){
                OperationObject customerObject = (OperationObject)selectedObject;
                OperationObject userObject = new OperationObject(userName, Float.parseFloat(userPro));
                JFrameUtil.getJListModelByOperationObject(currentJFrame.getListModelmap().get(customerObject), userObject, currentJFrame.getProfileCNName());
                List<OperationObject> userObjectList = currentJFrame.getProfileMap().get(customerObject);
                userObjectList.add(userObject);
            }
        }else{
            JOptionPane.showMessageDialog(currentJFrame, currentJFrame.getDefaultListModel().get(0));
        }
    }
}