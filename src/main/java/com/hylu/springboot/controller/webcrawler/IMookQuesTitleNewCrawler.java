package com.hylu.springboot.controller.webcrawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import com.hylu.springboot.model.webcrawler.QuesTitleModel;
import com.hylu.springboot.mybatis.mapper.webcrawler.QuesTitleMapper;
import com.xiaoleilu.hutool.date.DateUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 慕课网手记(新上榜)文章抓取
 *
 * @author hylu
 */
public class IMookQuesTitleNewCrawler extends BreadthCrawler {

    @Autowired
    private static QuesTitleMapper quesTitleService;

    /**
     * 存储网站信息，后续操作可进行持久化
     */
    protected static List<QuesTitleModel> quesTitleModelList = new ArrayList<>();
    /**
     * 可以设置通用的过滤规则
     *
     * @param crawlPath crawlPath is the path of the directory which maintains
     *                  information of this webcrawler
     * @param autoParse if autoParse is true,BreadthCrawler will auto extract
     *                  links which match regex rules from pag
     */
    public IMookQuesTitleNewCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        //this.addSeed(crawlPath);

        /*fetch url like http://news.hfut.edu.cn/show-xxxxxxhtml*/
        //this.addRegex("http://www.imooc.com/article/*");

        /*do not fetch jpg|png|gif*/
        //this.addRegex("-.*\\.(jpg|png|gif).*");

        /*do not fetch url contains #*/
        //this.addRegex("-.*#.*");

        //setThreads(50);
        //getConf().setTopN(100);

//        setResumable(true);
    }

    /**
     * 这个方法用来处理抓取的数据
     *
     * @param page
     * @param next
     */
    @Override
    public void visit(Page page, CrawlDatums next) {
        //String url = page.url();
        //System.out.println(">>>" + url);
        //保存每篇文章的对象
        QuesTitleModel quesTitleModel;
        //TODO 处理文章标题
        for (int i = 0; i < 15; i++) {
            quesTitleModel = new QuesTitleModel();
            //代码块
            Element element = page.select(".article-lwrap",i);
            //标题块
            Elements titleElements  = element.select(".item-title");
            String kid = titleElements.select("a[href]").attr("href").split("/")[2];
            String title = titleElements.select(".title-detail").text();
            //参数块
            Elements Tagelements  = element.select(".item-btm");
            //TODO 此处作者信息待后续处理
            String lookedCount = Tagelements.select(".right-info .looked").text();
            String recomCount = Tagelements.select(".right-info .recom").text();
            String judgeCount = Tagelements.select(".right-info .judge").text();

            if (title == null || title == "") {
                continue;
            }
            quesTitleModel.setKid(kid);
            quesTitleModel.setTitle(title);
            quesTitleModel.setLookCount(lookedCount);
            quesTitleModel.setRecomCount(recomCount);
            quesTitleModel.setJudgeCount(judgeCount);
            quesTitleModel.setPublicDate(DateUtil.now());
            quesTitleModelList.add(quesTitleModel);

        }
    }


    public static List<QuesTitleModel> getPageDate(int pageTotal) throws Exception {
        for (int page = 1; page <= pageTotal; page++) {
            IMookQuesTitleNewCrawler crawler = new IMookQuesTitleNewCrawler("webcrawler", true);
            crawler.addSeed("http://www.imooc.com/article/hot/" + page);
            //webcrawler.addRegex("http://www.imooc.com/article/hot*//*");
            crawler.setThreads(1);
            //*start crawl with depth of 4*//*
            crawler.start(1);
        }
        return quesTitleModelList;
    }

    /**
     * 测试方法：page表示当前网站的最大页数
     *
     * @param args
     * @throws Exception
     */
    /*public static void main(String[] args) throws Exception {
        IMookQuesTitleNewCrawler crawler = new IMookQuesTitleNewCrawler("webcrawler", true);
        for (int page = 1; page < 2; page++)
            crawler.addSeed("http://www.imooc.com/article/new/" + page);
        //webcrawler.addRegex("http://www.imooc.com/article/hot*//*");
        crawler.setThreads(100);
        *//*start crawl with depth of 4*//*
        crawler.start(4);
    }*/


}