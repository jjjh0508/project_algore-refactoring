package com.algore.application.notice.controller;

import com.algore.application.notice.dto.NoticeDTO;
import com.algore.application.notice.service.NoticeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/main")
    public ModelAndView main(ModelAndView modelAndView) {
        List<NoticeDTO> noticeDTO = noticeService.noticeList();

        modelAndView.addObject("notice", noticeDTO);
        modelAndView.setViewName("/notice/main");
        return modelAndView;
    }

    @GetMapping("/write")
    public void write() {
    }

    @GetMapping("/read")
    public String read() {
        return "notice/read";
    }

}
