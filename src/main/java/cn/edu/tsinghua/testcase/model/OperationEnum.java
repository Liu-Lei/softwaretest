/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.testcase.model;

/**
 *
 * @author liulei
 */
public enum OperationEnum {
    CUSTOMER("客户"),
    USER("用户"),
    SYSTEM_MODE("系统模式"),
    FUNCTION("功能"),
    OPERATION("操作");
    
    private String value;
    private OperationEnum(String value){
        this.value = value;
    }
    
    public static String getValue(String name){
        return OperationEnum.valueOf(name).value;
    }
    
    
    public static void main(String[] args){
        System.out.println(CUSTOMER.toString());
        System.out.println(CUSTOMER.value);
        System.out.println(CUSTOMER.name());
        System.out.println(CUSTOMER.ordinal());
    }
}
