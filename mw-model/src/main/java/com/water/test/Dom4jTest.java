package com.water.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/9/12.
 */
public class Dom4jTest {

    public static void main(String[] args) {

        Dom4jTest test = new Dom4jTest();
        test.addXml();
    }

    public void readXml(){
        /**使用dom4j来解析xml文件*/
        SAXReader reader = new SAXReader();
        try {
            String classPath = this.getClass().getClassLoader().getResource("").getPath();
            System.out.println(classPath);
            Document doc = reader.read(new File(classPath+"db/apiParams.xml"));
            //获取xml文件的根节点
            Element rootElement = doc.getRootElement();

            Element apiParam=null;
            Iterator tickets = null;
            for (tickets = rootElement.elementIterator(); tickets.hasNext();) {
                apiParam = (Element) tickets.next();

                String name = apiParam.element("name").getTextTrim();
                String description = apiParam.element("description").getTextTrim();

                System.out.println("参数名："+name+" / 描述："+description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addXml() {
        /**使用dom4j来解析xml文件*/
        SAXReader reader = new SAXReader();

        try {
            String classPath = this.getClass().getClassLoader().getResource("").getPath();
            System.out.println(classPath);
            Document doc = reader.read(new File(classPath+"db/apiParams.xml"));
            //获取xml文件的根节点
            Element rootElement = doc.getRootElement();
            Element element = rootElement.addElement("api-param");
            Element name_element = element.addElement("name");
            name_element.setText("password");

            Element description_element = element.addElement("description");
            description_element.setText("密码");

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(classPath+"db/apiParams.xml"),format);
            writer.write(doc);
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
