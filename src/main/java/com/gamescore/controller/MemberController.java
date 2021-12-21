package com.gamescore.controller;

import com.gamescore.domain.Member;
import com.gamescore.domain.response.DefaultResponse;
import com.gamescore.domain.response.TokenVO;
import com.gamescore.service.member.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService service;

    public MemberController(MemberService memberService) {
        this.service = memberService;
    }

    @PostMapping("signup")
    public ResponseEntity signUp(@RequestBody Member member) throws Exception{
         TokenVO token = new TokenVO(service.signUp(member));
        DefaultResponse<String> response = new DefaultResponse("CREATED", 201, token);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity login(Member member) throws Exception{
        service.login(member);
        DefaultResponse<Object> response = new DefaultResponse("OK", 200, null);
        return new ResponseEntity<DefaultResponse>(response,HttpStatus.OK);
    }
}
