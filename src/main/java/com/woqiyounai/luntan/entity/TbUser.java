package com.woqiyounai.luntan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.woqiyounai.luntan.request.UserChangeInfoRequest;
import com.woqiyounai.luntan.request.UserRegisteredRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.util.DigestUtils;

/**
 * <p>
 * 
 * </p>
 *
 * @author 小龙
 * @since 2020-05-23
 */
@ApiModel(value="TbUser对象", description="")
public class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户")
    private String nickname;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "用户手机号")
    private String userPhone;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户头像")
    private String userHeadimg;

    @ApiModelProperty(value = "用户自我介绍")
    private String userIntroduction;

    @ApiModelProperty(value = "用户身份标识")
    private Integer identity;

    @ApiModelProperty(value = "用户当前所具有的经验值")
    private Integer userExperience;

    @ApiModelProperty(value = "乐观锁")
    @Version
    private Integer version;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "最后一次更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public TbUser(UserRegisteredRequest userRegisteredRequest) {
        //添加用户标记
        this.identity = 1;
        this.userPhone = userRegisteredRequest.getUserPhone();
        this.username = userRegisteredRequest.getUserName();
        this.nickname = userRegisteredRequest.getNickName();
        this.userIntroduction = userRegisteredRequest.getUserIntroduce();
        this.userPassword = DigestUtils.md5DigestAsHex(userRegisteredRequest.getUserPassword().getBytes());
    }

    public TbUser(Integer id, String nickname, String username, String userPhone, String userPassword, String userHeadimg, String userIntroduction, Integer identity, Integer userExperience, Integer version, Date createTime, Date updateTime) {
        this.id = id;
        this.nickname = nickname;
        this.username = username;
        this.userPhone = userPhone;
        this.userPassword = userPassword;
        this.userHeadimg = userHeadimg;
        this.userIntroduction = userIntroduction;
        this.identity = identity;
        this.userExperience = userExperience;
        this.version = version;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TbUser(UserChangeInfoRequest userChangeInfoRequest) {
        this.id = userChangeInfoRequest.getId();
        this.username = userChangeInfoRequest.getUsername();
        this.nickname = userChangeInfoRequest.getNickname();
        this.userHeadimg = userChangeInfoRequest.getUserHeadimg();
        this.userIntroduction = userChangeInfoRequest.getUserIntroduction();
    }

    public TbUser(Integer userId, String password) {
        this.id = userId;
        this.userPassword = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserIntroduction() {
        return userIntroduction;
    }

    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Integer getUserExperience() {
        return userExperience;
    }

    public void setUserExperience(Integer userExperience) {
        this.userExperience = userExperience;
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

    public String getUserHeadimg() {
        return userHeadimg;
    }

    public void setUserHeadimg(String userHeadimg) {
        this.userHeadimg = userHeadimg;
    }

    @Override
    public String toString() {
        return "TbUser{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userHeadimg='" + userHeadimg + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", identity=" + identity +
                ", userExperience=" + userExperience +
                ", version=" + version +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
