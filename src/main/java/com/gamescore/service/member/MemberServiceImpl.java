package com.gamescore.service.member;

import com.gamescore.domain.Member;
import com.gamescore.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    private PasswordEncoder encoder;

    public MemberServiceImpl(PasswordEncoder passwordEncoder) {
        this.encoder = passwordEncoder;
    }


    @Override
    public void signUp(Member member) throws Exception{
        String salt = encoder.encode(member.getPassword());
        memberMapper.insertMember(member, salt);
    }

    @Override
    public void login(Member member) throws Exception{

    }
}
