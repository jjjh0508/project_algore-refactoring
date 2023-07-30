package com.algore.application.qna.dto;


import java.sql.Date;

public class QuestionInsertDTO {

    private String queTitle;
    private String queContent;

    private int mumNum;


    public QuestionInsertDTO() {
    }

    public QuestionInsertDTO(String queTitle, String queContent, int mumNum) {
        this.queTitle = queTitle;
        this.queContent = queContent;
        this.mumNum = mumNum;
    }

    public String getQueTitle() {
        return queTitle;
    }

    public void setQueTitle(String queTitle) {
        this.queTitle = queTitle;
    }

    public String getQueContent() {
        return queContent;
    }

    public void setQueContent(String queContent) {
        this.queContent = queContent;
    }

    public int getMumNum() {
        return mumNum;
    }

    public void setMumNum(int mumNum) {
        this.mumNum = mumNum;
    }

    @Override
    public String toString() {
        return "QuestionInsertDTO{" +
                "queTitle='" + queTitle + '\'' +
                ", queContent='" + queContent + '\'' +
                ", mumNum=" + mumNum +
                '}';
    }
}
