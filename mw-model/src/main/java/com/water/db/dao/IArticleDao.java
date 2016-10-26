package com.water.db.dao;

import com.water.db.entry.Article;
import com.water.db.entry.ArticleModule;

import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/25.
 */
public interface IArticleDao extends IBaseDao {

    String SERVICE_NAME = "com.water.db.service.impl.ArticleDaoImpl";

    /**保存文章*/
    int saveArticle(Article article);

    /**查询文章列表*/
    List<Map<String,Object>> findArticleList();

    /**保存文章分类*/
    int addArticleModule(String module_name, String module_code,int module_partent,int sortorder,String remark);

    /**编辑文章分类*/
    int updateArticleModule(ArticleModule articleModule);

    /**查询文章分类列表*/
    List<Map<String,Object>> getAllArticleModule();

    /**删除文章分类*/
    int deleteModuleById(int moduleId);

    /**删除文章*/
    int deleteArticleById(int articleId);

    /**获取行业资讯的文章*/
    List<Map<String,Object>> findIndustryInfo(int row);

    /**获取公司公告的文章*/
    List<Map<String,Object>> findcompanyInfos(int row);

    /**根据ID更新文章*/
    int updateArticleById(int articleId,Article newArticle);

    /**根据条件查询文章*/
    List<Map<String,Object>> queryArticleByCondition(String articleTitle, int articleModule);
}
