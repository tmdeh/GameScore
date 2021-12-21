package com.gamescore.controller;

import com.gamescore.domain.response.DefaultResponse;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity handelMethodNotSupport (HttpRequestMethodNotSupportedException ex) {
        System.out.printf(ex.getMessage());
        DefaultResponse<String> response = new DefaultResponse<>();
        response.setMsg("메소드가 잘못 되었습니다.(GET, POST, PUT)");
        response.setStatus(404);
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DuplicateKeyException.class})
    public ResponseEntity handleDuplicatedId(DuplicateKeyException ex) {
        System.out.printf(ex.getMessage());
        DefaultResponse<String> response = new DefaultResponse<>();
        response.setStatus(400);
        response.setMsg("아이디가 중복 됐습니다.");
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleAll(Exception ex) {
        ex.printStackTrace();
        DefaultResponse<String> response = new DefaultResponse();
        response.setStatus(500);
        response.setMsg("Server Error!!");
        return new ResponseEntity<DefaultResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
