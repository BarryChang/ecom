package com.zzy.ecom.entities;

import java.util.ArrayList;

/**
 * Created by ZhangZhiyi on 3/13/16.
 */
public class Activity {
    private int activtiyID;
    private int holderUserID;
    private String title;
    private String textContent;
    private long deadline;
    private int[] participaters;

    public int getActivtiyID() {
        return activtiyID;
    }

    public void setActivtiyID(int activtiyID) {
        this.activtiyID = activtiyID;
    }

    public int getHolderUserID() {
        return holderUserID;
    }

    public void setHolderUserID(int holderUserID) {
        this.holderUserID = holderUserID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public int[] getParticipaters() {
        return participaters;
    }

    public void setParticipaters(int[] participaters) {
        this.participaters = participaters;
    }
}
