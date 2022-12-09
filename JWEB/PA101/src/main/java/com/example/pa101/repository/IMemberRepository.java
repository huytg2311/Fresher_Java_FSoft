package com.example.pa101.repository;

import com.example.pa101.model.Member;

public interface IMemberRepository {
    void updateMember(Member member);
    Member getMemberByUsername(String username);
    void addMember(Member member);
}
