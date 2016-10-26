package com.water.db.service;

import com.water.db.entry.Article;
import com.water.db.entry.ArticleModule;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/25.
 */
public interface IArticleService {

    String SERVICE_NAME = "com.water.db.service.impl.ArticleServiceImpl";

    /**
     * @author      Zhang Miaojie
     * @description 保存文章
     * @time        2016-08-25
     */
    boolean saveArticle(Article article);

    /**
     * @author      Zhang Miaojie
     * @description 查询文章列表
     * @time        2016-08-25
     */
    List<Map<String,Object>> findArticleList();

    /**
     * @author      Zhang Miaojie
     * @description 添加文章分类
     * @time        2016-08-25
     */
    boolean addArticleModule(String module_name,String module_code,int module_partent,int sortorder,String remark);

    /**
     * @author      MengSheng
     * @description 编辑文章分类
     * @time        2016-08-25
     */
    boolean updateArticleModule(ArticleModule articleModule);

    /**
     * @author      Zhang Miaojie
     * @description 查询文章分类列表
     * @time        2016-08-25
     */
    List<Map<String,Object>> getAllArticleModule();

    /**
     * @author      Zhang Miaojie
     * @description 删除文章分类
     * @time        2016-08-26
     */
    boolean deleteModuleById(int moduleId);

    /**
     * @author      Zhang Miaojie
     * @description 根据ID删除文章
     * @time        2016-08-26
     */
    boolean deleteArticleById(int articleId);

    /**
     * @author      Zhang Miaojie
     * @description 查询行业资讯文章内容
     * @time        2016-09-26
     */
    List<Map<String,Object>> findIndustryInfo(int row);

    /**
     * @author      Zhang Miaojie
     * @description 查询公司公告文章内容
     * @time        2016-09-26
     */
    List<Map<String,Object>> findcompanyInfos(int row);

    /**
     * @author      Zhang Miaojie
     * @description 根据ID更新文章内容
     * @time        2016-09-26
     */
    boolean updateArticleById(int articleId, Article newArticle);

    List<Map<String,Object>> queryArticlesByCondition(String articleTitle, int articleModule);
}
