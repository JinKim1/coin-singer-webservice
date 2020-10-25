package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.config.auth.LoginUser;
import com.capstone9.coin_singer.config.auth.dto.SessionUser;
import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.service.CommentService;
import com.capstone9.coin_singer.service.SRBoardService;
import com.capstone9.coin_singer.web.dto.BoardReadResponseDto;
import com.capstone9.coin_singer.web.dto.CommentListResponseDto;
import com.capstone9.coin_singer.web.dto.PageMaker;
import com.capstone9.coin_singer.web.dto.SRBoardReadResponseDto;
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
    private final SRBoardService srboardService;

    @GetMapping("/")
    public String index(Model model,@LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("memberName",user.getName());
        }
        return "index";
    }

    @GetMapping("/board")
    public String footprint(@RequestParam(required = false) String page,
                            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 5) Pageable pageable ,
                            Model model,@LoginUser SessionUser user){

        if(user != null){
            model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        }

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
    public String boardWrite(Model model,@LoginUser SessionUser user){
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "boardWrite";
    }

    @GetMapping("/boardRead/{id}")
    public String boardRead(@PathVariable Long id, Model model,@LoginUser SessionUser user){
        BoardReadResponseDto dto = boardService.findById(id);
        List<CommentListResponseDto> commentList = commentService.findAll(id);

//        CommentListResponseDto commentListResponseDto =
        model.addAttribute("board",dto);
        model.addAttribute("comment",commentList);
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "boardRead";
    }

    @GetMapping("/boardUpdate/{id}")
    public String boardUpdate(@PathVariable Long id, Model model,@LoginUser SessionUser user){
        BoardReadResponseDto dto = boardService.findById(id);
        model.addAttribute("board",dto);
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "boardUpdate";
    }

    @GetMapping("/srboard")
    public String srboard(Model model,@LoginUser SessionUser user){
        model.addAttribute("srboard",srboardService.findAll());//게시글 정보 가지고 옴
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "srboard";
    }

    @GetMapping("/srboardWrite")
    public String srboardWrite(Model model,@LoginUser SessionUser user){
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "srboardWrite";
    }

    @GetMapping("/srboardRead/{id}")
    public String srboardRead(@PathVariable Long id, Model model,@LoginUser SessionUser user){
        SRBoardReadResponseDto dto = srboardService.findById(id);
        model.addAttribute("srboard",dto);
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "srboardRead";
    }

    @GetMapping("/srboardUpdate/{id}")
    public String srboardUpdate(@PathVariable Long id, Model model,@LoginUser SessionUser user){
        SRBoardReadResponseDto dto = srboardService.findById(id);
        model.addAttribute("srboard",dto);
        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        return "srboardUpdate";
    }
}
