/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.testcase.model;

import cn.edu.tsinghua.util.Constant;

/**
 * 操作参数
 * @author LiuLei
 */
public class OperateParameter {
    private String name;
    private float possibility;
    private ParameterType type;
    private String paraValuePossibility;
    
    private String value;

    public OperateParameter(String name, float possibility, ParameterType type, String paraValuePossibility, String value) {
        this.name = name;
        this.possibility = possibility;
        this.type = type;
        this.paraValuePossibility = paraValuePossibility;
        this.value = value;
    }

    public OperateParameter() {
    }
    
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPossibility() {
        return possibility;
    }

    public void setPossibility(float possibility) {
        this.possibility = possibility;
    }

    public ParameterType getType() {
        return type;
    }

    public void setType(ParameterType type) {
        this.type = type;
    }

    public String getParaValuePossibility() {
        return paraValuePossibility;
    }

    public void setParaValuePossibility(String paraValuePossibility) {
        this.paraValuePossibility = paraValuePossibility;
    }
    
    @Override
    public String toString(){
        return "参数："+name+Constant.BLANK__STRING+possibility;
    }
    
}
