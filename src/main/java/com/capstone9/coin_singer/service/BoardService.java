package com.capstone9.coin_singer.service;

import com.capstone9.coin_singer.domain.board.Board;
import com.capstone9.coin_singer.domain.board.BoardRepository;
import com.capstone9.coin_singer.web.dto.BoardListResponseDto;
import com.capstone9.coin_singer.web.dto.BoardReadResponseDto;
import com.capstone9.coin_singer.web.dto.BoardSaveRequestDto;
import com.capstone9.coin_singer.web.dto.BoardUpdateRequestDto;
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

    @Transactional
    public Long update(Long id, BoardUpdateRequestDto requestDto){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
        board.update(requestDto.getWriter(),requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Board board = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
        boardRepository.delete(board);
    }

    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAll(Pageable pageable){
        return boardRepository.findAll(pageable).stream().map(board->new BoardListResponseDto(board)).collect(Collectors.toList());
    }


    public BoardReadResponseDto findById(Long id){
        Board entity = boardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        return new BoardReadResponseDto(entity);
    }
}
