package com.gamescore.service.score;

import com.gamescore.domain.score.ScoreDTO;
import com.gamescore.exception.score.NotExistScoreListException;
import com.gamescore.mapper.ScoreMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService{
    @Autowired
    private ScoreMapper mapper;


    @Override
    public List<ScoreDTO> allSearch() throws Exception{
        List<ScoreDTO> list = mapper.getAll();
        if(list.size() == 0) {
            throw new NotExistScoreListException();
        }
        return list;
    }

    @Override
    public List<ScoreDTO> search(String id) throws Exception{

        return null;
    }
}
