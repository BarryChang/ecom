package com.zzy.ecom.entities;

/**
 * Created by ZhangZhiyi on 3/13/16.
 */
public class Note {
    private int noteID;
    private long pushTime;
    private String title;
    private int autherUserID;
    private String textContent;

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public long getPushTime() {
        return pushTime;
    }

    public void setPushTime(long pushTime) {
        this.pushTime = pushTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAutherUserID() {
        return autherUserID;
    }

    public void setAutherUserID(int autherUserID) {
        this.autherUserID = autherUserID;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }
}
