/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.util;

import cn.edu.tsinghua.testcase.model.ParameterType;
import java.awt.TrayIcon;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

/**
 * 检验参数是否合法等工具方法
 *
 * @author lei
 */
public class CheckUtil {

    private static String OPERATE_POSSIBILITY = "操作概率";
    private static String CANNOT_EMPTY = "不能为空";

    /**
     * 判断用户名概率是否为空 判断概率是否为浮点类型，是否在（0，1]区间之中
     */
    public static boolean checkNameAndPossibility(String profileCNShortName, String nameString, String possibilityString, JRootPane rootPane) {
        if (isEmptyString(nameString) || isEmptyString(possibilityString)) {
            JOptionPane.showMessageDialog(rootPane, profileCNShortName + "名称或者" + OPERATE_POSSIBILITY + CANNOT_EMPTY);
            return false;
        } else {
            try {
                Float possibilityFloat = Float.parseFloat(possibilityString);

                if (possibilityFloat > 1 || possibilityFloat <= 0) {
                    throw new Exception("Float not satisfied!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, OPERATE_POSSIBILITY + "必须为大于0并且不大于1的浮点数");
                return false;
            }
        }
        return true;
    }

    //判断str是否为null或者为空
    public static boolean isEmptyString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    //检查操作参数信息是否符合规则
    public static boolean checkOperationParameter(String paraName, String possibilityString,
            Object parameterTypeObj, String valueAndPossibilityString, JRootPane rootPane, String tipsString) {

        if (checkNameAndPossibility("操作参数", paraName, possibilityString, rootPane)) {
            //检查参数类型和参数值的分配是否正确
            if (parameterTypeObj != null || !isEmptyString(valueAndPossibilityString)) {
                if (parameterTypeObj instanceof ParameterType) {
                    try {
                        String[] valueAndPossibilityArray = valueAndPossibilityString.split(Constant.PARA_SPLIT_STRING);
                        String[] valueArray = new String[valueAndPossibilityArray.length];
                        String[] possibilityArray = new String[valueAndPossibilityArray.length];
                        for (int i = 0; i < valueAndPossibilityArray.length; i++) {
                            String[] valueAndPossibilitySplit = valueAndPossibilityArray[i].split(Constant.COMMA_SYMBOL_STRING);
                            float possibility = Float.parseFloat(valueAndPossibilitySplit[1]);

                            String chooseValue = valueAndPossibilitySplit[0];
                            if (isEmptyString(chooseValue)) {
                                JOptionPane.showMessageDialog(rootPane, tipsString);
                                return false;
                            }
                            ParameterType parameterType = (ParameterType) parameterTypeObj;
                            switch (parameterType) {
                                case INTEGER:
                                    if (chooseValue.contains(Constant.EN_DASH_STRING)) {
                                        int startInt = Integer.parseInt(chooseValue.substring(1, chooseValue.indexOf(Constant.EN_DASH_STRING)));
                                        int endInt = Integer.parseInt(chooseValue.substring(chooseValue.indexOf(Constant.EN_DASH_STRING), chooseValue.length() - 1));
                                        return true;
                                    }else{
                                        Integer.parseInt(chooseValue);
                                    }
                                case FLOAT:
                                    if (chooseValue.contains(Constant.EN_DASH_STRING)) {
                                        float startFloat = Float.parseFloat(chooseValue.substring(1, chooseValue.indexOf(Constant.EN_DASH_STRING)));
                                        float endFloat = Float.parseFloat(chooseValue.substring(chooseValue.indexOf(Constant.EN_DASH_STRING), chooseValue.length() - 1));
                                        return true;
                                    }else{
                                        Float.parseFloat(chooseValue);
                                    }
                            }
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, tipsString, "参数值格式错误", JOptionPane.ERROR_MESSAGE);
                        return false;
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "请选择操作参数类型！");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "操作参数类型或者操作值不能为空！");
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
