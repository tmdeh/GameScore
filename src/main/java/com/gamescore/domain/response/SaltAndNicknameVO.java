package com.gamescore.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SaltAndNicknameVO {
    private String salt;
    private String nickname;
}
