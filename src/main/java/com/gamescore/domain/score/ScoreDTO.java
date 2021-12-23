package com.gamescore.domain.score;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ScoreDTO {
    private String memberId;
    private Date scoreTime;
    private long score;
}
