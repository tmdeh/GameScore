package com.gamescore.controller;

import com.gamescore.domain.Member;
import com.gamescore.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberService service;

    @PostMapping("signup")
    public ResponseEntity signUp(@RequestBody Member member) throws Exception{
        service.signUp(member);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity login(Member member) throws Exception{
        service.login(member);
        return new ResponseEntity(HttpStatus.OK);
    }
}
