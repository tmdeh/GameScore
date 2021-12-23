package com.gamescore.mapper;

import com.gamescore.domain.score.ScoreDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("SELECT member_id, score_time, score FROM score")
    List<ScoreDTO> getAll();

    @Select("SELECT member_id, score_time, score FROM score WHERE member_id = #{id}")
    List<ScoreDTO> getOneById(@Param("id") String id);
}

