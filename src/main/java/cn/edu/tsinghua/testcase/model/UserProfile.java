package cn.edu.tsinghua.testcase.model;

import java.util.List;

/**用户剖面
 * Created by liulei on 2014/7/30.
 */
public class UserProfile {
    private OperationObject customerObject;
    private List<OperationObject> userObjectList;

    public OperationObject getCustomerObject() {
        return customerObject;
    }

    public void setCustomerObject(OperationObject customerObject) {
        this.customerObject = customerObject;
    }

    public List<OperationObject> getUserObjectList() {
        return userObjectList;
    }

    public void setUserObjectList(List<OperationObject> userObjectList) {
        this.userObjectList = userObjectList;
    }
    
}
