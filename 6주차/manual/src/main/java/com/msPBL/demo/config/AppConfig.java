package com.msPBL.demo.config;

import com.msPBL.demo.MemberRepository;
import com.msPBL.demo.MemberService;
import com.msPBL.demo.MemoryMemberRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
}