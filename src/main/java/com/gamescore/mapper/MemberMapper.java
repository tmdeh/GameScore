package com.gamescore.mapper;

import com.gamescore.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member(member_id, password, nickname, salt) " +
            "VALUES(#{member.id},#{member.password}, #{member.nickname}, #{salt})")
    int insertMember(@Param("member") Member member, @Param("salt") String salt);
}
