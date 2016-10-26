package com.water.db.dao.impl;

import com.water.db.dao.IArticleDao;
import com.water.db.entry.Article;
import com.water.db.entry.ArticleModule;
import com.water.tools.constant.admin.ArticleModuleConstant;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by mrwater on 16/8/25.
 *
 */
@Repository(IArticleDao.SERVICE_NAME)
public class ArticleDaoImpl extends BaseDaoImpl implements IArticleDao {


    @Override
    public int saveArticle(Article article) {

        String INSERT_SQL = "INSERT INTO t_article (TITLE, SUMMARY, CONTENT, CREATEUSERID, ARTICLE_MODULE, THUMBNAIL, IS_THUMBNAIL, IS_TOP,  CREATEDON) " +
                "VALUES (?,?,?,?,?,?,?,?,?)";
        //创建时间
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Object[]params = new Object[]{
                article.getTitle(),
                article.getSummary(),
                article.getContent(),
                article.getAuthor(),
                article.getModule(),
                article.getThumbnail(),
                article.getIsThumbnail(),
                article.getIsTop(),
                timestamp
        };
        return this.insertData(INSERT_SQL,params);
    }

    @Override
    public List<Map<String, Object>> findArticleList() {

        String SELECT_SQL = "select article.*,empinfo.EMPLOYEE_NAME as author,module.MODULE_NAME from" +
                            " t_article as article,t_empinfo as empinfo,t_article_module as module" +
                            " where article.CREATEUSERID = empinfo.ID and article.ARTICLE_MODULE = module.AMID" +
                            " order by article.CREATEDON DESC";

        return this.queryForList(SELECT_SQL);
    }

    @Override
    public int addArticleModule(String module_name, String module_code, int module_partent, int sortorder, String remark) {

        String INSERT_SQL = "INSERT INTO t_article_module (MODULE_CODE, MODULE_NAME, PARTENT_MODULE, SORTORDER, REMARK)" +
                            " VALUES (?,?,?,?,?)";
        Object[]params = new Object[]{module_code,module_name,module_partent,sortorder,remark};

        return this.insertData(INSERT_SQL, params);
    }

    @Override
    public int updateArticleModule(ArticleModule articleModule) {

        String UPDATE_SQL = "UPDATE t_article_module SET MODULE_CODE = ?, MODULE_NAME = ?, PARTENT_MODULE = ?, SORTORDER = ?, REMARK = ?  WHERE AMID = ? ";


        return this.insertData(UPDATE_SQL,new Object[]{
                articleModule.getModule_code(),
                articleModule.getModule_name(),
                articleModule.getModule_partent(),
                articleModule.getSortorder(),
                articleModule.getRemark(),
                articleModule.getAm_Id()
        });
    }

    @Override
    public List<Map<String, Object>> getAllArticleModule() {

        String SELECT_SQL = "SELECT * FROM t_article_module ";
        return this.queryForList(SELECT_SQL);
    }

    @Override
    public int deleteModuleById(int moduleId) {

        String DELETE_SQL = "DELETE FROM t_article_module WHERE AMID = ?";
        return this.deleteData(DELETE_SQL,new Object[]{moduleId});
    }

    @Override
    public int deleteArticleById(int articleId) {

        String DELETE_SQL = "DELETE FROM t_article WHERE ARID = ?";
        return this.deleteData(DELETE_SQL,articleId);
    }

    @Override
    public List<Map<String, Object>> findIndustryInfo(int row) {

        String SELECT_SQL = "SELECT article.* FROM t_article as article ,t_article_module as module \n" +
                "WHERE module.MODULE_CODE = '" + ArticleModuleConstant.INDUSTRY_INFORMATION+"' AND article.ARTICLE_MODULE = module.AMID  ORDER BY article.CREATEDON DESC LIMIT ?";

        return this.queryForList(SELECT_SQL,row);
    }

    @Override
    public List<Map<String, Object>> findcompanyInfos(int row) {
        String SELECT_SQL = "SELECT article.* FROM t_article as article ,t_article_module as module \n" +
                "WHERE module.MODULE_CODE = '" + ArticleModuleConstant.COMPANY_ANNOUNCEMENT+"' AND article.ARTICLE_MODULE = module.AMID  ORDER BY article.CREATEDON DESC LIMIT ?";

        return this.queryForList(SELECT_SQL,row);
    }

    @Override
    public int updateArticleById(int articleId, Article newArticle) {

        String UPDATE_SQL = "UPDATE t_article SET TITLE = ?,SUMMARY = ?,CONTENT=?,ARTICLE_MODULE=? WHERE ARID = ?";
        Object[]params = new Object[]{
                newArticle.getTitle(),
                newArticle.getSummary(),
                newArticle.getContent(),
                newArticle.getModule(),
                newArticle.getArticleId()
        };

        return this.updateData(UPDATE_SQL,params);
    }

    @Override
    public List<Map<String, Object>> queryArticleByCondition(String articleTitle, int articleModule) {

        String SELECT_SQL = "SELECT article.*,empinfo.EMPLOYEE_NAME as author, module.MODULE_NAME " +
                            " FROM t_article article,t_empinfo empinfo,t_article_module module" +
                            " WHERE article.ARTICLE_MODULE = ? " +
                            " and article.TITLE LIKE '%"+articleTitle+"%'" +
                            " and article.CREATEUSERID = empinfo.ID " +
                            " and article.ARTICLE_MODULE = module.AMID" +
                            " order by article.CREATEDON DESC";

        return this.queryForList(SELECT_SQL,articleModule);
    }
}
