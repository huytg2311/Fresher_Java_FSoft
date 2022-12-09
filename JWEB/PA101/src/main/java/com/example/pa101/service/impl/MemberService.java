package com.example.pa101.service.impl;

import com.example.pa101.model.Member;
import com.example.pa101.repository.IMemberRepository;
import com.example.pa101.repository.impl.MemberRepository;
import com.example.pa101.service.IMemberService;

public class MemberService implements IMemberService {

    IMemberRepository iMemberRepository = new MemberRepository();

    @Override
    public Member getMemberByUsername(String username) {
        return iMemberRepository.getMemberByUsername(username);
    }

    @Override
    public void addMember(Member member) {
        iMemberRepository.addMember(member);
    }

    @Override
    public void updateMember(Member member) {
        iMemberRepository.updateMember(member);
    }
}
