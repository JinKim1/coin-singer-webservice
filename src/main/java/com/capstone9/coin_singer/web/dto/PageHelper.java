package com.capstone9.coin_singer.web.dto;

import lombok.Getter;

@Getter
public class PageHelper {
    private int a;
    private int b;

    public PageHelper(int a, int b){
        this.a = a;
        this.b = b;
    }
}