package com.sbs.exam.sb_app_2022_10_13.repository;

import com.sbs.exam.sb_app_2022_10_13.vo.Board;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardRepository {

  @Select("""
          SELECT *         
          FROM board AS B
          WHERE B.id = #{id}
          AND B.delStatus = 0
          """)
  Board getBoardById(@Param("id") int id);
}
