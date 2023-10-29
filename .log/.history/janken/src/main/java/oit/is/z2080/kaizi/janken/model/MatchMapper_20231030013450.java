package oit.is.z2080.kaizi.janken.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface MatchMapper {
    @Select("SELECT id, user1, user2, user1Hand, user2Hand, isActive from matches")
    ArrayList <Match> selectAllMatches();

    @Select("SELECT id, user1, user2, user1Hand, user2Hand, isActive from matches where isActive = true")
    Match selectActiveMatch();

    @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand, isActive) VALUES (#{user1}, #{user2}, #{user1Hand}, #{user2Hand}, #{isActive})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertMatch(Match match);
}