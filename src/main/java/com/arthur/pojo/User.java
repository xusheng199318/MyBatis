package com.arthur.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by xusheng on 2018/9/4.
 */
public class User implements Serializable{

    private int id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;

    public User id(int id) {
        this.id = id;
        return this;
    }

    public User username(String username) {
        this.username = username;
        return this;
    }

    public User birthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public User sex(String sex) {
        this.sex = sex;
        return this;
    }

    public User address(String address) {
        this.address = address;
        return this;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
