package com.hylu.springboot.model.webcrawler;

/**
 * 手记文章实体
 *
 * @author lhy13
 * @date 2017/11/9
 */
public class QuesTitleModel {
    private Long id;
    //文章序号
    private String kid;
    //标题
    private String title;
    //浏览量
    private String lookCount;
    //推荐数
    private String recomCount;
    //评论数
    private String judgeCount;
    private String author;
    private String publicDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLookCount() {
        return lookCount;
    }

    public void setLookCount(String lookCount) {
        this.lookCount = lookCount;
    }

    public String getRecomCount() {
        return recomCount;
    }

    public void setRecomCount(String recomCount) {
        this.recomCount = recomCount;
    }

    public String getJudgeCount() {
        return judgeCount;
    }

    public void setJudgeCount(String judgeCount) {
        this.judgeCount = judgeCount;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }
}
