package com.hylu.springboot.service.impl.webcrawler;

import com.hylu.springboot.model.webcrawler.QuesTitleModel;
import com.hylu.springboot.mybatis.mapper.webcrawler.QuesTitleMapper;
import com.hylu.springboot.service.interfaces.webcrawler.IQuesTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lhy13 on 2017/11/9.
 */
@Service
public class QuesTitleServiceImpl implements IQuesTitleService {

    @Autowired
    private QuesTitleMapper quesTitleMapper;

    @Override
    public int insertByModel(QuesTitleModel quesTitleModel) {
        return quesTitleMapper.insertByModel(quesTitleModel);
    }

    @Override
    public QuesTitleModel findById(Long kid) {
        return quesTitleMapper.findById(kid);
    }

    @Override
    public List<QuesTitleModel> findAll() {
        return quesTitleMapper.findAll();
    }
}
