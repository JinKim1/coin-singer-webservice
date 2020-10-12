package com.capstone9.coin_singer.domain.singingroomboard;

import com.capstone9.coin_singer.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class SRBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private String img1;
    @Column(nullable = false)
    private String img2;
    @Column(nullable = false)
    private long price;
    @Column(nullable = false)
    private long star;
    @Column(nullable = false)
    private long facility;

    @Builder
    public SRBoard(String name, String location, String img1, String img2, long price, long star, long facility) {
        this.name = name;
        this.location = location;
        this.img1 = img1;
        this.img2 = img2;
        this.price = price;
        this.star = star;
        this.facility = facility;
    }

//    public void update(String title, String content){
//        this.title = title;
//        this.content = content;
//    }
}
