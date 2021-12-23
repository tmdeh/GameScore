package com.gamescore.service.member.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gamescore.domain.Member;
import com.gamescore.secret.Key;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class TokenImpl implements Token{

    public String sign(Member member) throws Exception{
        Algorithm algorithm = Algorithm.HMAC512(Key.TOKEN);
        Calendar cal = Calendar.getInstance();

        Date expiresAt = new Date();
        cal.setTime(expiresAt);
        cal.add(Calendar.DATE, Key.PERIOD);
        expiresAt = cal.getTime();

        return JWT.create()
                .withIssuer(member.getId())
                .withExpiresAt(expiresAt)
                .withClaim("nickname", member.getNickname())
                .sign(algorithm);
    }

    @Override
    public DecodedJWT verify(String token) throws JWTVerificationException {
        return JWT.decode(token);
    }

}
