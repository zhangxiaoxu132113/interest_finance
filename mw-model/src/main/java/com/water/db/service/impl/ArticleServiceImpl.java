package com.water.db.service.impl;

import com.water.db.dao.IArticleDao;
import com.water.db.entry.Article;
import com.water.db.entry.ArticleModule;
import com.water.db.service.IArticleService;
import com.water.tools.lang.MWStringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/25.
 */
@Service(IArticleService.SERVICE_NAME)
public class ArticleServiceImpl implements IArticleService {

    @Resource(name = IArticleDao.SERVICE_NAME)
    private IArticleDao articleDao;

    @Override
    public boolean saveArticle(Article article) {

        if (article == null) throw new RuntimeException("对象不能为空！");
        int effectRows = articleDao.saveArticle(article);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findArticleList() {
        return articleDao.findArticleList();
    }

    @Override
    public boolean addArticleModule(String module_name, String module_code, int module_partent, int sortorder, String remark) {

        MWStringUtils.isBlank(module_name,module_code,module_partent,sortorder,remark);
        int effectRow = articleDao.addArticleModule(module_name,module_code,module_partent,sortorder,remark);
        if (effectRow != 0) return true;
        return false;
    }

    @Override
    public boolean updateArticleModule(ArticleModule articleModule) {

        if (articleModule == null) {
            throw  new RuntimeException("对象不能为空!");
        }
        int effectRows = articleDao.updateArticleModule(articleModule);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> getAllArticleModule() {
        return articleDao.getAllArticleModule();
    }

    @Override
    public boolean deleteModuleById(int moduleId) {

        int effectRows = articleDao.deleteModuleById(moduleId);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public boolean deleteArticleById(int articleId) {

        int effectRows = articleDao.deleteArticleById(articleId);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> findIndustryInfo(int row) {

        return articleDao.findIndustryInfo(row);
    }

    @Override
    public List<Map<String, Object>> findcompanyInfos(int row) {

        return articleDao.findcompanyInfos(row);
    }

    @Override
    public boolean updateArticleById(int articleId, Article newArticle) {

        MWStringUtils.isBlank(articleId);
        if (newArticle == null) throw new RuntimeException("article对象不能为空！");

        int effectRows = articleDao.updateArticleById(articleId,newArticle);
        if (effectRows != 0) return true;
        return false;
    }

    @Override
    public List<Map<String, Object>> queryArticlesByCondition(String articleTitle, int articleModule) {

        return articleDao.queryArticleByCondition(articleTitle,articleModule);
    }
}
