/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.testcase.model;

import cn.edu.tsinghua.util.Constant;

/**
 *
 * @author lei
 */
public enum ParameterType {
    INTEGER(Constant.PARAMETER_TYPE_INTEGER),FLOAT(Constant.PARAMETER_TYPE_FLOAT),STRING(Constant.PARAMETER_TYPE_STRING),ENUM(Constant.PARAMETER_TYPE_ENUM);
    
    private String cnName;
        private ParameterType(String cnName) {
        this.cnName = cnName;
    }
    
    @Override
    public String toString(){
        return cnName;
    }
}
