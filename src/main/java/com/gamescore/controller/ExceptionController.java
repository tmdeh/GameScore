package com.gamescore.controller;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.gamescore.domain.response.DefaultResponse;
import com.gamescore.exception.MemberException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.security.auth.login.LoginException;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity handelMethodNotSupport (HttpRequestMethodNotSupportedException ex) {
        System.out.printf(ex.getMessage());
        DefaultResponse<Object> response = new DefaultResponse<>("메소드가 잘못 되었습니다.(GET, POST, PUT)",
                404, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MemberException.class})
    public ResponseEntity MemberException(MemberException ex) {
        System.out.printf(ex.getMessage());
        DefaultResponse<Object> response = new DefaultResponse<>(ex.getMessage(), 400, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({LoginException.class})
    public ResponseEntity LoginFail(LoginException ex) {
        System.out.println(ex.getMessage());
        DefaultResponse<Object> response = new DefaultResponse<>(ex.getMessage(), 401, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }


    //아이디 중복 핸들러
    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity handleDuplicatedId(DuplicateKeyException ex) {
        System.out.printf(ex.getMessage());
        DefaultResponse<Object> response = new DefaultResponse<>("아이디나 닉네임이 중복 됐습니다.", 400, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({JWTCreationException.class})
    public ResponseEntity handleJwtCreation(JWTCreationException ex) {
        ex.printStackTrace();
        DefaultResponse<Object> response = new DefaultResponse<>("jwt토큰 생성 오류", 400, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleAll(Exception ex) {
        ex.printStackTrace();
        DefaultResponse<Object> response = new DefaultResponse("Server Errorr!!", 500, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
