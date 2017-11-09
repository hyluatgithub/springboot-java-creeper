package com.hylu.springboot.mybatis.mapper;

import com.hylu.springboot.SpringbootJavaCreeperApplication;
import com.hylu.springboot.model.test.UserModel;
import com.hylu.springboot.mybatis.mapper.test.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * 用户方法测试类
 * <p>
 * Created by lhy13 on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SpringbootJavaCreeperApplication.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() throws Exception {
        int resultNum = userMapper.insert("A1", "A");
        Assert.assertEquals(1, resultNum);
    }

    @Test
    public void findByUserName() throws Exception {
        userMapper.insert("A3", "AAA");
        UserModel u = userMapper.findByUserName("AAA");
        Assert.assertEquals("AAA", u.getUserName());
    }

    @Test
    public void findAll() throws Exception {
        List<UserModel> userModelList = userMapper.findAll();
        for (UserModel userModel : userModelList) {
            System.out.println(userModel.getId()+":"+userModel.getUserId()+":"+userModel.getUserName());
        }
    }
}