package com.msPBL.demo.config;

import com.msPBL.demo.repository.MemberRepository;
import com.msPBL.demo.MemberService;
import com.msPBL.demo.repository.MemoryMemberRepository;


public class AppConfig {


    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }


    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}