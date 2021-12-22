package com.gamescore.mapper;

import com.gamescore.domain.Member;
import com.gamescore.domain.response.SaltAndNicknameVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface MemberMapper {
    @Insert("INSERT INTO member(member_id, password, nickname, salt) " +
            "VALUES(#{member.id},#{member.password}, #{member.nickname}, #{salt})")
    int insertMember(@Param("member") Member member, @Param("salt") String salt);

    @Select("SELECT salt, nickname FROM member WHERE member_id = #{id}")
    SaltAndNicknameVO getSalt(@Param("id") String id);

    @Select("SELECT if(count(member_id) = 1, 1, 0) as exist FROM member " +
            "WHERE nickname = #{member.nickname} OR member_id = #{member.id}")
    int duplicatedCheck(@Param("member") Member member);

}
