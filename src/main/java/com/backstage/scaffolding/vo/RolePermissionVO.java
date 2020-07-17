package com.backstage.scaffolding.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 角色权限显示
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RolePermissionVO implements Serializable {

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 权限名称
     */
    private String permissionName;

}
