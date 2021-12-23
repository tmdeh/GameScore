package com.gamescore.controller;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.gamescore.domain.response.DefaultResponse;
import com.gamescore.exception.MemberException;
import com.gamescore.exception.score.NotExistScoreListException;
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
        return createResponse("메소드가 잘못 되었습니다.(GET, POST, PUT)", 404, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MemberException.class})
    public ResponseEntity MemberException(MemberException ex) {
        System.out.printf(ex.getMessage());
        return createResponse(ex.getMessage(), 400, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({LoginException.class})
    public ResponseEntity LoginFail(LoginException ex) {
        System.out.println(ex.getMessage());
        DefaultResponse<Object> response = new DefaultResponse<>(ex.getMessage(), 401, null);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({NotExistScoreListException.class})
    public ResponseEntity handleNotExistScoreList(NotExistScoreListException ex) {
        ex.printStackTrace();
        return createResponse(ex.getMessage(), 200, HttpStatus.OK);
    }

    //아이디 중복 핸들러
    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity handleDuplicatedId(DuplicateKeyException ex) {
        System.out.printf(ex.getMessage());
        return createResponse("아이디나 닉네임이 중복 됐습니다.", 400, HttpStatus.BAD_REQUEST);
    }

    //토큰 생성 예외
    @ExceptionHandler({JWTCreationException.class})
    public ResponseEntity handleJwtCreation(JWTCreationException ex) {
        return createResponse("jwt토큰 생성 오류", 400, HttpStatus.BAD_REQUEST);
    }
    //토큰 해석 예외
    @ExceptionHandler({JWTDecodeException.class})
    public ResponseEntity handleJwtDecoding(JWTCreationException ex) {
        ex.printStackTrace();
        return createResponse("jwt토큰 해석 오류", 401, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleAll(Exception ex) {
        ex.printStackTrace();
        return createResponse("Server Errorr!!", 500, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity createResponse(String msg, int status, HttpStatus httpStatus) {
        DefaultResponse<Object> response = new DefaultResponse(msg, status, null);
        return new ResponseEntity<DefaultResponse>(response, httpStatus);
    }

}
