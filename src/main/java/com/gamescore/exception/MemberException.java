package com.gamescore.exception;

//존재하지 않는 사용자 예외
public class MemberException extends Exception{
    public MemberException(String msg) {
        super(msg);
    }

    class LoginFailException extends Exception {
        public LoginFailException() {
            super("아이디와 비밀번호가 일치하지 않습니다.");
        }
    }
}
