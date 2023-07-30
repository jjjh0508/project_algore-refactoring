package com.algore.application.qna.dto;

public class AnswerDTO {
    private int qNumber;
    private String acontent;

    public AnswerDTO() {
    }

    public AnswerDTO(int qNumber, String acontent) {
        this.qNumber = qNumber;
        this.acontent = acontent;
    }

    public int getqNumber() {
        return qNumber;
    }

    public void setqNumber(int qNumber) {
        this.qNumber = qNumber;
    }

    public String getAcontent() {
        return acontent;
    }

    public void setAcontent(String acontent) {
        this.acontent = acontent;
    }

    @Override
    public String toString() {
        return "AnswerDTO{" +
                "qNumber=" + qNumber +
                ", acontent='" + acontent + '\'' +
                '}';
    }
}
