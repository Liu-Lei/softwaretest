/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.util;

import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 * 检验参数是否合法等工具方法
 * @author lei
 */
public class CheckUtil {
    private static String OPERATE_POSSIBILITY = "操作概率";
    private static String CANNOT_EMPTY = "不能为空";
    /**
     * 判断用户名概率是否为空
     * 判断概率是否为浮点类型，是否在（0，1]区间之中
    */
    public static boolean checkNameAndPossibility(String profileCNShortName, String nameString, String possibilityString, JRootPane rootPane){
        if(isEmptyString(nameString) || isEmptyString(possibilityString)){
            JOptionPane.showMessageDialog(rootPane, profileCNShortName+"名称或者"+OPERATE_POSSIBILITY+CANNOT_EMPTY);
            return false;
        }else{
            try {
                Float possibilityFloat = Float.parseFloat(possibilityString);
                
                if(possibilityFloat > 1 || possibilityFloat <= 0){
                    throw new Exception("Float not satisfied!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, OPERATE_POSSIBILITY+"必须为大于0并且不大于1的浮点数");
                return false;
            }
        }
        return true;
    }
    
    
    //判断str是否为null或者为空
    public static boolean isEmptyString(String str){
        if(str == null || str.trim().isEmpty()){
            return true;
        }
        return false;
    }
}
