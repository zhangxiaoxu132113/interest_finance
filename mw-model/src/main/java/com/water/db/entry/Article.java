package com.water.db.entry;

/**
 * Created by mrwater on 16/8/25.
 * 文章实体类
 */
public class Article implements java.io.Serializable {

    /**
     * 主键ID
     */
    private int articleId;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private int author;

    /**
     * 文章概要
     */
    private String summary;

    /**
     * 文章所属模块
     */
    private int module;

    /**
     * 文章内容
     */
    private String content;

    /**
     * 文章的关键字
     */
    private String keyword;

    /**
     * 文章是否置顶
     */
    private int isTop;

    /**
     * 文章是否设置封面图
     */
    private int isThumbnail;

    /**
     * 文章的缩略图
     */
    private String thumbnail;

    public int getArticleId() {

        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getIsThumbnail() {
        return isThumbnail;
    }

    public void setIsThumbnail(int isThumbnail) {
        this.isThumbnail = isThumbnail;
    }
}
