/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.netbeans;

import cn.edu.tsinghua.testcase.model.OperateParameter;
import cn.edu.tsinghua.testcase.model.OperationObject;
import cn.edu.tsinghua.testcase.model.UserProfile;
import cn.edu.tsinghua.util.CheckUtil;
import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.JFrameUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author liulei
 */
public class OperationalProfileUI extends javax.swing.JFrame {

    private String profileCNShortName = "操作";

    private String profileCNName = "操作名称";

    private Map<String, StringBuffer> stringMap;

    private String projectName;
    private DefaultMutableTreeNode treeRoot = null;
    //key->operate value ->operate parameter
    Map<OperationObject, List<OperateParameter>> opearteParamterMap;
    //key->father op name, value->sun op list
    private Map<OperationObject, List<OperationObject>> operationalProfileMap;
    
    
    private OPFunctionalUI previousUI;
    private CreateTestCaseUI nextUI;

    OperationalProfileUI(String projectName, Map<String, Float> profileMap, OPFunctionalUI functionalUI) {
        super("OPERATIONAL PROFILE");
        initComponents();
        this.previousUI = functionalUI;
        JFrameUtil.setFrameLocationToMiddle(this);
        
        this.projectName = projectName;
        //设置项目名称
        jLabel3.setText(projectName);
        this.setResizable(false);
        this.setVisible(true);

        stringMap = new HashMap<String, StringBuffer>();
        operationalProfileMap = new HashMap<OperationObject, List<OperationObject>>();
        opearteParamterMap = new HashMap<OperationObject, List<OperateParameter>>();

        //初始化下拉框，stringMap和操作剖面Map
        for (String keyString : profileMap.keySet()) {
            OperationObject operationObject = new OperationObject(keyString, profileMap.get(keyString), "功能");
            //    jComboBox1.addItem(operationObject);
            operationalProfileMap.put(operationObject, new ArrayList<OperationObject>());
            stringMap.put(keyString, new StringBuffer());
        }

        treeInitialize(profileMap);
    }

    //init the tree

