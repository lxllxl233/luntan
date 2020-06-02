package com.woqiyounai.luntan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.woqiyounai.luntan.request.LunTanReleaseRequest;
import com.woqiyounai.luntan.request.LunTanUpdateRequest;
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
@ApiModel(value="TbForum对象", description="")
public class TbForum implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "论坛的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "论坛所属二级分类id")
    private Integer v2Id;

    @ApiModelProperty(value = "创建者的id")
    private Integer userId;

    @ApiModelProperty(value = "论坛标题")
    private String title;

    @ApiModelProperty(value = "论坛正文")
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

    public TbForum(Integer id, Integer v2Id, Integer userId, String title, String text, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.v2Id = v2Id;
        this.userId = userId;
        this.title = title;
        this.text = text;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbForum(LunTanReleaseRequest lunTanReleaseRequest) {
        this.v2Id = lunTanReleaseRequest.getV2Id();
        this.userId = lunTanReleaseRequest.getUserId();
        this.title = lunTanReleaseRequest.getTitle();
        this.text = lunTanReleaseRequest.getText();
    }

    public TbForum(LunTanUpdateRequest lunTanUpdateRequest) {
        this.id = lunTanUpdateRequest.getId();
        this.title = lunTanUpdateRequest.getTitle();
        this.text = lunTanUpdateRequest.getText();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getV2Id() {
        return v2Id;
    }

    public void setV2Id(Integer v2Id) {
        this.v2Id = v2Id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
        return "TbForum{" +
        "id=" + id +
        ", v2Id=" + v2Id +
        ", userId=" + userId +
        ", title=" + title +
        ", text=" + text +
        ", version=" + version +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
