package com.gamescore.domain.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DefaultResponse<T> {
    private String msg;
    private int status;
    private  T data;
}
