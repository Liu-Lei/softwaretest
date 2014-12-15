/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cn.edu.tsinghua.util;

import cn.edu.tsinghua.testcase.model.OperateParameter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * XML的工具类，包含生成XML文件等一些方法
 * @author lei
 */
public class XMLUtil {
    
    private static Logger logger = LoggerFactory.getLogger(XMLUtil.class);
    
    private static DocumentBuilder builder = null;
    private static TransformerFactory tf = null;
    private static Random random = new Random(System.currentTimeMillis());
    
    //初始化XML DocumentBuilder
    public static void initDocumentBuilder(){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            logger.error(ex.getMessage());
        }
    }
    
    /**
     * 根据相应参数生成对应的操作用例文件
     * @param storagePath
     * @param functionName
     * @param operationName
     * @param operateParameterList 
     */
    public static void generateXMLFileByOperation(String storagePath, String functionName, String operationName, List<OperateParameter> operateParameterList, int serialNumber) throws FileNotFoundException{
        if(builder == null){
            initDocumentBuilder();
        }
        Document xmlDocument = builder.newDocument();
        //创建XML文件根节点
        Element root = xmlDocument.createElement("testcase");
        xmlDocument.appendChild(root);
        //创建功能名称节点
        Element functionElement = xmlDocument.createElement("function_name");
        functionElement.appendChild(xmlDocument.createTextNode(functionName));
        root.appendChild(functionElement);
        //创建操作名称节点
        Element operationElement = xmlDocument.createElement("operation_name");
        operationElement.appendChild(xmlDocument.createTextNode(operationName));
        root.appendChild(operationElement);
        
        
        //创建操作参数列表节点
        if(operateParameterList != null && operateParameterList.size() > 0){
            Element parasElement = xmlDocument.createElement("parameters");
            
            for(OperateParameter parameter : operateParameterList){
                float paraPossibility = parameter.getPossibility();
                if(getRandomValue(paraPossibility)){
                    Element paraElement = xmlDocument.createElement("para");
                    paraElement.setAttribute("name",parameter.getName());
                    paraElement.setAttribute("value", getParameterValueString(parameter));
                    parasElement.appendChild(paraElement);
                }
            }
            root.appendChild(parasElement);
        }
        
        //生成XML文件
        String fileName = new StringBuilder(storagePath).append("/").append(functionName).append(Constant.UNDERLINE_STRING).append(operationName).append(Constant.UNDERLINE_STRING).append(serialNumber).append(".xml").toString();
        File file = new File(fileName);
        if(tf == null){
            tf = TransformerFactory.newInstance();
        }
        try {
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(xmlDocument);
            transformer.setOutputProperty(OutputKeys.ENCODING, "gb2312");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            PrintWriter pw = new PrintWriter(new FileOutputStream(file));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
            System.out.println("生成XML文件成功!");
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException ex) {
            System.out.println(ex.getMessage());
        } 
        
    }
    
    //根据概率来算出一次执行是否会有
    public static boolean getRandomValue(float possibility) {
        double rndValue = Math.random();
        if(rndValue < possibility){
            return true;
        }
        return false;
    }
    
    //根据参数值以及参数值出现的概率选择一个参数值
    public static String getParameterValueString(OperateParameter parameter) {
        String paraValueAndPossibility = parameter.getParaValuePossibility();
        String[] paraVAPArray = paraValueAndPossibility.split(Constant.PARA_SPLIT_STRING);
        String[] paraValueArray = new String[paraVAPArray.length];
        String[] paraPossibilityArray = new String[paraVAPArray.length];
        
        //split参数值以及概率字符串
        for(int i = 0; i < paraVAPArray.length; i++){
            String[] vapSplitArray = paraVAPArray[i].split(",");
            paraValueArray[i] = vapSplitArray[0];
            paraPossibilityArray[i] = vapSplitArray[1];
        }
        
        //把参数概率按照概率分布在一个0-1的线段上
        float[] possibilityFloatArray = new float[paraPossibilityArray.length];
        for(int i = 0; i < paraPossibilityArray.length; i++){
            float possibility = Float.parseFloat(paraPossibilityArray[i]);
            if(i > 0){
                possibilityFloatArray[i] = possibility + possibilityFloatArray[i-1];
            }else{
                possibilityFloatArray[i] = possibility;
            }
        }
        //取一个介于0和1之间的随机数，用于选取参数值
        double rndValue = Math.random();
        int chooseIndex = 0;
        for(int i = 0; i < possibilityFloatArray.length; i++){
            if(rndValue < possibilityFloatArray[i]){
                chooseIndex = i;
                break;
            }
        }
        
        String chooseValue = paraValueArray[chooseIndex];
        switch(parameter.getType()){
            case INTEGER:
                if(chooseValue.contains(Constant.EN_DASH_STRING)){
                    int startInt = Integer.parseInt(chooseValue.substring(1,chooseValue.indexOf(Constant.EN_DASH_STRING)));
                    int endInt = Integer.parseInt(chooseValue.substring(chooseValue.indexOf(Constant.EN_DASH_STRING),chooseValue.length()-1));
                    return ""+(startInt+random.nextInt(endInt-startInt));
                }else{
                    return chooseValue;
                }
            case FLOAT:
                if(chooseValue.contains(Constant.EN_DASH_STRING)){
                    float startFloat = Float.parseFloat(chooseValue.substring(1,chooseValue.indexOf(Constant.EN_DASH_STRING)));
                    float endFloat = Float.parseFloat(chooseValue.substring(chooseValue.indexOf(Constant.EN_DASH_STRING),chooseValue.length()-1));
                    return ""+(startFloat+random.nextFloat()*(endFloat-startFloat));
                }else{
                    return chooseValue;
                }
            case ENUM:
                return chooseValue;
            case STRING:
                return chooseValue;
            default:
                logger.error("Never print this!!");
                return "null";
        }
        
    }
    
    public static void main(String[] args) {
        String[] paraPossibilityArray = {"0.8","0.1","0.1"};
        float[] possibilityFloatArray = new float[paraPossibilityArray.length];
        for(int i = 0; i < paraPossibilityArray.length; i++){
            float possibility = Float.parseFloat(paraPossibilityArray[i]);
            if(i > 0){
                possibilityFloatArray[i] = possibility + possibilityFloatArray[i-1];
            }else{
                possibilityFloatArray[i] = possibility;
            }
            
            System.out.println(possibilityFloatArray[i]);
        }
    }
    
}
