package com.water.db.entry;

import java.sql.Date;

/**
 * Created by Administrator on 2016/9/8.
 * 员工信息实体类
 */
public class EmpInfo implements java.io.Serializable {

    private int id;

    /**
     * 员工ID
     */
    private int employeeId;

    /**
     * 登录账号
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 所属部门ID
     */
    private int departmentId;

    /**
     * 性别
     */
    private int gender;

    /**
     * 出生日期
     */
    private Date brithday;

    /**
     * 政治状态
     */
    private int politicsStatus;

    /**
     * 婚姻状态
     */
    private int marriage;

    /**
     * 地址
     */
    private String address;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 职位
     */
    private int job;

    /**
     * 创建时间
     */
    private Date createon;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public int getPoliticsStatus() {
        return politicsStatus;
    }

    public void setPoliticsStatus(int politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    public int getMarriage() {
        return marriage;
    }

    public void setMarriage(int marriage) {
        this.marriage = marriage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getJob() {
        return job;
    }

    public void setJob(int job) {
        this.job = job;
    }

    public Date getCreateon() {
        return createon;
    }

    public void setCreateon(Date createon) {
        this.createon = createon;
    }
}
