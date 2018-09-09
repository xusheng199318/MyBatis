package com.arthur.pojo;

import java.util.Date;

public class UserDTO {
    private Integer id;
    private String username;
    private Date birthday_;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBirthday_() {
        return birthday_;
    }

    public void setBirthday_(Date birthday_) {
        this.birthday_ = birthday_;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday_=" + birthday_ +
                '}';
    }
}