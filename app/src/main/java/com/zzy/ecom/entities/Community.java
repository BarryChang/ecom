package com.zzy.ecom.entities;

import com.zzy.ecom.R;

import java.util.ArrayList;

/**
 * Created by ZhangZhiyi on 3/13/16.
 */
public class Community {
    private int communityID;
    private String communityName;
    private int bkgPicture;
    private String location;
    private String intro;
    private int notesAmount;
    private int memberAmount;

    public Community()
    {
        setCommunityID(1001);
        setCommunityName("二主楼社区");
        setBkgPicture(R.drawable.example_bkg);
        setLocation("本社区是南开大学二主楼附近区域,包括南开三食堂,大中路,12宿等.");
        setIntro("欢迎南开大学在二主楼上课的同学们加入我们社区进行讨论和交流!!!");
        setMemberAmount(39);
        setNotesAmount(145);
    }

    public ArrayList<Note>
    getNotesList()
    {
        return null;
    }

    public ArrayList<User>
    getMemberList()
    {
        return null;
    }

    public int getCommunityID() {
        return communityID;
    }

    public void setCommunityID(int communityID) {
        this.communityID = communityID;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    public int getBkgPicture() {
        return bkgPicture;
    }

    public void setBkgPicture(int bkgPicture) {
        this.bkgPicture = bkgPicture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public int getMemberAmount() {
        return memberAmount;
    }

    public void setMemberAmount(int memberAmount) {
        this.memberAmount = memberAmount;
    }

    public int getNotesAmount() {
        return notesAmount;
    }

    public void setNotesAmount(int notesAmount) {
        this.notesAmount = notesAmount;
    }
}
