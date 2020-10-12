package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.service.CommentService;
import com.capstone9.coin_singer.web.dto.BoardReadResponseDto;
import com.capstone9.coin_singer.web.dto.CommentListResponseDto;
import com.capstone9.coin_singer.web.dto.PageMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;
    private final CommentService commentService;

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/board")
    public String footprint(@RequestParam(required = false) String page,
                            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 5) Pageable pageable ,
                            Model model){

        model.addAttribute("board",boardService.findAll(pageable));//게시글 정보 가지고 옴

        ///////////////////////////////////////페이지 계산//////////////////////////////////////////
        PageMaker pageMaker;
        if(page!=null) {
            pageMaker = new PageMaker(Integer.parseInt(page));
        }
        else{
            pageMaker = new PageMaker(0);
        }

        if((pageMaker.getCurrentPage()-1)/5 == 0){
            model.addAttribute("goPreviousPage", 0);
        }
        else {
            model.addAttribute("goPreviousPage", ((pageMaker.getCurrentPage()-1) / 5 - 1) * 5);
        }
        model.addAttribute("goNextPage",((pageMaker.getCurrentPage()-1)/5+1)*5);
        model.addAttribute("currentPageA",pageMaker.getCurrentPage()-1);
        model.addAttribute("currentPage",pageMaker.getCurrentPage());
        model.addAttribute("previousPageList",pageMaker.getPreviousPageList());
        model.addAttribute("nextPageList",pageMaker.getNextPageList());
        ///////////////////////////////////////페이지 계산//////////////////////////////////////////

        return "board";
    }

    @GetMapping("/boardWrite")
    public String boardWrite(){

        return "boardWrite";
    }

    @GetMapping("/boardRead/{id}")
    public String boardRead(@PathVariable Long id, Model model){
        BoardReadResponseDto dto = boardService.findById(id);
        List<CommentListResponseDto> commentList = commentService.findAll(id);

//        CommentListResponseDto commentListResponseDto =
        model.addAttribute("board",dto);
        model.addAttribute("comment",commentList);

        return "boardRead";
    }

    @GetMapping("/boardUpdate/{id}")
    public String boardUpdate(@PathVariable Long id, Model model){
        BoardReadResponseDto dto = boardService.findById(id);
        model.addAttribute("board",dto);

        return "boardUpdate";
    }
}
