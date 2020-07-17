package com.backstage.scaffolding.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户权限显示
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPermissionVO implements Serializable {

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 用户名
     */
    private String userName;

}
