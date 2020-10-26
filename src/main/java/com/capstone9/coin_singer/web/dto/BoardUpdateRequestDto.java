package com.capstone9.coin_singer.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String writer;
    private String title;
    private String content;

    @Builder
    public BoardUpdateRequestDto(String writer,String title, String content){
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
