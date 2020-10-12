package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.service.SRBoardService;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import com.capstone9.coin_singer.web.dto.SRBoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SRBoardController {
    private final SRBoardService srboardService;

    @PostMapping("/api/v1/srboard")
    public Long save(@RequestBody SRBoardSaveRequestDto requestDto){
        System.out.println("컨트롤러");
        srboardService.save(requestDto);
        return Long.valueOf(1);
    }
}
