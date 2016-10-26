package com.water.db.entry;

/**
 * Created by Meng Sheng on 2016/10/19.
 * 文章分类实体类
 */
public class ArticleModule {

    /**
     *文章分类ID
     */
    private int am_Id;

    /**
     *文章模块名称
     */
    private String module_name;

    /**
     *文章的CODE
     */
    private String module_code;

    /**
     *父级模块
     */
    private int module_partent;

    /**
     *排序
     */
    private int sortorder;

    /**
     *备注
     */
    private String remark;

    public int getAm_Id() {
        return am_Id;
    }

    public void setAm_Id(int am_Id) { this.am_Id = am_Id; }

    public String getModule_name() {
        return module_name;
    }

    public void setModule_name(String module_name) {
        this.module_name = module_name;
    }

    public String getModule_code() {
        return module_code;
    }

    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    public int getModule_partent() {
        return module_partent;
    }

    public void setModule_partent(int module_partent) {
        this.module_partent = module_partent;
    }

    public int getSortorder() {
        return sortorder;
    }

    public void setSortorder(int sortorder) {
        this.sortorder = sortorder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
