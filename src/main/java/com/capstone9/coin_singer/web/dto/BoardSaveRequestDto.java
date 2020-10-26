package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String writer;
    private String title;
    private String content;

    @Builder
    public BoardSaveRequestDto(String writer,String title, String content){
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board toEntity(){
        return Board.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .build();
    }
}
