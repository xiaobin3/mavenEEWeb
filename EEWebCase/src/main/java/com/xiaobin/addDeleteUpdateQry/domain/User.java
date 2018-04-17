package com.xiaobin.addDeleteUpdateQry.domain;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 14:35 2018/4/17
 * @Modified by:
 */
public class User {

   /* CREATE TABLE user
            (
                    uid       VARCHAR(50) NOT NULL
    PRIMARY KEY,
    username  VARCHAR(20) NULL,
    password  VARCHAR(20) NULL,
    name      VARCHAR(20) NULL,
    email     VARCHAR(30) NULL,
    telephone VARCHAR(20) NULL,
    birthday  VARCHAR(20) NULL,
    sex       VARCHAR(10) NULL,
    state     INT         NULL,
    code      VARCHAR(64) NULL
);*/
   private String uid;
   private String userName;
   private String passWord;
   private String name;
   private String email;
   private String telephone;
   private String birthday;
   private String sex;
   private Integer state;
   private String code;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
