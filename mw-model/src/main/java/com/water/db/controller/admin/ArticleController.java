package com.water.db.controller.admin;

import com.water.db.entry.Article;
import com.water.db.entry.ArticleModule;
import com.water.db.service.IArticleService;
import com.water.tools.lang.MWStringUtils;
import com.water.tools.web.MWSessionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by mrwater on 16/8/25.
 */
@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    /**图片命名格式*/
    private static final String DEFAULT_SUB_FOLDER_FORMAT_AUTO = "yyyyMMddHHmmss";

    /** 放置上传图片的文件夹*/
    private static final String UPLOAD_PATH="/upload/img/";

    @Resource(name = IArticleService.SERVICE_NAME)
    private IArticleService articleService;

    /**
     * @author      Zhang Miaojie
     * @description 添加文章
     * @time        2016-08-25
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addArticle(@RequestBody Article article, HttpServletRequest request, HttpServletResponse response) throws Exception {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        System.out.println("article = "+article);
//        Map<String,Object> userMap = MWSessionUtils.getUserBySession(request);
//        article.setAuthor((Integer) userMap.get("USERID"));
        Map<String,Object> empInfo = MWSessionUtils.getEmpInfoBySession(request);
        if (empInfo == null) {
            response.sendRedirect("/admin/login.action");
            return null;
        }

        article.setAuthor((Integer) empInfo.get("ID"));
        boolean flag = articleService.saveArticle(article);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description ckeditor编辑器中上传图片得功能
     * @Time        2016-08-25
     * @return
     */
    @RequestMapping("/uploadImg")
    public void uplodaImg(@RequestParam("upload")MultipartFile file,
                          HttpServletRequest request, HttpServletResponse response,
                          @RequestParam("CKEditorFuncNum")String CKEditorFuncNum)
            throws IllegalStateException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
        String fileName=file.getOriginalFilename();
        String uploadContentType =file.getContentType();
        String expandedName ="";
        if (uploadContentType.equals("imagepeg")
                || uploadContentType.equals("image/jpeg")) {
            // IE6上传jpg图片的headimageContentType是imagepeg，而IE9以及火狐上传的jpg图片是image/jpeg
            expandedName = ".jpg";
        } else if (uploadContentType.equals("image/png")
                || uploadContentType.equals("image/x-png")) {
            // IE6上传的png图片的headimageContentType是"image/x-png"
            expandedName = ".png";
        } else if (uploadContentType.equals("image/gif")) {
            expandedName = ".gif";
        } else if (uploadContentType.equals("image/bmp")) {
            expandedName = ".bmp";
        } else {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
            out.println("</script>");
            return ;
        }
        // 上传的文件大小不能大于50M
        if (file.getSize()> 50 * 1024 * 1024) {
            out.println("<script type=\"text/javascript\">");
            out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                    + ",''," + "'文件大小不得大于50M');");
            out.println("</script>");
            return ;
        }
        DateFormat df = new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO);
        fileName = df.format(new Date())+expandedName;

        /** 构建上传图片的保存目录* */
        String saveDir = UPLOAD_PATH+ fileName;
        /** 得到文件保存目录的真实路径* */
        String imgRealPathDir = request.getSession().getServletContext().getRealPath(saveDir);


        String test1 = request.getSession().getServletContext().getRealPath("/");//获取web项目的路径

        System.out.println(test1);
        System.out.println("imgRealPathDir"+imgRealPathDir);

        File f2 = new File(this.getClass().getResource("").getPath());
        System.out.println(f2);

        File targetFile = new File(imgRealPathDir);

        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }


        file.transferTo(targetFile);
        // 返回"图像"选项卡并显示图片  request.getContextPath()为web项目名,只适合jsp页面使用
        out.println("<script type=\"text/javascript\">");
        out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum
                + ",'" + request.getContextPath()+"/upload/img/" + fileName + "','')");
        out.println("</script>");


        return ;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据条件,查询文章列表
     * @Time        2016-08-25
     * @return      List<Map<String,Object>>
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> findArticleList() {

        List<Map<String,Object>> resultJson = new ArrayList<Map<String,Object>>();
        //TODO 根据条件,查询文章列表
        resultJson = articleService.findArticleList();
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据文章的ID删除文章
     * @Time        2016-08-26
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> removeArticleById(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        boolean flag = articleService.deleteArticleById(articleId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 更新文章
     * @time        2016-09-27
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/update", method= RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updateArticleById(@RequestBody Article newArticle) {

        Map<String,Object> resultJson = new HashMap<String,Object>();

        System.out.println("article" + newArticle);
        boolean flag = articleService.updateArticleById(newArticle.getArticleId(),newArticle);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }

        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 添加文章分类
     * @Time        2016-08-25
     * @return      Boolean
     */
    @RequestMapping(value = "/addModule", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> addModule(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();

        String module_name = MWStringUtils.getParameterByRequest(request,"module_name");
        int module_partent = Integer.parseInt(MWStringUtils.getParameterByRequest(request,"module_partent"));
        String module_code = MWStringUtils.getParameterByRequest(request,"module_code");
        int sortorder      = Integer.parseInt(MWStringUtils.getParameterByRequest(request,"sortorder"));
        String remark      = MWStringUtils.getParameterByRequest(request,"remark");

        boolean flag = articleService.addArticleModule(module_name,module_code,module_partent,sortorder,remark);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      MengSheng
     * @description 编辑文章分类
     * @Time        2016-08-25
     * @return      Boolean
     */
    @RequestMapping(value = "/updateModule", method = RequestMethod.POST, produces = "application/json")
    public Map<String,Object> updateModule(@RequestBody ArticleModule articleModule) {

        Map<String,Object> resultJson = new HashMap<String,Object>();

        System.out.println("in add updateModule method !");
        System.out.println("articleModule_id:"+articleModule.getAm_Id());
        boolean flag = articleService.updateArticleModule(articleModule);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 获取文章分类
     * @Time        2016-08-25
     * @return      Boolean
     */
    @RequestMapping(value = "/getAllArticleModule", method = RequestMethod.GET, produces = "application/json")
    public List<Map<String,Object>> getAllArticleModule() {

        List<Map<String,Object>> results = new ArrayList<Map<String,Object>>();
        results = articleService.getAllArticleModule();
        return results;
    }

    /**
     * @author      Zhang Miaojie
     * @description 删除文章分类
     * @Time        2016-08-26
     * @return      Boolean
     */
    @RequestMapping(value = "/deleteModule", method = RequestMethod.DELETE, produces = "application/json")
    public Map<String,Object> deleteModule(HttpServletRequest request) {

        Map<String,Object> resultJson = new HashMap<String,Object>();
        int moduleId = Integer.parseInt(request.getParameter("moduleId"));
        boolean flag = articleService.deleteModuleById(moduleId);
        if (flag) {
            resultJson.put("status",0);
            return resultJson;
        }
        resultJson.put("status",1);
        return resultJson;
    }

    /**
     * @author      Zhang Miaojie
     * @description 根据条件查询文章内容
     * @time        2016-09-27
     * @return      Map<String,Object>
     */
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = "application/json")
    public List<Map<String,Object>> queryArticleByCondition(HttpServletRequest request) {

        List<Map<String,Object>> articleList = new ArrayList<Map<String,Object>>();

        int articleModule = Integer.parseInt(request.getParameter("articleModule"));
        String articleTitle = MWStringUtils.getParameterByRequest(request,"articleTitle");

        articleList = articleService.queryArticlesByCondition(articleTitle,articleModule);
        return articleList;
    }
}
