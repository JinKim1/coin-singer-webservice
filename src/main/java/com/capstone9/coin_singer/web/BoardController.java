package com.capstone9.coin_singer.web;

import com.capstone9.coin_singer.service.BoardService;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 사용자가 작성 버튼을 누르면 /api/v1/board 와 연결된 save 함수에 json형태의 data를 넘겨주며 함수를 호출한다.
    // 이때 save 함수의 parameter로 받는 BoardSaveRequestDto 객체는 index.js 에서 넘겨받는 data와 변수들이 일치해야 한다.
    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto){
        boardService.save(requestDto);
        return Long.valueOf(1);
    }
}
