package com.backstage.scaffolding.controller;

import com.backstage.scaffolding.service.UserPermissionService;
import com.backstage.scaffolding.vo.UserPermissionVO;
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
public class UserPermissionController {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserPermissionController.class);

    private final UserPermissionService userPermissionService;

    public UserPermissionController(UserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    /**
     * 根据用户名称查询权限
     * @param userName 用户名
     * @return List
     */
    @GetMapping(value = "selectPermissionByUserName")
    public List<UserPermissionVO> selectPermissionByUserName(@RequestParam String userName) {
        LOGGER.info("======根据用户名称查询权限======");
        return userPermissionService.selectPermissionByUserName(userName);
    }

    /**
     * 根据权限名称查询用户
     * @param permissionName 权限名称
     * @return List
     */
    @GetMapping(value = "selectUserByPermissionName")
    public List<UserPermissionVO> selectUserByPermissionName(@RequestParam String permissionName) {
        LOGGER.info("======根据权限名称查询用户======");
        return userPermissionService.selectUserByPermissionName(permissionName);
    }
}
