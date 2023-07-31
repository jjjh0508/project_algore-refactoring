package com.algore.application.notice.dto;

import java.sql.Date;

public class NoticeDetailDTO {


    private String nTitle;
    private String detail;

    public NoticeDetailDTO() {
    }

    public NoticeDetailDTO(String nTitle, String detail) {
        this.nTitle = nTitle;
        this.detail = detail;
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

    @Override
    public String toString() {
        return "NoticeDetailDTO{" +
                "nTitle='" + nTitle + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
