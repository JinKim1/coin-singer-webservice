package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.comment.Comment;
import lombok.Getter;

@Getter
public class CommentListResponseDto {
    private String writer;
    private String content;

    public CommentListResponseDto(Comment entity){
        this.writer = entity.getWriter();
        this.content = entity.getContent();
    }
}
