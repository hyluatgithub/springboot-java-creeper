package com.hylu.springboot.model.test;

/**
 * 测试用的用户对象
 *
 * @author lhy13
 * @date 2017/11/9
 */
public class UserModel {
    private Long id;
    private String userId;
    private String userName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
