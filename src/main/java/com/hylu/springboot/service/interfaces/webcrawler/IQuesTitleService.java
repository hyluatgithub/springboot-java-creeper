package com.hylu.springboot.service.interfaces.webcrawler;

import com.hylu.springboot.model.webcrawler.QuesTitleModel;

import java.util.List;

/**
 * 手记操作方法接口
 * <p>
 * Created by lhy13 on 2017/11/9.
 */
public interface IQuesTitleService {

    int insertByModel(QuesTitleModel quesTitleModel);

    QuesTitleModel findById(Long kid);

    List<QuesTitleModel> findAll();


}
