package com.capstone9.coin_singer.web;

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
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String index(Model model){
        return "index";
    }

    @GetMapping("/board")
    public String footprint(@RequestParam(required = false) String page,
                            @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC, size = 5) Pageable pageable ,
                            Model model){

        //로그인정보
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        //게시글정보
        model.addAttribute("board",boardService.findAll(pageable));

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
    public String boardWrite(Model model){

        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "boardWrite";
    }

    @GetMapping("/boardRead/{id}")
    public String boardRead(@PathVariable Long id, Model model){
        BoardReadResponseDto dto = boardService.findById(id);
        List<CommentListResponseDto> commentList = commentService.findAll(id);

//        CommentListResponseDto commentListResponseDto =
        model.addAttribute("board",dto);
        model.addAttribute("comment",commentList);
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "boardRead";
    }

    @GetMapping("/boardUpdate/{id}")
    public String boardUpdate(@PathVariable Long id, Model model){
        BoardReadResponseDto dto = boardService.findById(id);
        model.addAttribute("board",dto);
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "boardUpdate";
    }

//    @GetMapping("/srboard")
//    public String srboard(Model model,@LoginUser SessionUser user){
//        model.addAttribute("srboard",srboardService.findAll());//게시글 정보 가지고 옴
//        if(user != null) {
//            model.addAttribute("memberName", user.getName());//로그인한 사용자 정보 가지고 옴
//        }
//        return "srboard";
//    }
    @GetMapping("/srboard")
    public String srboard(Model model){
        model.addAttribute("srboard",srboardService.findAll());//게시글 정보 가지고 옴
        model.addAttribute("memberName", SecurityContextHolder.getContext().getAuthentication().getName());//로그인한 사용자 정보 가지고 옴

        return "srboard";
    }


    @GetMapping("/srboardWrite")
    public String srboardWrite(Model model){
//        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "srboardWrite";
    }

    @GetMapping("/srboardRead/{id}")
    public String srboardRead(@PathVariable Long id, Model model){
        SRBoardReadResponseDto dto = srboardService.findById(id);
        model.addAttribute("srboard",dto);
//        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "srboardRead";
    }

    @GetMapping("/srboardUpdate/{id}")
    public String srboardUpdate(@PathVariable Long id, Model model){
        SRBoardReadResponseDto dto = srboardService.findById(id);
        model.addAttribute("srboard",dto);
//        model.addAttribute("memberName",user.getName());//로그인한 사용자 정보 가지고 옴
        model.addAttribute("memberName",SecurityContextHolder.getContext().getAuthentication().getName());
        return "srboardUpdate";
    }

    @GetMapping({"","/index"})
    public String index() {
        return "redirect:/chat/room";
    }
//    @GetMapping("/room")
//    public String rooms() {
//    return "/chat/room";
//}
//
//    @GetMapping("/room/enter/{roomId}")
//    public String roomDetail(Model model, @PathVariable String roomId) {
//        model.addAttribute("roomId", roomId);
//        return "/chat/roomdetail";
//    }
}
