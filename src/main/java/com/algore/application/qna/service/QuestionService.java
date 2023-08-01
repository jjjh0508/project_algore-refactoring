package com.algore.application.qna.service;

import com.algore.application.qna.dao.QuestionMapper;
import com.algore.application.qna.dto.AnswerDTO;
import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.dto.QuestionInsertDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionMapper questionMapper;
    private final QuestionMapper detailMapper;

    //메인화면 서비스
    public QuestionService(QuestionMapper questionMapper, QuestionMapper detailMapper) {
        this.questionMapper = questionMapper;
        this.detailMapper = detailMapper;
    }
    //전체글 main
    public List<QuestionDTO> questionAll(){
        List<QuestionDTO> allQuestion = questionMapper.questionAll();

        return allQuestion;
    }

    public QuestionDTO detaileRead(int qNumber) {
        QuestionDTO list = detailMapper.detaileRead(qNumber);


        return list;
    }


    public int regist(QuestionInsertDTO questionInsertDTO) {
        //qna 등록
        int result = 0;
        int resultqNA = detailMapper.registQna(questionInsertDTO);
        //질문등록
        if(resultqNA>0){
            result = detailMapper.registQue(questionInsertDTO);
            detailMapper.registQueAnw();
        }


        return result;
    }

    public int answerInset(AnswerDTO answerDTO) {
        int result = detailMapper.answerInset(answerDTO);
        return result;
    }

    public AnswerDTO reedAnswer(int qNumber) {
        AnswerDTO answerDTO = detailMapper.reedAnswer(qNumber);
        System.out.println(answerDTO);
        return answerDTO;
    }
}