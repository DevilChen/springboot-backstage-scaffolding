package com.backstage.scaffolding.model;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品
 *
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product implements Serializable {

    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    @TableField
    private String name;

    /**
     * 商品描述
     */
    @TableField
    private String description;

    @TableField
    private String image;

    @TableField
    private Integer count;

    /**
     * 用户ID
     */
    @TableField(value = "user_id")
    private Long userId;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    @JsonIgnore
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    /**
     * 修改人
     */
    @TableField(value = "update_by")
    @JsonIgnore
    private String updateBy;

    /**
     * 修改时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date updateTime;

    private Label label;

    private Stock stock;
}
