package com.water.db.entry;

/**
 * Created by Administrator on 2016/10/17.
 * 第三方平台的接口api信息
 */
public class PlatformAPI implements java.io.Serializable {

    private int id;

    /**
     * 平台ID主键
     */
    private int platformId;

    /**
     * 接口地址
     */
    private String url;

    /**
     * 接口参数
     */
    private String params;

    /**
     * 邀请码
     */
    private String appKey;

    /**
     * 接口的类型，其值对应到数据字典的值
     */
    private int apiFlag;

    /**
     * 接口功能的描述
     */
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public int getApiFlag() {
        return apiFlag;
    }

    public void setApiFlag(int apiFlag) {
        this.apiFlag = apiFlag;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
