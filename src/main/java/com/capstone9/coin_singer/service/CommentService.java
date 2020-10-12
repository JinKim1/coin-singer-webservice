package com.capstone9.coin_singer.service;

import com.capstone9.coin_singer.domain.Board;
import com.capstone9.coin_singer.domain.BoardRepository;
import com.capstone9.coin_singer.domain.CommentRepository;
import com.capstone9.coin_singer.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentSaveRequestDto requestDto){
        commentRepository.save(requestDto.toEntity());
        return Long.valueOf(1);
    }

    @Transactional(readOnly = true)
    public List<CommentListResponseDto> findAll(Long id){
        return commentRepository.fff(id).stream().map(comment->new CommentListResponseDto(comment)).collect(Collectors.toList());
    }

//    @Transactional
//    public Long update(Long id, BoardUpdateRequestDto requestDto){
//        Board board = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
//        board.update(requestDto.getTitle(), requestDto.getContent());
//        return id;
//    }
//
//    @Transactional
//    public void delete(Long id){
//        Board board = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
//        commentRepository.delete(board);
//    }
//
//    @Transactional(readOnly = true)
//    public List<BoardListResponseDto> findAll(Pageable pageable){
//        return commentRepository.findAll(pageable).stream().map(board->new BoardListResponseDto(board)).collect(Collectors.toList());
//    }
//
//
//    public BoardReadResponseDto findById(Long id){
//        Board entity = commentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
//        return new BoardReadResponseDto(entity);
//    }
}
