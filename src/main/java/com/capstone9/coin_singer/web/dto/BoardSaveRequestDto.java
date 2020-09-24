package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String footprint;

    @Builder
    public BoardSaveRequestDto(String footprint){
        this.footprint=footprint;
    }

    public Board toEntity(){
        return Board.builder()
                .footprint(footprint)
                .build();
    }

}
