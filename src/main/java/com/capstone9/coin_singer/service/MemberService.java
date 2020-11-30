package com.capstone9.coin_singer.service;


import com.capstone9.coin_singer.domain.member.Member;

public interface MemberService {
    void save(Member member);
    Member findByUserName(String username);
    Member findByUserEmail(String email);
}
