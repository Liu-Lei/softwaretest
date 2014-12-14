package cn.edu.tsinghua;

import cn.edu.tsinghua.util.Constant;

/**
 * Hello world!
 *
 */
public class HelloWorld
{
    public static void main( String[] args )
    {
        String str = "客户名称       概率          ";
        String[] splitArray = str.split("\\s");
        System.out.println(splitArray.length);
        for(String slice : splitArray){
            System.out.println(slice);
        }
        
    }
}
