package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.board.Board;
import com.capstone9.coin_singer.domain.singingroomboard.SRBoard;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SRBoardListResponseDto {
    private Long id;
    private String name;
    private String location;
    private String img1;
    private String img2;
    private long price;
    private long star;
    private long facility;

    public SRBoardListResponseDto(SRBoard entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.location = entity.getLocation();
        this.img1 = entity.getImg1();
        this.img2 = entity.getImg2();
        this.price = entity.getPrice();
        this.star = entity.getStar();
        this.facility = entity.getFacility();
    }
}
