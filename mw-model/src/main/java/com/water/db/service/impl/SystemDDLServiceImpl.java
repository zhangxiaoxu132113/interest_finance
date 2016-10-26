package com.water.db.service.impl;

import com.water.db.dao.ISystemDDLDao;
import com.water.db.service.ISystemDDLService;
import com.water.tools.constant.admin.SystemDDLConstant;
import com.water.tools.lang.MWStringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

/**
 * Created by Administrator on 2016/8/31.
 *
 */
@Service(ISystemDDLService.SERVICE_NAME)
public class SystemDDLServiceImpl implements ISystemDDLService {

    @Resource(name = ISystemDDLDao.SERVICE_NAME)
    private ISystemDDLDao systemDDLDao;


    @Override
    public List<Map<String, Object>> findBidCategory() {

        return systemDDLDao.findBidCategory();
    }

    @Override
    public List<Map<String, Object>> findBearingWays() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.BEARING_WAY);
    }

    @Override
    public List<Map<String, Object>> findGuaranteeWays() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.GURANTEE_WAY);
    }

    @Override
    public List<Map<String, Object>> findRepaymentWays() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.REPAYMENT_WAY);
    }

    @Override
    public List<Map<String, Object>> findPlatformBackgroundList() {

        return systemDDLDao.findPlatformBackgroundList();
    }

    @Override
    public List<Map<String, Object>> findGenderList() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.GENDER);
    }

    @Override
    public List<Map<String, Object>> findDepartmentList() {

        return systemDDLDao.findDepartmentList();
    }

    @Override
    public List<Map<String, Object>> findPolitics() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.POLITICS);
    }

    @Override
    public List<Map<String, Object>> findMarriages() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.MARRIAGES);
    }

    @Override
    public List<Map<String, Object>> findJobName() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.JOB_NAME);
    }

    @Override
    public List<Map<String, Object>> findApiType() {

        return systemDDLDao.findInfoListByKeyword(SystemDDLConstant.API_FLAG);
    }

    @Override
    public List<Map<String, Object>> findApiParams(HttpServletRequest request) {

        List<Map<String,Object>> apiParams = new ArrayList<Map<String,Object>>();
        /**使用dom4j来解析xml文件*/
        SAXReader reader = new SAXReader();
        Element apiParam=null;
        Iterator tickets = null;
        try {
//            String classPath = this.getClass().getClassLoader().getResource("").getPath();
//            System.out.println(classPath);configuration
            String path = request.getRealPath("/configuration");
            System.out.println("path");
            Document doc = reader.read(new File(path+"/apiParams.xml"));
            //获取xml文件的根节点
            Element rootElement = doc.getRootElement();
            //循环遍历每一个子节点
            for (tickets = rootElement.elementIterator(); tickets.hasNext();) {
                Map<String,Object> apiParamMap = new HashMap<String,Object>();
                apiParam = (Element) tickets.next();

                String name = apiParam.element("name").getTextTrim();
                String description = apiParam.element("description").getTextTrim();

                apiParamMap.put("name",name);
                apiParamMap.put("description",description);
                apiParams.add(apiParamMap);
                System.out.println("参数名："+name+" / 描述："+description);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apiParams;
    }

    @Override
    public boolean addPlatformParamFlag(HttpServletRequest request, String param_cn_flag, String param_en_flag) {

        /**使用dom4j来解析xml文件*/
        SAXReader reader = new SAXReader();

        try {
            //加载文件
            String path = request.getRealPath("/configuration");
            String fileName = path+"/apiParams.xml";
            Document doc = reader.read(new File(fileName));
            //获取xml文件的根节点
            Element rootElement = doc.getRootElement();
            //追加新的内容
            Element element = rootElement.addElement("api-param");
            Element name_element = element.addElement("name");
            name_element.setText(param_en_flag);

            Element description_element = element.addElement("description");
            description_element.setText(param_cn_flag);

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(fileName),format);
            writer.write(doc);
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeApiParamFlag(HttpServletRequest request,String name, String description) {
        MWStringUtils.isBlank(name,description);
        /**使用dom4j来解析xml文件*/
        SAXReader reader = new SAXReader();

        try {
            //加载文件
            String path = request.getRealPath("/configuration");
            String fileName = path+"/apiParams.xml";
            Document doc = reader.read(new File(fileName));
            //获取xml文件的根节点
            Element rootElement = doc.getRootElement();

            List list = rootElement.elements();
            for (int i=0; i<list.size(); i++) {
                Element element = (Element)list.get(i);
                String nameValue = element.element("name").getTextTrim();
                String descriptionValue = element.element("description").getTextTrim();
                //判断name和description是否一致，如果一致就删除该节点
                if (name.equals(nameValue) && description.equals(descriptionValue)) {
                    rootElement.remove(element);
                }
            }

            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("UTF-8");
            XMLWriter writer = new XMLWriter(new FileOutputStream(fileName),format);
            writer.write(doc);
            writer.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
