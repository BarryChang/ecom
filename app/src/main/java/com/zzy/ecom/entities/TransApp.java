package com.zzy.ecom.entities;

import android.app.Application;

/**
 * Created by ZhangZhiyi on 3/14/16.
 */
public class TransApp extends Application {

    private User user;
    private Community community;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User();
        community = new Community();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }
}
