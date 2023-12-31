package com.algore.application.qna.dao;

import com.algore.application.qna.dto.AnswerDTO;
import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.dto.QuestionInsertDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface QuestionMapper {

    List<QuestionDTO> questionAll();
    QuestionDTO detaileRead(int qNumber);

    int registQna(QuestionInsertDTO questionInsertDTO);

    int registQue(QuestionInsertDTO questionInsertDTO);

    void registQueAnw();

    int answerInset(AnswerDTO answerDTO);

    AnswerDTO reedAnswer(int qNumber);
}

