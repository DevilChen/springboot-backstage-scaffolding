package com.backstage.scaffolding.service;

import com.backstage.scaffolding.vo.UserRoleVO;

import java.util.List;

/**
 * @author DevilChen
 */
public interface UserRoleService {

    /**
     * 查询拥有某角色的用户信息
     *
     * @param roleId 角色ID
     * @return List
     */
    List<UserRoleVO> selectUserByRoleId(String roleId);

    /**
     * 查询某用户的对应的角色（模糊查询）
     *
     * @return List
     */
    List<UserRoleVO> selectRoleByUserName();
}
