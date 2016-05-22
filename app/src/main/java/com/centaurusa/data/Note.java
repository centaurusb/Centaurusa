package com.centaurusa.data;

import java.util.Date;
import java.util.UUID;

import java.text.SimpleDateFormat;
/**
 * Created by Swin on 2016/5/22.
 */
public class Note {
    private UUID mNoteId;
    private String mTitle;
    private String mDetial;
    private Date mDate;
    private boolean mComplete;

    public Note(String noteId ,String title, String detial,Long date,boolean complete) {
        mNoteId = UUID.fromString(noteId);
        mTitle = title;
        mDetial = detial;
        mDate = new Date(date);
        mComplete = complete;
    }

    public UUID getNoteId() {
        return mNoteId;
    }

    public void setNoteId(UUID noteId) {
        mNoteId = noteId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDetial() {
        return mDetial;
    }

    public void setDetial(String detial) {
        mDetial = detial;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public boolean isComplete() {
        return mComplete;
    }

    public void setComplete(boolean complete) {
        mComplete = complete;
    }
}
