package com.hylu.springboot.mybatis.mapper.webcrawler;

import com.hylu.springboot.SpringbootJavaCreeperApplication;
import com.hylu.springboot.controller.start.Application;
import com.hylu.springboot.model.test.UserModel;
import com.hylu.springboot.model.webcrawler.QuesTitleModel;
import com.xiaoleilu.hutool.date.DateUtil;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * 手记文章测试类
 * <p>
 * Created by lhy13 on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
//FixMethodOrder 执行顺序
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class QuesTitleMapperTest {
    @Autowired
    private QuesTitleMapper quesTitleMapper;

    @Test
    public void test1InsertByModel() throws Exception {
        QuesTitleModel quesTitleModel = new QuesTitleModel();
        quesTitleModel.setKid("1000");
        quesTitleModel.setTitle("中文测试标题");
        quesTitleModel.setAuthor("admin");
        quesTitleModel.setJudgeCount("100");
        quesTitleModel.setLookCount("200");
        quesTitleModel.setRecomCount("300");
        quesTitleModel.setPublicDate(DateUtil.now());

        int resultNum = quesTitleMapper.insertByModel(quesTitleModel);
        Assert.assertEquals(1, resultNum);
    }

    @Test
    public void test2FindById() throws Exception {
        QuesTitleModel quesTitleModel = quesTitleMapper.findById(1000L);
        Assert.assertEquals("中文测试标题", quesTitleModel.getTitle());
    }

    @Test
    public void test3FindAll() throws Exception {
        List<QuesTitleModel> quesTitleModelList = quesTitleMapper.findAll();
        Assert.assertEquals(1, quesTitleModelList.size());
    }

}