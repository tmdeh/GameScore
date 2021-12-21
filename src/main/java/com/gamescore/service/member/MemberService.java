package com.gamescore.service.member;

import com.gamescore.domain.Member;

public interface MemberService {

    void signUp(Member member) throws Exception;

    void login(Member member) throws  Exception;

}
