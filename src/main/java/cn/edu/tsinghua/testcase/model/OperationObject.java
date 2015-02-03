package cn.edu.tsinghua.testcase.model;

import cn.edu.tsinghua.util.Constant;
import java.io.Serializable;

/**操作对象
 * Created by lei on 2014/8/27.
 */
public class OperationObject implements Serializable{
    //操作名称
    private String name;
    //操作出现概率
    private Float possibility;
    
    //操作类型：例如客户，用户，操作等
    private String type;
    
    //操作失败时的损失量
    private long lossWeight;

    public OperationObject(String name, Float possibility, String type) {
        //默认lossWeight赋值为0
        this(name, possibility, type, 0l);
    }
    
    public OperationObject(String name, Float possibility, String type, long lossWeight) {
        this.name = name;
        this.possibility = possibility;
        this.type = type;
        this.lossWeight = lossWeight;
    }

    public OperationObject(String name, Float possibility) {
        //默认type为null
        this(name,possibility,null);
    }

    public OperationObject() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPossibility() {
        return possibility;
    }

    public void setPossibility(Float possibility) {
        this.possibility = possibility;
    }

    @Override
    public String toString() {
        if(type == null){
            return name;
        }else{
            return type+Constant.CN_COMMA__STRING+name;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof OperationObject){
            OperationObject operationObject = (OperationObject)obj;
            if(operationObject.getName().equals(getName()) && operationObject.getPossibility().equals(getPossibility())){
                return true;
            }
        }
        return false;
        
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 97 * hash + (this.possibility != null ? this.possibility.hashCode() : 0);
        hash = 97 * hash + (this.type != null ? this.type.hashCode() : 0);
        return hash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getLossWeight() {
        return lossWeight;
    }

    public void setLossWeight(long lossWeight) {
        this.lossWeight = lossWeight;
    }
}
