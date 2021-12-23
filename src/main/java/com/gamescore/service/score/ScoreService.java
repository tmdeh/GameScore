package com.gamescore.service.score;

import com.gamescore.domain.score.ScoreDTO;

import java.util.List;

public interface ScoreService {
    List<ScoreDTO> allSearch() throws Exception;

    List<ScoreDTO> search(String id) throws Exception;
}
