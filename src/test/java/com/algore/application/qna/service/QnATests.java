package com.algore.application.qna.service;

import com.algore.application.qna.dto.AnswerDTO;
import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QnATests {
    @Autowired
    public QuestionService questionService;


    @Test
    @DisplayName("QnA 게시물 조회 테스트")
    public void detaileReadQna(){
        //given
        int QNumber= 13;
        QuestionDTO questionDTO  = new QuestionDTO(13,"곰이 쌘가요? 사자가 쌘가요?","곰이 쌘가요? 사자가 쌘가요?");
        //when
        QuestionDTO questionDTOTest = questionService.detaileRead(QNumber);
        //then
        Assertions.assertAll("게시물 조회 테스트",()->Assertions.assertEquals(questionDTO.getqTitle(),questionDTOTest.getqTitle(),()->
                "타이틀이 다르다"),()->Assertions.assertEquals(questionDTO.getqContent(),questionDTOTest.getqContent(),()->"내용이 다르다"));
    }

    @Test
    @DisplayName("QnA 답변상태 테스트")
    public void qnaListStatus() {
        String status = "Y";
        List<QuestionDTO> questionDTOList = questionService.questionAll();
        System.out.println(questionDTOList);
        org.assertj.core.api.Assertions.assertThat(questionDTOList)
                .filteredOn(q->q.getStatus().equals("Y"));

    }

    @Test
    @DisplayName("QnA 미답변상태 테스트")
    void qnaListNstatus() {
        String status ="N";
        List<QuestionDTO> questionDTOList = questionService.questionAll();
        org.assertj.core.api.Assertions.assertThat(questionDTOList)
                .filteredOn("status",status)
                .contains(questionDTOList.get(2));
    }


    @Test
    @DisplayName("QnA 미답변 Null 테스트")
    void qnaAnswerNull() {
        AnswerDTO answerDTO = questionService.reedAnswer(11);

        org.assertj.core.api.Assertions.assertThatNullPointerException()
                .isThrownBy(
                        ()-> {System.out.println(answerDTO.getAcontent());}
                );

    }

    @Test
    @DisplayName("QnA 답변 상태일떄 Null이 아닌지 테스트")
    void qnaAnswerNotNull() {
        AnswerDTO answerDTO = questionService.reedAnswer(10);
        org.assertj.core.api.Assertions.assertThatCode(
                ()->{
                    System.out.println(answerDTO.getAcontent());
                }
        ).doesNotThrowAnyException();
    }
}
