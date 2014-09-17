package cn.edu.tsinghua.testcase.model;

import java.io.Serializable;

/**操作对象
 * Created by lei on 2014/8/27.
 */
public class OperationObject implements Serializable{
    private String name;
    private Float possibility;

    public OperationObject(String name, Float possibility) {
        this.name = name;
        this.possibility = possibility;
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
        return name;
    }
    
}
