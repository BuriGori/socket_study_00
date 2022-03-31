package com.example.socket_study_00.contraller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class ChatController {
    @RequestMapping("/chat")
    public ModelAndView chatGet(){
        ModelAndView mv = new ModelAndView();
        log.info("@ChatController , chat Get()");
        mv.setViewName(" chat");
        return mv;
    }
}
