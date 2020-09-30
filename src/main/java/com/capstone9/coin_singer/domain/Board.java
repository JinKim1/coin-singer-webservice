package com.capstone9.coin_singer.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


//Board 는 Entitiy 어노테이션을 붙였다.
//Board 는 database table이다. id(primary key), title, content, author, footprint로 이루어져있다.
//create table (id long primary key auto_increment,title varchar(255), content varchar(255), author varchar(50), footprint varchar(255)); 랑 비슷
@Getter
@NoArgsConstructor
@Entity
public class Board  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @Builder
    public Board(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}