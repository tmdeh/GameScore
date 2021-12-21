package com.gamescore.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.TypeAlias;

@Getter
@Setter
@ToString
@AllArgsConstructor
@TypeAlias("member")
public class Member {
    private String id;
    private String password;
    private String nickname;
}
