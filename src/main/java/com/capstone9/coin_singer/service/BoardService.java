package com.capstone9.coin_singer.service;

import com.capstone9.coin_singer.domain.BoardRepository;
import com.capstone9.coin_singer.web.dto.BoardListResponseDto;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto requestDto){
        boardRepository.save(requestDto.toEntity());
        return Long.valueOf(1);
    }


    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAll(){
        return boardRepository.findAll().stream().map(board->new BoardListResponseDto(board)).collect(Collectors.toList());
    }
}
