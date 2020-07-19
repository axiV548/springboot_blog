package com.axiv548.springbootblog.vo;

/**
 * BlogQuery
 *
 * @date 2020/7/8 22:17
 */
public class BlogQuery {

    private String title;
    private Long typeId;
    private boolean recommendStatus;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(boolean recommendStatus) {
        this.recommendStatus = recommendStatus;
    }
}
