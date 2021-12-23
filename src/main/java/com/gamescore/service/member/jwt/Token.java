package com.gamescore.service.member.jwt;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gamescore.domain.Member;

public interface Token {
    public String sign(Member member) throws Exception;

    public DecodedJWT verify(String token) throws JWTVerificationException;
}
