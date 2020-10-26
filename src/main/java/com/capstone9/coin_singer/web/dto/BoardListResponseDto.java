package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.board.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String writer;
    private String title;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.modifiedDate = entity.getModifiedDate();
    }
}
