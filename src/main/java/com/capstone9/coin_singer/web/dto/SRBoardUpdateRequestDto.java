package com.capstone9.coin_singer.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SRBoardUpdateRequestDto {
    private String name;
    private String location;
    private String img1;
    private String img2;
    private long price;
    private long star;
    private long facility;

    @Builder
    public SRBoardUpdateRequestDto(String name, String location, String img1, String img2, long price, long star, long facility){
        this.name = name;
        this.location = location;
        this.img1 = img1;
        this.img2 = img2;
        this.price = price;
        this.star = star;
        this.facility = facility;
    }
}
