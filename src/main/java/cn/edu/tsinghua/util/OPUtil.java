/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cn.edu.tsinghua.util;

import cn.edu.tsinghua.testcase.model.OperationObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author liulei
 */
public class OPUtil {

    //根据profile Map获取下一级Operation name和possibility Map
    public static Map<String, Float> getOverallOperationList(Map<OperationObject, List<OperationObject>> profileMap) {
        Map<String, Float> opMap = new HashMap<String, Float>();
        
        for(OperationObject fatherOperationObject : profileMap.keySet()){
            Float fatherPossibility = fatherOperationObject.getPossibility();
            List<OperationObject> opList = profileMap.get(fatherOperationObject);
            
            for(OperationObject operationObject : opList){
                String opName = operationObject.getName();
                Float opPossibility = operationObject.getPossibility();
                if(opMap.containsKey(opName)){
                    opPossibility += opMap.get(opName);
                }
                opMap.put(opName, opPossibility);
            }
        }
        return opMap;
    }
    
}
