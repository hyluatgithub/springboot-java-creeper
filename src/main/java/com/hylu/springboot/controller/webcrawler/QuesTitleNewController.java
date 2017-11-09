package com.hylu.springboot.controller.webcrawler;

import com.hylu.springboot.model.webcrawler.QuesTitleModel;
import com.hylu.springboot.mybatis.mapper.webcrawler.QuesTitleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lhy13 on 2017/11/9.
 */
@RestController
public class QuesTitleNewController {
    @Autowired
    private QuesTitleMapper quesTitleService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/start")
    public void start() throws Exception {
        QuesTitleModel quesTitleModel = quesTitleService.findById(1000L);
        System.out.println(quesTitleModel.getTitle());
    }

    @RequestMapping("/db")
    public void db() throws Exception {
        List<QuesTitleModel> quesTitleModelList = IMookQuesTitleNewCrawler.getPageDate(95);
        this.save(quesTitleModelList);
    }

    private void save(List<QuesTitleModel> quesTitleModelList) {
        if (quesTitleModelList != null && quesTitleModelList.size() > 0) {
            for (QuesTitleModel quesTitleModel : quesTitleModelList) {
                quesTitleService.insertByModel(quesTitleModel);
            }
        }
    }
}
