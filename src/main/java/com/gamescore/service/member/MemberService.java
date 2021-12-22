package com.gamescore.service.member;

import com.gamescore.domain.Member;
import com.gamescore.domain.response.TokenAndNicknameVO;

public interface MemberService {

    void signUp(Member member) throws Exception;

    TokenAndNicknameVO login(Member member) throws  Exception;

    boolean idDuplicatedCheck(String id) throws Exception;

    boolean nicknameDuplicatedCheck(String nickname) throws Exception;

}
