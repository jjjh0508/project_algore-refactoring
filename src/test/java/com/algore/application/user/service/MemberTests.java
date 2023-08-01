package com.algore.application.user.service;


import com.algore.application.auth.AuthUserDTO;
import com.algore.application.auth.AuthenticationService;
import com.algore.application.qna.dto.QuestionDTO;
import com.algore.application.qna.service.QuestionService;
import com.algore.application.recipe.service.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MemberTests {
    @Autowired
    public JoinService joinService;
    @Autowired
    public RecipeService recipeService;
    @Autowired
    public AuthenticationService authenticationService;

    @Test
    @DisplayName("회원 중복 체크")
    void findMem() {

        //given
        String name = "jjjh0508";

        //when
        String findName = joinService.findName(name);
        boolean result = name.equals(findName);

        //then
        Assertions.assertTrue(result);
    }


    @Test
    @DisplayName("회원 중복 체크")
    void findMemFalse() {

        //given
        String name = "jjjh0508";

        //when
        String findName = joinService.findName(name);
        boolean result = name.equals(findName);

        //then
        Assertions.assertFalse(result, () -> "같다");
    }


    @Test
    @DisplayName("게시판 작성자")
    void getUserName() {
        //given
        String name = "user@gmail.com";

        //when
        String userName = recipeService.getUserName(1);
        //then
        Assertions.assertEquals(name, userName, () -> "같지 않다");
    }


    @Test
    @DisplayName("로그인 테스트")
    public void login(){
        //given
        String id = "jjjh0508";
        String role="USER";
        //when
        AuthUserDTO authUserDTO = (AuthUserDTO)authenticationService.loadUserByUsername("jjjh0508");
        //then
        Assertions.assertAll("아이디랑 룰이 같은지 ",()->Assertions.assertEquals(id,authUserDTO.getUsername(),()->
                "아이디가 다르다"),()->Assertions.assertEquals(role,authUserDTO.getRole(),()->"룰이 다르다"));

    }





}
