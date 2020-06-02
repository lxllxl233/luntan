package com.woqiyounai.luntan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.woqiyounai.luntan.request.BlogCommentRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author 小龙
 * @since 2020-05-23
 */
@ApiModel(value="TbBlogComment对象", description="")
public class TbBlogComment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客评论id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "层级")
    private Integer pId;

    @ApiModelProperty(value = "博客的id")
    private Integer blogId;

    @ApiModelProperty(value = "用户的id")
    private Integer userId;

    @ApiModelProperty(value = "被回复的userId")
    private Integer bUserId;

    @ApiModelProperty(value = "评论的正文")
    private String text;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "最后一次更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public TbBlogComment(Integer id, Integer pId, Integer blogId, Integer userId, Integer bUserId, String text, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.pId = pId;
        this.blogId = blogId;
        this.userId = userId;
        this.bUserId = bUserId;
        this.text = text;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbBlogComment(BlogCommentRequest blogCommentRequest) {
        this.userId = blogCommentRequest.getUserId();
        this.pId = blogCommentRequest.getpId();
        this.bUserId = blogCommentRequest.getbUserId();
        this.blogId = blogCommentRequest.getBlogId();
        this.text = blogCommentRequest.getText();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getbUserId() {
        return bUserId;
    }

    public void setbUserId(Integer bUserId) {
        this.bUserId = bUserId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    @Override
    public String toString() {
        return "TbBlogComment{" +
        "id=" + id +
        ", pId=" + pId +
        ", blogId=" + blogId +
        ", userId=" + userId +
        ", bUserId=" + bUserId +
        ", text=" + text +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
