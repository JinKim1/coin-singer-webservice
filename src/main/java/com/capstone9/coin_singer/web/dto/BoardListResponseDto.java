package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String footprint;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.footprint = entity.getFootprint();
    }
}
