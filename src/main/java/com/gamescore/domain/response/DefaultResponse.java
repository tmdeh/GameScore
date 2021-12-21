package com.gamescore.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultResponse<T> {
    private String msg;
    private int status;
    private  T data;
}
