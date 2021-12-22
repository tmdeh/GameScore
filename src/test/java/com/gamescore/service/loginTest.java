package com.gamescore.service;

import com.gamescore.domain.Member;
import com.gamescore.mapper.MemberMapper;
import com.gamescore.service.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class loginTest {
    
    @Autowired
    MemberService memberService;
    
    @Autowired
    MemberMapper mapper;
    
    @Test
    public void getSaltTest() {
    }
}
