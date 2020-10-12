package com.capstone9.coin_singer.service;

import com.capstone9.coin_singer.domain.singingroomboard.SRBoard;
import com.capstone9.coin_singer.domain.singingroomboard.SRBoardRepository;
import com.capstone9.coin_singer.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SRBoardService {
    private final SRBoardRepository srboardRepository;

    @Transactional
    public Long save(SRBoardSaveRequestDto requestDto){
        srboardRepository.save(requestDto.toEntity());
        return Long.valueOf(1);
    }

    @Transactional
    public Long update(Long id, SRBoardUpdateRequestDto requestDto){
        System.out.println("업데이트?");
        SRBoard srboard = srboardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
        srboard.update(requestDto.getName(), requestDto.getLocation(), requestDto.getImg1(),requestDto.getImg2(),requestDto.getPrice(),requestDto.getStar(),requestDto.getFacility());
        return id;
    }

    @Transactional
    public void delete(Long id){
        SRBoard srboard = srboardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("nonononono해당 게시글이 없습니다. id = "+id));
        srboardRepository.delete(srboard);
    }

    @Transactional(readOnly = true)
    public List<SRBoardListResponseDto> findAll(){
        return srboardRepository.findAll().stream().map(srBoard->new SRBoardListResponseDto(srBoard)).collect(Collectors.toList());
    }


    public SRBoardReadResponseDto findById(Long id){
        SRBoard entity = srboardRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id = "+id));
        return new SRBoardReadResponseDto(entity);
    }
}
