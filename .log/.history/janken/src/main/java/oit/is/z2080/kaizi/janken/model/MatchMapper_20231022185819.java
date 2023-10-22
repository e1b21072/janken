package oit.is.z2080.kaizi.janken.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface MatchMapper {
    @Select("SELECT id, user1, user2, user1Hand, user2Hand from matches")
    ArrayList <Match> selectAllMatches();

    @Insert("INSERT INTO matches (user1, user2, user1Hand, user2Hand) VALUES (#{user1}, #{user2}, #{user1Hand}, #{user2Hand})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void insertMatch(Match match);
}