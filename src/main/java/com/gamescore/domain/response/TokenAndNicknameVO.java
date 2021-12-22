package com.gamescore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TokenAndNicknameVO {
    private String Token;
    private String nickname;
}
