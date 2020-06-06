package com.woqiyounai.luntan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.woqiyounai.luntan.request.BlogCommentRequest;
import com.woqiyounai.luntan.request.BlogReleaseRequest;
import com.woqiyounai.luntan.request.BlogUpdateRequest;
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
@ApiModel(value="TbBlog对象", description="")
public class TbBlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "博客id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "所属二级分类下的id")
    private Integer v2Id;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客正文")
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

    public TbBlog(Integer id, Integer userId, Integer v2Id, String title, String text, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.v2Id = v2Id;
        this.title = title;
        this.text = text;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbBlog(Integer id, Integer userId, Integer v2Id, String title, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.v2Id = v2Id;
        this.title = title;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbBlog(BlogReleaseRequest blogReleaseRequest) {
        this.v2Id = blogReleaseRequest.getV2Id();
        this.userId = blogReleaseRequest.getUserId();
        this.title = blogReleaseRequest.getTitle();
        this.text = blogReleaseRequest.getText();
    }

    public TbBlog(BlogUpdateRequest blogUpdateRequest) {
        this.id = blogUpdateRequest.getId();
        this.text = blogUpdateRequest.getText();
        this.title = blogUpdateRequest.getTitle();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getV2Id() {
        return v2Id;
    }

    public void setV2Id(Integer v2Id) {
        this.v2Id = v2Id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
        return "TbBlog{" +
        "id=" + id +
        ", userId=" + userId +
        ", v2Id=" + v2Id +
        ", title=" + title +
        ", text=" + text +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
