package com.capstone9.coin_singer.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    Member findByEmail(String email);
    Member findByUsername(String username);
}
