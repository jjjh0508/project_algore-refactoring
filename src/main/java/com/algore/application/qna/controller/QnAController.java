package com.algore.application.qna.controller;

import com.algore.application.auth.AuthUserDTO;
import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.dto.QuestionInsertDTO;
import com.algore.application.qna.service.QuestionService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qna")
public class QnAController {

    private final QuestionService main;
    private final QuestionService detail;

    public QnAController(QuestionService main, QuestionService detail) {
        this.main = main;
        this.detail = detail;
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView mv) {
        System.out.println("dd");
        List<QuestionDTO> lists = detail.questionAll();
        for (QuestionDTO questionDTO: lists) {
            System.out.println("메인입니다.: " + questionDTO);
        }
        mv.addObject("mainList" , lists);
        mv.setViewName("qna/main");

        return mv;
    }

    //qna글 조회
    @GetMapping( "read")
    public ModelAndView read(ModelAndView model, @RequestParam("qNumber") int qNumber) {

//    //QuestionDTO 객체가져와서 service 담기, qNumber값 받아오기
        QuestionDTO detailQna = detail.detaileRead(qNumber);
        System.out.println("dd");
        //detailQna.setqNumber(qNumber);

//        //받아온 값 확인
        System.out.println("read 입니다 " + detailQna);
//
//
//        //오브젝트 연결
        model.addObject("detail", detailQna);
        model.setViewName("qna/read");

        System.out.println("컨트롤 입력 : " + detailQna);
        return model;
    }




    //유저 질문
    @GetMapping("userwritequestion")
    public void userwritequestion() {
    }
    @PostMapping("userwritequestion")
    public ModelAndView userwritequestionFrom(ModelAndView modelAndView , QuestionInsertDTO questionInsertDTO, Authentication authentication) {
        AuthUserDTO user = (AuthUserDTO) authentication.getPrincipal();
        questionInsertDTO.setMumNum(user.getMemNum());
        System.out.println(questionInsertDTO);
        int result = detail.regist(questionInsertDTO);
        if(result>0){
            System.out.println("성공");
            modelAndView.setViewName("redirect:/qna/main");
        }else {
            System.out.println("실패");
            modelAndView.setViewName("Redirect:/qna/main");
        }
        return modelAndView;
    }

    //유저 상세글 수정
    @GetMapping("userupdatequestion")
    public void userupdatequestion() {
    }


    //글쓰기
    @GetMapping("/adminwriteanswer")
    public void adminwriteanswer() {
    }

}