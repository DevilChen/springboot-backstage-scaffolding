package com.backstage.scaffolding.controller;

import com.backstage.scaffolding.service.RolePermissionService;
import com.backstage.scaffolding.vo.RolePermissionVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author DevilChen
 */
@RestController
public class RolePermissionController {

    private static final Logger LOGGER= LoggerFactory.getLogger(RolePermissionController.class);

    private final RolePermissionService rolePermissionService;

    public RolePermissionController(RolePermissionService rolePermissionService) {
        this.rolePermissionService = rolePermissionService;
    }

    /**
     * 根据权限名称查询角色
     * @param permissionName 权限名称
     * @return List
     */
    @GetMapping(value = "selectRoleByPermissionName")
    public List<RolePermissionVO> selectRoleByPermissionName(@RequestParam String permissionName) {
        LOGGER.info("======根据权限名称查询角色======");
        return rolePermissionService.selectRoleByPermissionName(permissionName);
    }

    /**
     * 根据角色名称查询权限
     * @param roleName 角色名称
     * @return List
     */
    @GetMapping(value = "selectPermissionByRoleName")
    public List<RolePermissionVO> selectPermissionByRoleName(@RequestParam String roleName){
        LOGGER.info("======根据角色名称查询权限======");
        return rolePermissionService.selectPermissionByRoleName(roleName);
    }
}
