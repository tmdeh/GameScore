package com.gamescore.config;


import com.gamescore.secret.Key;
import com.gamescore.service.member.MemberService;
import com.gamescore.service.member.MemberServiceImpl;
import com.gamescore.service.member.jwt.Token;
import com.gamescore.service.member.jwt.TokenImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

@Configuration
public class Config {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Pbkdf2PasswordEncoder(Key.SECRET);
    }

    @Bean
    public Token token() {
        return new TokenImpl();
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(passwordEncoder(), token());
    }
}
