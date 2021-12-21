package com.gamescore.service.member;

import com.gamescore.domain.Member;
import com.gamescore.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public void signUp(Member member) throws Exception{
        memberMapper.insertMember(member);
    }

    @Override
    public void login(Member member) throws Exception{

    }
}
