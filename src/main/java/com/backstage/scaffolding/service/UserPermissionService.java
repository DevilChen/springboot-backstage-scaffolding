package com.backstage.scaffolding.service;

import com.backstage.scaffolding.vo.UserPermissionVO;

import java.util.List;

/**
 * @author DevilChen
 */
public interface UserPermissionService {

    /**
     * 查询某用户拥有的权限
     *
     * @param userName 用户名
     * @return List
     */
    List<UserPermissionVO> selectPermissionByUserName(String userName);

    /**
     * 查询拥有某权限的用户
     *
     * @param permissionName 权限名称
     * @return List
     */
    List<UserPermissionVO> selectUserByPermissionName(String permissionName);
}
