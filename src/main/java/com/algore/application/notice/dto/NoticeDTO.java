package com.algore.application.notice.dto;

import java.sql.Date;

public class NoticeDTO {
    private int notiNum;
    private String nTitle;
    private Date nDate;

    public NoticeDTO() {
    }

    public NoticeDTO(int notiNum, String nTitle, Date nDate) {
        this.notiNum = notiNum;
        this.nTitle = nTitle;
        this.nDate = nDate;
    }

    public int getNotiNum() {
        return notiNum;
    }

    public void setNotiNum(int notiNum) {
        this.notiNum = notiNum;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public Date getnDate() {
        return nDate;
    }

    public void setnDate(Date nDate) {
        this.nDate = nDate;
    }

    @Override
    public String toString() {
        return "NoticeDTO{" +
                "notiNum=" + notiNum +
                ", nTitle='" + nTitle + '\'' +
                ", nDate=" + nDate +
                '}';
    }
}
