package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String author;
    private String content;
    private String footprint;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.footprint = entity.getFootprint();
    }
}
