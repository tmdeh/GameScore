package com.gamescore.service.member.jwt;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.gamescore.domain.Member;

public interface Token {
    String sign(Member member);

    DecodedJWT verify(String token);
}
