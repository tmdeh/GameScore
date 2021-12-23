package com.gamescore.exception.score;

public class NotExistScoreListException extends Exception{
    public NotExistScoreListException() {
        super("랭킹 리스트가 없습니다.");
    }
}
