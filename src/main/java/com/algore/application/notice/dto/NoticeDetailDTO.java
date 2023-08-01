package com.algore.application.notice.dto;

import java.sql.Date;

public class NoticeDetailDTO {


    private String nTitle;
    private String detail;
    private  int notiNum;
    public NoticeDetailDTO() {
    }

    public NoticeDetailDTO(String nTitle, String detail, int notiNum) {
        this.nTitle = nTitle;
        this.detail = detail;
        this.notiNum = notiNum;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getNotiNum() {
        return notiNum;
    }

    public void setNotiNum(int notiNum) {
        this.notiNum = notiNum;
    }

    @Override
    public String toString() {
        return "NoticeDetailDTO{" +
                "nTitle='" + nTitle + '\'' +
                ", detail='" + detail + '\'' +
                ", notiNum=" + notiNum +
                '}';
    }
}
