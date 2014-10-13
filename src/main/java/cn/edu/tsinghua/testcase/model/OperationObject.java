package cn.edu.tsinghua.testcase.model;

import cn.edu.tsinghua.util.Constant;
import java.io.Serializable;

/**操作对象
 * Created by lei on 2014/8/27.
 */
public class OperationObject implements Serializable{
    private String name;
    private Float possibility;
    
    private String type;

    public OperationObject(String name, Float possibility, String type) {
        this.name = name;
        this.possibility = possibility;
        this.type = type;
    }

    public OperationObject(String name, Float possibility) {
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
    
}
