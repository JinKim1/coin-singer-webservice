package com.capstone9.coin_singer.web.dto;

import com.capstone9.coin_singer.domain.board.Board;
import com.capstone9.coin_singer.domain.singingroomboard.SRBoard;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SRBoardSaveRequestDto {
    private String name;
    private String location;
    private String img1;
    private String img2;
    private long price;
    private long star;
    private long facility;

    @Builder
    public SRBoardSaveRequestDto(String name, String location, String img1, String img2, long price, long star, long facility){
        this.name = name;
        this.location = location;
        this.img1 = img1;
        this.img2 = img2;
        this.price = price;
        this.star = star;
        this.facility = facility;
    }

    public SRBoard toEntity(){
        return SRBoard.builder()
                .name(name)
                .location(location)
                .img1(img1)
                .img2(img2)
                .price(price)
                .star(star)
                .facility(facility)
                .build();
    }
}
