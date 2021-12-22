package com.gamescore.service.member;

import com.gamescore.domain.Member;
import com.gamescore.domain.response.SaltAndNicknameVO;
import com.gamescore.domain.response.TokenAndNicknameVO;
import com.gamescore.exception.MemberException;
import com.gamescore.mapper.MemberMapper;
import com.gamescore.service.member.jwt.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

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
    public void signUp(Member member) throws Exception{
        String salt = encoder.encode(member.getPassword());
        memberMapper.insertMember(member, salt);
    }

    @Override
    public TokenAndNicknameVO login(Member member) throws Exception{
        SaltAndNicknameVO queryResult = memberMapper.getSalt(member.getId());
        if(queryResult.getSalt() == null) {
            throw new MemberException("존재하지 않는 사용자 입니다.");
        }
        if(encoder.matches(member.getPassword(), queryResult.getSalt())) {
            //비밀번호가 일치할시
            String tokenStr = token.sign(member);
            return new TokenAndNicknameVO(tokenStr, queryResult.getNickname());
        } else {
            //아닐시
            throw new LoginException("아이디와 비밀번호가 일치하지 않습니다.");
        }
    }

    @Override
    public boolean idDuplicatedCheck(String id) throws Exception {
        Member member = new Member(id, null, null);
        if(memberMapper.duplicatedCheck(member) == 1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean nicknameDuplicatedCheck(String nickname) throws Exception {
        Member member = new Member(null,null, nickname);
        if(memberMapper.duplicatedCheck(member) == 1) {
            return false;
        } else {
            return true;
        }
    }
}
