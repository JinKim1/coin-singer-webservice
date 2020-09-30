package com.capstone9.coin_singer.web.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PageMaker {
    private int pageCategory;
    private int currentPage;
    private List<PageHelper> previousPageList;
    private List<PageHelper> NextPageList;

    public PageMaker(int currentPage){
        this.currentPage = currentPage + 1 ;
        this.previousPageList = new ArrayList<PageHelper>();
        this.NextPageList = new ArrayList<PageHelper>();

        if(this.currentPage%5==1){
            this.NextPageList.add(new PageHelper(this.currentPage, this.currentPage+1));
            this.NextPageList.add(new PageHelper(this.currentPage+1,this.currentPage+2));
            this.NextPageList.add(new PageHelper(this.currentPage+2,this.currentPage+3));
            this.NextPageList.add(new PageHelper(this.currentPage+3,this.currentPage+4));
        }

        if(this.currentPage%5==2){
            this.previousPageList.add(new PageHelper(this.currentPage-2,this.currentPage-1));
            this.NextPageList.add(new PageHelper(this.currentPage,this.currentPage+1));
            this.NextPageList.add(new PageHelper(this.currentPage+1,this.currentPage+2));
            this.NextPageList.add(new PageHelper(this.currentPage+2,this.currentPage+3));
        }

        if(this.currentPage%5==3){
            this.previousPageList.add(new PageHelper(this.currentPage-3,this.currentPage-2));
            this.previousPageList.add(new PageHelper(this.currentPage-2,this.currentPage-1));
            this.NextPageList.add(new PageHelper(this.currentPage,this.currentPage+1));
            this.NextPageList.add(new PageHelper(this.currentPage+1,this.currentPage+2));
        }
        if(this.currentPage%5==4){
            this.previousPageList.add(new PageHelper(this.currentPage-4,this.currentPage-3));
            this.previousPageList.add(new PageHelper(this.currentPage-3,this.currentPage-2));
            this.previousPageList.add(new PageHelper(this.currentPage-2,this.currentPage-1));
            this.NextPageList.add(new PageHelper(this.currentPage,this.currentPage+1));
        }
        if(this.currentPage%5==0){
            this.previousPageList.add(new PageHelper(this.currentPage-5,this.currentPage-4));
            this.previousPageList.add(new PageHelper(this.currentPage-4,this.currentPage-3));
            this.previousPageList.add(new PageHelper(this.currentPage-3,this.currentPage-2));
            this.previousPageList.add(new PageHelper(this.currentPage-2,this.currentPage-1));
        }
    }

}