/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.testcase.model;

/**
 *
 * @author lei
 */
public enum ParameterType {
    INTEGER("整形"),FLOAT("浮点型"),STRING("字符型"),ENUM("枚举型");
    
    private String cnName;
    private ParameterType(String cnName) {
        this.cnName = cnName;
    }
    
    @Override
    public String toString(){
        return cnName;
    }
}
