package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardReadResponseDto {
    private Long id;
    private String writer;
    private String title;
    private String content;

    public BoardReadResponseDto(Board entity){
        this.id = entity.getId();
        this.writer = entity.getWriter();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
