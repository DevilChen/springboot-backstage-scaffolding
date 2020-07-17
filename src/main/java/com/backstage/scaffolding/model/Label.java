package com.backstage.scaffolding.model;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("label")
public class Label implements Serializable {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField
    private String name;

    @TableField(value = "product_id")
    private Long productId;

    @TableField(value = "create_by")
    @JsonIgnore
    private String createBy;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;

    @TableField(value = "update_by")
    @JsonIgnore
    private String updateBy;

    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    @JsonIgnore
    private Date updateTime;


}
