package com.gamescore.controller;

import com.gamescore.domain.Member;
import com.gamescore.domain.response.DefaultResponse;
import com.gamescore.domain.response.TokenAndNicknameVO;
import com.gamescore.service.member.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {
    private MemberService service;

    public MemberController(MemberService memberService) {
        this.service = memberService;
    }

    @PostMapping("signup")
    public ResponseEntity signUp(Member member) throws Exception{
        service.signUp(member);
        DefaultResponse<Object> response = new DefaultResponse("CREATED", 201, null);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity login(Member member) throws Exception{
        TokenAndNicknameVO result = service.login(member);
        DefaultResponse<TokenAndNicknameVO> response = new DefaultResponse("OK", 200, result);
        return new ResponseEntity<DefaultResponse>(response,HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity idDuplicatedCheck(@PathVariable("id") String id) throws Exception{
        if(service.idDuplicatedCheck(id)) {
            return new ResponseEntity<DefaultResponse>
                    (new DefaultResponse<Object>("OK", 200, null),
                            HttpStatus.OK);
        } else {
            return new ResponseEntity<DefaultResponse>
                    (new DefaultResponse<Object>("아이디가 이미 존재합니다.", 400, null),
                            HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/nickname/{nickname}")
    public ResponseEntity nicknameDuplicatedCheck(@PathVariable("nickname") String nickname) throws Exception{
        if(service.nicknameDuplicatedCheck(nickname)) {
            return new ResponseEntity<DefaultResponse>
                    (new DefaultResponse<Object>("OK", 200, null),
                            HttpStatus.OK);
        } else {
            return new ResponseEntity<DefaultResponse>
                    (new DefaultResponse<Object>("닉네임이 이미 존재합니다.", 400, null),
                            HttpStatus.BAD_REQUEST);
        }
    }
}
