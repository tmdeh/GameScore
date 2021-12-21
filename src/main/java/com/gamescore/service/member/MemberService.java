package com.gamescore.service.member;

import com.gamescore.domain.Member;

public interface MemberService {

    String signUp(Member member) throws Exception;

    String login(Member member) throws  Exception;

}
