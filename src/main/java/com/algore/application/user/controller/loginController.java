package com.algore.application.user.controller;

import com.algore.application.user.service.JoinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class loginController {

    private final JoinService service;

    public loginController(JoinService service) {
        this.service = service;
    }

    @GetMapping("/findId")
    public String findId(@RequestParam("username") String userName){
        System.out.println("넘어가니");
        String findName = service.findName(userName);
//        System.out.println(findName);
        if(findName==null){
            return "사용할 수 있는 아이디 입니다.";
        }else {
            return "사용할 수 없는 아이디 입니다.";
        }

    }
}
