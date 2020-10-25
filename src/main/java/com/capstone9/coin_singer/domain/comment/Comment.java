package com.capstone9.coin_singer.domain.comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long board_id;
    @Column(nullable = false)
    private String writer;
    @Column(nullable = false)
    private String content;

    @Builder
    public Comment(Long board_id,String writer, String content) {
        this.board_id = board_id;
        this.writer = writer;
        this.content = content;
    }

//    public void update(Long board_id,String writer, String content){
//        this.board_id = board_id;
//        this.writer = writer;
//        this.content = content;
//    }
}
