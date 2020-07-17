package com.backstage.scaffolding.service;

import com.backstage.scaffolding.vo.RolePermissionVO;

import java.util.List;

/**
 * @author DevilChen
 */
public interface RolePermissionService {

    /**
     * 查询拥有某权限的角色
     *
     * @param permissionName 权限名称
     * @return List
     */
    List<RolePermissionVO> selectRoleByPermissionName(String permissionName);

    /**
     * 查询某角色拥有的权限
     *
     * @param roleName 角色名称
     * @return List
     */
    List<RolePermissionVO> selectPermissionByRoleName(String roleName);
}