    private void treeInitialize(Map<String, Float> profileMap) {
        treeRoot = new DefaultMutableTreeNode("功能列表");
        for (OperationObject functionObject : operationalProfileMap.keySet()) {
            DefaultMutableTreeNode functionNode = new DefaultMutableTreeNode(functionObject);
            treeRoot.add(functionNode);
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(treeRoot);
        jTree1.setModel(treeModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Operational Profile"));
        jPanel1.setName(""); // NOI18N

        jButton6.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jButton6.setText("上一步");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        jLabel2.setText("项目名称：");

        jLabel3.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel5.setText("请在右侧的功能列表中");

        jTree1.setFont(new java.awt.Font("Microsoft YaHei", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTree1MouseReleased(evt);
            }
        });
        jScrollPane2.setViewportView(jTree1);

        jLabel6.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel6.setText("添加相应操作：");

        jButton8.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jButton8.setText("下一步");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(365, 365, 365)
                        .addComponent(jButton8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 690, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(previousUI != null){
            previousUI.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTree1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTree1MouseReleased
        final DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();//获取选中的节点
        DefaultMutableTreeNode parentNode = null;
        DefaultMutableTreeNode grandParentNode = null;
        if(selectedNode != null){
            parentNode = (DefaultMutableTreeNode) selectedNode.getParent(); //获取选中节点的父节点
        }
        if (parentNode != null) {
            grandParentNode = (DefaultMutableTreeNode) parentNode.getParent(); //获取选中节点的父节点的父节点
        }

        JPopupMenu popMenu = new JPopupMenu();
        //判断是否为右键单击，以便实现右键弹出菜单
        if (evt.isPopupTrigger()) { 
            //功能列表的弹出菜单，用来添加操作节点
            if (parentNode != null && parentNode.equals(treeRoot) && grandParentNode == null) {
                JMenuItem MenuRootNode = new JMenuItem("添加操作");
                popMenu.add(MenuRootNode);
                MenuRootNode.addActionListener(new ActionListener() {
                    //添加操作
                    public void actionPerformed(ActionEvent e) {
                        //   OperationObject functionOperationObject = (OperationObject)selectedNode.getUserObject();
                        DefaultMutableTreeNode functionNode = (DefaultMutableTreeNode) jTree1.getLastSelectedPathComponent();
                        
                        String nameString = JOptionPane.showInputDialog(rootPane, "请输入" + profileCNName);
                        String possibilityString = JOptionPane.showInputDialog(rootPane, "请输入"+profileCNShortName+"使用概率");
                        
                        //判断用户名概率是否为空
                        //判断概率是否为浮点类型
                        if(CheckUtil.checkNameAndPossibility(profileCNShortName, nameString, possibilityString, rootPane)){
                            //添加操作进功能操作列表Map
                            OperationObject functionOperationObject = (OperationObject) functionNode.getUserObject();
                            OperationObject operationObject = new OperationObject(nameString, Float.parseFloat(possibilityString),profileCNShortName);
                            operationalProfileMap.get(functionOperationObject).add(operationObject);

                            //在功能列表下级添加操作
                            DefaultMutableTreeNode operationNode = new DefaultMutableTreeNode(operationObject);
                            functionNode.add(operationNode);
                            //--------下面代码实现显示新节点（自动展开父节点）------- 
                            refreshTree(jTree1, operationNode);
                        }else{
                            return;
                        }
                        
                    }
                });
            //操作右键菜单
            } else if (grandParentNode != null && grandParentNode.equals(treeRoot)) {//操作节点的弹出菜单，用来增加操作参数，修改参数等
                JMenuItem MenuLeafNode1 = new JMenuItem("增加操作参数");
                JMenuItem MenuLeafNode2 = new JMenuItem("删除操作");
                popMenu.add(MenuLeafNode1);
                popMenu.add(MenuLeafNode2);
                
                //增加操作参数
                MenuLeafNode1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        OperationObject operationObject = (OperationObject) selectedNode.getUserObject();
                        new AddOperationParameterUI(operationObject,OperationalProfileUI.this,selectedNode);
                    }
                });
                
                //删除操作
                MenuLeafNode2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //验证过程
                        int varifyFlag = JOptionPane.showConfirmDialog(rootPane, "确定删除此操作？", "删除操作", JOptionPane.YES_NO_OPTION);
                        if(varifyFlag == 0){
                            //操作对象
                            OperationObject operationObject = (OperationObject) selectedNode.getUserObject();
                            //从功能列表->操作Map中删除此操作
                            DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)selectedNode.getParent();
                            operationalProfileMap.get(parentNode.getUserObject()).remove(operationObject);
                                
                            //在Tree树上删除此操作
                            parentNode.remove(selectedNode);
                            refreshTree(jTree1, parentNode);
                        }else{
                            // Cancel the delete operate, do nothing
                            ;
                        }
                        
                    }
                });
            //操作参数右键
            } else if (grandParentNode != null && grandParentNode.getParent().equals(treeRoot)){
                JMenuItem rootNode = new JMenuItem("删除操作参数");
                popMenu.add(rootNode);
                rootNode.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //验证过程
                    int varifyFlag = JOptionPane.showConfirmDialog(rootPane, "确定删除此操作参数？", "删除操作参数", JOptionPane.YES_NO_OPTION);
                    if(varifyFlag == 0){
                        //操作参数
                        DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode)selectedNode.getParent();
                        OperateParameter parameter = (OperateParameter) selectedNode.getUserObject();
                        //操作对象
                        OperationObject operationObject = (OperationObject)parentNode.getUserObject();
                        //删除操作对象的参数
                        opearteParamterMap.get(operationObject).remove(parameter);

                        //从JTree上删除操作参数
                        parentNode.remove(selectedNode);
                        refreshTree(jTree1, parentNode);
                    }
                    }
                });
            }
            popMenu.show(evt.getComponent(), evt.getX(), evt.getY()); //弹出菜单的显示位置
        }
    }//GEN-LAST:event_jTree1MouseReleased

    void refreshTree(DefaultMutableTreeNode operateNode, OperateParameter parameter){
        
        //在功能列表下级添加操作
        DefaultMutableTreeNode paraNode = new DefaultMutableTreeNode(parameter);
        operateNode.add(paraNode);
        //--------下面代码实现显示新节点（自动展开父节点）-------  
        refreshTree(jTree1, paraNode);
    }
    
    void refreshTree(JTree jTree, DefaultMutableTreeNode treeNode){
        
        //--------下面代码实现显示新节点（自动展开父节点）-------  
        DefaultTreeModel treeModel = (DefaultTreeModel) jTree.getModel();
        TreeNode[] nodes = treeModel.getPathToRoot(treeNode);
        TreePath path = new TreePath(nodes);
        jTree.scrollPathToVisible(path);
        jTree.updateUI();
        
    }
    
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(nextUI == null){
            nextUI = new CreateTestCaseUI(projectName, opearteParamterMap, operationalProfileMap, this);
        }
        nextUI.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(OperationalProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OperationalProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OperationalProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OperationalProfileUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
        /* Create and display the form */
        final Map<String, Float> opMap = new HashMap<String, Float>();
        opMap.put("Add new User", 0.9f);
        opMap.put("Remove User", 0.1f);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OperationalProfileUI("TEST", opMap, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables

}
