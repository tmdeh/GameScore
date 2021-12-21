package com.gamescore.service.member;

import com.gamescore.domain.Member;
import com.gamescore.mapper.MemberMapper;
import com.gamescore.service.member.jwt.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberMapper memberMapper;

    private PasswordEncoder encoder;

    private Token token;

    public MemberServiceImpl(PasswordEncoder passwordEncoder, Token token) {
        this.encoder = passwordEncoder;
        this.token = token;
    }


    @Override
    public String signUp(Member member) throws Exception{
        String tokenStr = token.sign(member);
        String salt = encoder.encode(member.getPassword());
        memberMapper.insertMember(member, salt);
        return tokenStr;
    }

    @Override
    public String login(Member member) throws Exception{
        return null;
    }
}
