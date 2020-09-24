package com.capstone9.coin_singer.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
//Board 는 Entitiy 어노테이션을 붙였다.
//Board 는 database table이다. id(primary key) 와 footprint로 이루어져있다.
//create table (id long primary key auto increment,footprint varchar(255)); 랑 비슷
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String footprint;

    @Builder
    public Board(String footprint){
        this.footprint=footprint;
    }
}