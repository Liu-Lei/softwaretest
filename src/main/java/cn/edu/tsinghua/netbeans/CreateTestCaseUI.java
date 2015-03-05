/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.netbeans;

import cn.edu.tsinghua.testcase.model.OperateParameter;
import cn.edu.tsinghua.testcase.model.OperationObject;
import cn.edu.tsinghua.util.Constant;
import cn.edu.tsinghua.util.JFrameUtil;
import cn.edu.tsinghua.util.XMLUtil;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author liulei
 */
public class CreateTestCaseUI extends javax.swing.JFrame {
    
    private Logger logger = LoggerFactory.getLogger(CreateTestCaseUI.class);
    
    private String projectName;
    
    //key->operation object   value->operate parameter
    private Map<OperationObject, List<OperateParameter>> operateParamterMap;
    
    //key -> funcion object  value -> operation object
    private Map<OperationObject, List<OperationObject>> operationalProfileMap;
    private OperationalProfileUI previousUI;
    private OPSystemModeUI nextUI;

    /**初始化用户剖面构造
     * Creates new form OPUserUI
     */
    public CreateTestCaseUI(String projectName, Map<OperationObject, List<OperateParameter>> opearteParamterMap,
            Map<OperationObject, List<OperationObject>> operationalProfileMap,OperationalProfileUI operationalProfileUI) {
        super("OPERATIONAL PROFILE");
        initComponents();
        previousUI = operationalProfileUI;
        //设置界面在屏幕中居中显示
        JFrameUtil.setFrameLocationToMiddle(this);
        this.projectName = projectName;
        //设置项目名称
        jLabel2.setText(jLabel2.getText()+projectName);
        this.setResizable(false);
        //操作参数Map
        this.operateParamterMap = opearteParamterMap;
        //操作剖面参数
        this.operationalProfileMap = operationalProfileMap;
        
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
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Create Testcase"));
        jPanel1.setName(""); // NOI18N

        jButton4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jButton4.setText("开始生成测试用例");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

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

        jLabel4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel4.setText("请输入需要生成的测试用例个数：");

        jTextField1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel6.setText("请输入测试用例存放目录：");

        jTextField2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jButton6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jLabel3)))
                        .addGap(0, 149, Short.MAX_VALUE)))
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 600, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String testcaseCountString = jTextField1.getText();
        String storgePath = jTextField2.getText();
        int testcaseCount = 0;
        try{
            testcaseCount = Integer.parseInt(testcaseCountString);
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(rootPane, "生成的测试用例数量必须为一个整数！");
            logger.error("The test case count isn't a number!");
            return;
        }
        int operationIndex = 0;
        //根据操作以及操作的相应参数生成测试用例XML文件
        if(operateParamterMap != null || operateParamterMap.size() < 1 || operationalProfileMap == null || operationalProfileMap.size() < 1){
            StringBuilder countInfo = new StringBuilder();
            for(OperationObject functionObject : operationalProfileMap.keySet()){
                String functionName = functionObject.getName();
                float functionPossibility = functionObject.getPossibility();
                for(OperationObject operationObject : operationalProfileMap.get(functionObject)){
                    String operationName = operationObject.getName();
                    Long operationLossWeight = operationObject.getLossWeight();
                    int operateCount = (int) (operationObject.getPossibility()*functionPossibility*testcaseCount);
                    System.out.println("operateCount="+operateCount);
                    countInfo.append("操作名称：").append(operationName).append("   ").append("用例数量：").append(operateCount).append("\n");
                    List<OperateParameter> operateParameterList = operateParamterMap.get(operationObject);
                    
                    if(operateCount > 0){
                        //根据需要的操作用例的数量生成对应此操作的测试用例文件
                        for(int i = 0; i < operateCount; i++){
                            try {
                                XMLUtil.generateXMLFileByOperation(storgePath, functionName, operationName, operationLossWeight,operateParameterList, i);
                            } catch (FileNotFoundException ex) {
                                System.out.println(ex.getMessage());
                                continue;
                            }
                        }
                    }
                }
            }
            JOptionPane.showMessageDialog(rootPane, "生成测试用例成功！统计信息如下：\n"+countInfo.toString());
        }else{
            JOptionPane.showMessageDialog(rootPane, "无操作可供生成测试用例，请返回上一步添加操作。");
            return;
        }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(previousUI != null){
            previousUI.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    
    //Opeartion for 
    class OperationCombination implements Comparable<OperationCombination>{
        private OperationObject operationObject;
        private OperationObject fatherOperationObject;

        public OperationObject getOperationObject() {
            return operationObject;
        }

        public void setOperationObject(OperationObject operationObject) {
            this.operationObject = operationObject;
        }

        public OperationObject getFatherOperationObject() {
            return fatherOperationObject;
        }

        public void setFatherOperationObject(OperationObject fatherOperationObject) {
            this.fatherOperationObject = fatherOperationObject;
        }

        public int compareTo(OperationCombination o) {
            return this.operationObject.getPriority() - o.getOperationObject().getPriority();
        }
        
    }
    
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
            java.util.logging.Logger.getLogger(CreateTestCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateTestCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateTestCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateTestCaseUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        final List<OperationObject> customerProfileList = new ArrayList<OperationObject>();
        customerProfileList.add(new OperationObject("北京地铁公司", 0.5f));
        customerProfileList.add(new OperationObject("杭州地铁公司", 0.5f));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateTestCaseUI("TEST", null, null, null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}

