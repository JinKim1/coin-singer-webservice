package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("board",boardService.findAll());
        return "index";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }
}
