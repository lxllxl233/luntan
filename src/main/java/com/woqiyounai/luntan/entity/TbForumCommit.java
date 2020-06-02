package com.woqiyounai.luntan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.woqiyounai.luntan.request.LunTanCommentRequest;
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
@ApiModel(value="TbForumCommit对象", description="")
public class TbForumCommit implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "论坛讨论 id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "评论的层级")
    private Integer pId;

    @ApiModelProperty(value = "论坛的 id")
    private Integer forumId;

    @ApiModelProperty(value = "评论用户的id")
    private Integer userId;

    @ApiModelProperty(value = "被回复用户的 id")
    private Integer bUserId;

    @ApiModelProperty(value = "回复正文")
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


    public TbForumCommit(Integer id, Integer pId, Integer forumId, Integer userId, Integer bUserId, String text, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.pId = pId;
        this.forumId = forumId;
        this.userId = userId;
        this.bUserId = bUserId;
        this.text = text;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbForumCommit(LunTanCommentRequest lunTanCommentRequest) {
        this.pId = lunTanCommentRequest.getpId();
        this.userId = lunTanCommentRequest.getUserId();
        this.bUserId = lunTanCommentRequest.getbUserId();
        this.forumId = lunTanCommentRequest.getForumId();
        this.text = lunTanCommentRequest.getText();
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

    public Integer getForumId() {
        return forumId;
    }

    public void setForumId(Integer forumId) {
        this.forumId = forumId;
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
        return "TbForumCommit{" +
        "id=" + id +
        ", pId=" + pId +
        ", forumId=" + forumId +
        ", userId=" + userId +
        ", bUserId=" + bUserId +
        ", text=" + text +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
