package com.zzy.ecom.entities;

import com.zzy.ecom.R;

/**
 * Created by ZhangZhiyi on 3/13/16.
 */
public class User {
    private int userID;
    private String loginName;
    private String password;

    private String nickName;
    private int level;
    private int userStatus;
    private int headPicture;

    public User()
    {
        setUserID(11111);
        setLoginName("default");
        setPassword("default");
        setNickName("我们是大能");
        setLevel(4);
        setUserStatus(1);
        setHeadPicture(R.drawable.example_head);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(int headPicture) {
        this.headPicture = headPicture;
    }
}
