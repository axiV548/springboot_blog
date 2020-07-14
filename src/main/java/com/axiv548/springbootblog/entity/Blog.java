package com.axiv548.springbootblog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Blog
 *
 * @date 2020/7/4 1:10
 */

@Entity
@Table(name = "t_blog")
public class Blog {


    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String firstImg;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    private String content;
    private Integer views;
    private boolean publicStatus;
    private boolean commentStatus;
    private boolean releaseStatus;
    private boolean recommendStatus;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    @ManyToOne
    private Types types;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    @Transient
    private String tagIds;

    private String description;

    public Blog() {

    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public boolean isPublicStatus() {
        return publicStatus;
    }

    public void setPublicStatus(boolean publicStatus) {
        this.publicStatus = publicStatus;
    }

    public boolean isCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(boolean commentStatus) {
        this.commentStatus = commentStatus;
    }

    public boolean isReleaseStatus() {
        return releaseStatus;
    }

    public void setReleaseStatus(boolean releaseStatus) {
        this.releaseStatus = releaseStatus;
    }

    public boolean isRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(boolean recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getTagIds() {
        return tagIds;
    }

    public void setTagIds(String tagIds) {
        this.tagIds = tagIds;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void init() {
        this.tagIds = tagsToIds(this.getTags());

    }

    private String tagsToIds(List<Tag> tags) {
        if (!tags.isEmpty()) {
            StringBuffer ids = new StringBuffer();
            boolean flag = false;
            for (Tag tag : tags) {
                if (flag) {
                    ids.append(",");
                } else {
                    flag = true;
                }
                ids.append(tag.getId());
            }
            return ids.toString();
        } else {
            return tagIds;
        }
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", firstImg='" + firstImg + '\'' +
                ", content='" + content + '\'' +
                ", views=" + views +
                ", publicStatus=" + publicStatus +
                ", commentStatus=" + commentStatus +
                ", releaseStatus=" + releaseStatus +
                ", recommendStatus=" + recommendStatus +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", types=" + types +
                ", tags=" + tags +
                ", user=" + user +
                ", comments=" + comments +
                ", tagIds='" + tagIds + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
