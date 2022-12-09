package com.example.pa101.service;

import com.example.pa101.model.Member;

public interface IMemberService {
    Member getMemberByUsername(String username);
    void addMember(Member member);
    void updateMember(Member member);
}
