package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.service.CommentService;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import com.capstone9.coin_singer.web.dto.BoardUpdateRequestDto;
import com.capstone9.coin_singer.web.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/api/v1/comment")
    public Long save(@RequestBody CommentSaveRequestDto requestDto){
        commentService.save(requestDto);
        return Long.valueOf(1);
    }

}
