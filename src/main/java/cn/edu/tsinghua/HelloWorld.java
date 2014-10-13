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
        String str = "AAAA 0.2";
        System.out.println(str.substring(0, str.indexOf(Constant.BLANK__STRING)));
        System.out.println(str.substring(str.indexOf(Constant.BLANK__STRING)+1));
    }
}
