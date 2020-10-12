package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.Comment;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentSaveRequestDto {
    private Long board_id;
    private String writer;
    private String content;

    @Builder
    public CommentSaveRequestDto(Long board_id,String writer, String content){
        this.board_id = board_id;
        this.writer = writer;
        this.content = content;
    }

    public Comment toEntity(){
        return Comment.builder()
                .board_id(board_id)
                .writer(writer)
                .content(content)
                .build();
    }
}
