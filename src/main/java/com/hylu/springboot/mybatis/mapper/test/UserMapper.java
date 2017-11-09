package com.hylu.springboot.mybatis.mapper.test;

import com.hylu.springboot.model.test.UserModel;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * User表映射的操作UserMapper
 *
 * @author lhy13
 * @date 2017/11/9
 */
public interface UserMapper {


    @Select("SELECT * FROM USER WHERE userName = #{userName}")
    UserModel findByUserName(@Param("userName") String userName);

    /**
     * 几种不同传参方式来实现插入操作
     * 1.使用@Param
     *
     * @param userId
     * @param userName
     * @return
     */
    @Insert("INSERT INTO USER(userId, userName) VALUES(#{userId}, #{userName})")
    int insertByParam(@Param("userId") String userId, @Param("userName") String userName);

    /**
     * 几种不同传参方式来实现插入操作
     * 2.使用使用Map
     *
     * @param map
     * @return
     */
    @Insert("INSERT INTO USER(userId, userName) VALUES(#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    /**
     * 几种不同传参方式来实现插入操作
     * 3.使用对象
     *
     * @param user
     * @return
     */
    @Insert("INSERT INTO USER(userId, userName) VALUES(#{userId}, #{userName})")
    int insertByUser(UserModel user);

    /*******************************************华丽的切割线*****************************/
    /*********************************************************************************/

    /**
     * 最基本的增删改查注解-查
     *
     * @param userId
     * @return
     */
    @Select("SELECT * FROM user WHERE userId = #{userId}")
    UserModel findByUserId(@Param("userId") String userId);

    /**
     * 最基本的增删改查注解-插
     *
     * @param userId
     * @param userName
     * @return
     */
    @Insert("INSERT INTO user(userId, userName) VALUES(#{userId}, #{userName})")
    int insert(@Param("userId") String userId, @Param("userName") String userName);

    /**
     * 最基本的增删改查注解-改
     *
     * @param user
     */
    @Update("UPDATE user SET userName=#{userName} WHERE userId=#{userId}")
    void update(UserModel user);

    /**
     * 最基本的增删改查注解-删
     *
     * @param id
     */
    @Delete("DELETE FROM user WHERE id =#{id}")
    void delete(Long id);


    /*******************************************华丽的切割线*****************************/
    /*********************************************************************************/
    /*property属性对应User对象中的成员名，column对应SELECT出的字段名*/
    @Results({
            @Result(property = "userId", column = "userId"),
            @Result(property = "userName", column = "userName")
    })
    @Select("SELECT userId,userName FROM user")
    List<UserModel> findAll();
}
