/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.util;

import cn.edu.tsinghua.testcase.model.OperationObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**操作剖面操作的一些工具类
 *
 * @author lei
 */
public class OPUtil {
    
    //根据操作剖面的层级Map获取聚合后的操作剖面Map
    public static Map<String,Float> getOverallOperationList(Map<OperationObject,List<OperationObject>> profileMap){
        Map<String,Float> overallOperationMap = new HashMap<String, Float>();
        
        for(OperationObject fatherOperationObject : profileMap.keySet()){
            float fatherOPPossibility = fatherOperationObject.getPossibility();
            for(OperationObject sonOperationObject : profileMap.get(fatherOperationObject)){
                String sunOPName = sonOperationObject.getName();
                float sunOPPossibility = fatherOPPossibility*sonOperationObject.getPossibility();
                
                if(overallOperationMap.containsKey(sunOPName)){
                    sunOPPossibility += overallOperationMap.get(sunOPName);
                }
                
                overallOperationMap.put(sunOPName, sunOPPossibility);
            }
        }
        
        return overallOperationMap;
    }
}
