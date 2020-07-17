package com.backstage.scaffolding.controller;

import com.backstage.scaffolding.service.UserRoleService;
import com.backstage.scaffolding.vo.UserRoleVO;
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
public class UserRoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleController.class);

    private final UserRoleService userRoleService;

    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    /**
     * 根据角色ID查询用户
     * @param roleId 角色ID
     * @return List
     */
    @GetMapping(value = "selectUserByRoleId")
    public List<UserRoleVO> selectUserByRoleId(@RequestParam String roleId) {
        LOGGER.info("======根据角色ID查询用户======");
        return userRoleService.selectUserByRoleId(roleId);
    }

    /**
     * 根据用户名称查询角色（模糊查询）
     * @return List
     */
    @GetMapping(value = "selectRoleByUserName")
    public List<UserRoleVO> selectRoleByUserName() {
        LOGGER.info("======根据用户名称查询角色======");
        return userRoleService.selectRoleByUserName();
    }
}
