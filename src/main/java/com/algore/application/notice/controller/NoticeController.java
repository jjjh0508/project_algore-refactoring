package com.algore.application.notice.controller;

import com.algore.application.auth.AuthUserDTO;
import com.algore.application.notice.dto.NoticeDTO;
import com.algore.application.notice.dto.NoticeDetailDTO;
import com.algore.application.notice.service.NoticeService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView write(Authentication authentication, ModelAndView modelAndView) {
        AuthUserDTO authUserDTO = (AuthUserDTO) authentication.getPrincipal();
        if (authUserDTO.getRole().equals("ADMIN")) {
            modelAndView.setViewName("/notice/write");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/notice/main");
        return modelAndView;
    }

    @PostMapping("/write")
    public ModelAndView writeNotice(ModelAndView modelAndView, NoticeDetailDTO noticeDetailDTO, RedirectAttributes redirectAttributes) {
        int result = noticeService.writeNotice(noticeDetailDTO);
        if (result > 0) {
            System.out.println("성공");
            redirectAttributes.addFlashAttribute("message", "등록 성공했습니다");
            modelAndView.setViewName("redirect:/notice/main");

        } else {
            System.out.println("실패");
            redirectAttributes.addFlashAttribute("message", "등록에 실패했습니다");
            modelAndView.setViewName("redirect:/notice/main");
        }
        return modelAndView;

    }


    @GetMapping("/read")
    public ModelAndView read(ModelAndView modelAndView, @RequestParam("notice") int notiNum) {
        NoticeDetailDTO noticeDetailDTO = noticeService.detailRead(notiNum);
        noticeDetailDTO.setNotiNum(notiNum);
        modelAndView.addObject("detail", noticeDetailDTO);
        modelAndView.setViewName("notice/read");
        return modelAndView;
    }

    @GetMapping("/modify")
    public ModelAndView noticeModify(ModelAndView modelAndView, @RequestParam("notice") int notiNum,Authentication authentication) {
        AuthUserDTO authUserDTO = (AuthUserDTO) authentication.getPrincipal();
        if (authUserDTO.getRole().equals("ADMIN")) {
            NoticeDetailDTO noticeDetailDTO = noticeService.detailRead(notiNum);
            noticeDetailDTO.setNotiNum(notiNum);
            modelAndView.addObject("noticeDetailDTO",noticeDetailDTO);
            modelAndView.setViewName("notice/modify");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/notice/main");
        return modelAndView;
    }


    @PostMapping("/modify")
    public ModelAndView noticeModifyForm(ModelAndView modelAndView, NoticeDetailDTO noticeDetailDTO, RedirectAttributes redirectAttributes) {
        System.out.println(noticeDetailDTO);
        int result = noticeService.modifyNotice(noticeDetailDTO);
        if (result > 0) {
            redirectAttributes.addFlashAttribute("message","수정 성공했습니다");
            modelAndView.setViewName("redirect:/notice/main");
        }else {
            redirectAttributes.addFlashAttribute("message","수정 성공했습니다");
            modelAndView.setViewName("redirect:/notice/main");
        }
        return  modelAndView;
    }


    @GetMapping("/delete")
    public ModelAndView noticeDelete(ModelAndView modelAndView, @RequestParam("notice") int notiNum,Authentication authentication,RedirectAttributes redirectAttributes) {
        AuthUserDTO authUserDTO = (AuthUserDTO) authentication.getPrincipal();
        if (authUserDTO.getRole().equals("ADMIN")) {
            int result = noticeService.deleteNotice(notiNum);

            if(result>0){
                redirectAttributes.addFlashAttribute("message","삭제 성공했습니다");
                modelAndView.setViewName("redirect:/notice/main");
            }else {
                redirectAttributes.addFlashAttribute("message","수정 성공했습니다");
                modelAndView.setViewName("redirect:/notice/main");
            }

        }
        modelAndView.setViewName("redirect:/notice/main");
        return modelAndView;
    }

}
