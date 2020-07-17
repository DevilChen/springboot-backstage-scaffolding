package com.backstage.scaffolding.vo;

import com.backstage.scaffolding.model.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class UserVO implements Serializable {

    private Long id;

    private String userName;

    private String nickName;

    private String password;

    private String avatar;

    private String email;

    private String status;

    private String mobile;

    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private String updateBy;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    private ShoppingCart shoppingCart;
}
