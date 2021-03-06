package com.capstone9.coin_singer.service;

import com.capstone9.coin_singer.domain.member.Member;
import com.capstone9.coin_singer.domain.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service("MemberService")
@Slf4j
public class MemberServiceImpl implements MemberService{
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Member findByUserEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    @Override
    public Member findByUserName(String username) {
        return memberRepository.findByUsername(username);
    }

    @Override
    public void save(Member member) {
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setPasswordConfirm(bCryptPasswordEncoder.encode(member.getPasswordConfirm()));
        memberRepository.save(member);
    }
}
