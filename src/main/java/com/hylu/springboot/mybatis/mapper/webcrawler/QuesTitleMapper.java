package com.hylu.springboot.mybatis.mapper.webcrawler;

import com.hylu.springboot.model.webcrawler.QuesTitleModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 手记文章表映射操作
 *
 * @author lhy13
 * @date 2017/11/9
 */
public interface QuesTitleMapper {

    @Insert("INSERT INTO imook_ques_title_new (kid,title, lookCount, recomCount, judgeCount, author, publicDate)VALUES (#{kid},#{title},#{lookCount},#{recomCount},#{judgeCount},#{author},#{publicDate})")
    int insertByModel(QuesTitleModel quesTitleModel);

    @Select("SELECT * FROM imook_ques_title_new WHERE kid = #{kid}")
    QuesTitleModel findById(@Param("kid") Long kid);

    /*property属性对应User对象中的成员名，column对应SELECT出的字段名*/
    @Results({
            @Result(property = "kid", column = "kid"),
            @Result(property = "title", column = "title"),
            @Result(property = "lookCount", column = "lookCount"),
            @Result(property = "recomCount", column = "recomCount"),
            @Result(property = "judgeCount", column = "judgeCount"),
            @Result(property = "author", column = "author"),
            @Result(property = "publicDate", column = "publicDate")
    })
    @Select("SELECT * FROM imook_ques_title_new")
    List<QuesTitleModel> findAll();
}
