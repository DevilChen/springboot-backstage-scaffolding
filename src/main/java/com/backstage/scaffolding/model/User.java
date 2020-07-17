package com.backstage.scaffolding.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User implements Serializable {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户名
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 昵称
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 密码
     */
    @TableField
    private String password;
    /**
     * 头像
     */
    @TableField
    private String avatar;
    /**
     * 邮箱
     */
    @TableField
    private String email;
    /**
     * 状态
     */
    @TableField
    private String status;
    /**
     * 手机号
     */
    @TableField
    private String mobile;
    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 修改人
     */
    @TableField(value = "update_by")
    private String updateBy;
    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}
