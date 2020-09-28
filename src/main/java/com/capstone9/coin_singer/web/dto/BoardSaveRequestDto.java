package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private String footprint;

    @Builder
    public BoardSaveRequestDto(String title, String content, String author, String footprint){
        this.title = title;
        this.content = content;
        this.author = author;
        this.footprint=footprint;
    }

    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
