/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.netbeans;

import cn.edu.tsinghua.testcase.model.OperationObject;
import java.awt.HeadlessException;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;

/**
 * 其他操作对象JFrame的父类，一些基础信息
 * @author liulei
 */
public class BaseJFrame extends javax.swing.JFrame{
    //ListModel Map
    protected Map<OperationObject, DefaultListModel<String>> listModelmap;
    
    //默认的listModel
    protected DefaultListModel<String> defaultListModel = new DefaultListModel<String>();
    
    //此操作对象的简称，可通过OperationEnum.value获取
    protected String profileCNShortName;
    
    //操作对象简称+"名称"
    protected String profileCNName;
    
    //项目名称
    protected String projectName;
    
    //操作对象上级-》下级List
    protected Map<OperationObject,List<OperationObject>> profileMap;
    
    //父级操作对象List
    protected List<OperationObject> fatherProfileList;
    
    //上级JFrame对象
    protected JFrame previousUI;
    //下级JFrame对象
    protected OPSystemModeUI nextUI;

    public BaseJFrame() throws HeadlessException {
    }

    public BaseJFrame(String title) throws HeadlessException {
        super(title);
    }

    public Map<OperationObject, DefaultListModel<String>> getListModelmap() {
        return listModelmap;
    }

    public void setListModelmap(Map<OperationObject, DefaultListModel<String>> listModelmap) {
        this.listModelmap = listModelmap;
    }

    public DefaultListModel<String> getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel<String> defaultListModel) {
        this.defaultListModel = defaultListModel;
    }

    public String getProfileCNShortName() {
        return profileCNShortName;
    }

    public void setProfileCNShortName(String profileCNShortName) {
        this.profileCNShortName = profileCNShortName;
    }

    public String getProfileCNName() {
        return profileCNName;
    }

    public void setProfileCNName(String profileCNName) {
        this.profileCNName = profileCNName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Map<OperationObject, List<OperationObject>> getProfileMap() {
        return profileMap;
    }

    public void setProfileMap(Map<OperationObject, List<OperationObject>> profileMap) {
        this.profileMap = profileMap;
    }

    public List<OperationObject> getFatherProfileList() {
        return fatherProfileList;
    }

    public void setFatherProfileList(List<OperationObject> fatherProfileList) {
        this.fatherProfileList = fatherProfileList;
    }

    public JFrame getPreviousUI() {
        return previousUI;
    }

    public void setPreviousUI(JFrame previousUI) {
        this.previousUI = previousUI;
    }

    public OPSystemModeUI getNextUI() {
        return nextUI;
    }

    public void setNextUI(OPSystemModeUI nextUI) {
        this.nextUI = nextUI;
    }
}
