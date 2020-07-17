package com.backstage.scaffolding.service.impl;

import com.backstage.scaffolding.mapper.RolePermissionMapper;
import com.backstage.scaffolding.service.RolePermissionService;
import com.backstage.scaffolding.vo.RolePermissionVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DevilChen
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionMapper rolePermissionMapper;

    public RolePermissionServiceImpl(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    @Override
    public List<RolePermissionVO> selectRoleByPermissionName(String permissionName) {
        return rolePermissionMapper.selectRoleByPermissionName(permissionName);
    }

    @Override
    public List<RolePermissionVO> selectPermissionByRoleName(String roleName) {
        return rolePermissionMapper.selectPermissionByRoleName(roleName);
    }
}
