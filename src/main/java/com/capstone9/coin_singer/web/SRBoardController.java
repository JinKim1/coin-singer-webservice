package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.service.SRBoardService;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import com.capstone9.coin_singer.web.dto.BoardUpdateRequestDto;
import com.capstone9.coin_singer.web.dto.SRBoardSaveRequestDto;
import com.capstone9.coin_singer.web.dto.SRBoardUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SRBoardController {
    private final SRBoardService srboardService;

    @PostMapping("/api/v1/srboard")
    public Long save(@RequestBody SRBoardSaveRequestDto requestDto){
        srboardService.save(requestDto);
        return Long.valueOf(1);
    }

    @PutMapping("/api/v1/srboard/{id}")
    public Long update(@PathVariable Long id, @RequestBody SRBoardUpdateRequestDto requestDto) {
        System.out.println("여기까지?");
        return srboardService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/srboard/{id}")
    public Long delete(@PathVariable Long id) {
        srboardService.delete(id);
        return id;
    }
}
