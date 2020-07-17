package com.backstage.scaffolding.controller;

import com.backstage.scaffolding.model.User;
import com.backstage.scaffolding.service.UserService;
import com.backstage.scaffolding.service.UserViewService;
import com.backstage.scaffolding.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author DevilChen
 */
@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    private final UserViewService userViewService;

    public UserController(UserService userService, UserViewService userViewService) {
        this.userService = userService;
        this.userViewService = userViewService;
    }

    /**
     * 获取用户列表
     *
     * @return List
     */
    @GetMapping(value = "getList")
    public List<User> getList() {
        LOGGER.info("======获取用户列表======");
        return userService.list();
    }

    /**
     * 根据ID查询用户信息
     *
     * @param id String
     * @return User
     */
    @GetMapping(value = "getById")
    public User getById(@RequestParam String id) {
        LOGGER.info("======根据ID查询用户信息======");
        return userService.getById(id);
    }

    /**
     * 添加用户
     *
     * @param user Object
     * @return boolean
     */
    @PostMapping(value = "save")
    public boolean save(@RequestBody User user) {
        LOGGER.info("======添加用户======");
        return userService.save(user);
    }

    /**
     * 修改用户
     *
     * @param user Object
     * @return boolean
     */
    @PutMapping(value = "update")
    public boolean update(@RequestBody User user) {
        LOGGER.info("======修改用户======");
        return userService.updateById(user);
    }

    /**
     * 根据ID删除用户
     *
     * @param id String
     * @return boolean
     */
    @DeleteMapping(value = "delete")
    public boolean delete(@RequestParam String id) {
        LOGGER.info("======根据ID删除用户======");
        return userService.removeById(id);
    }

    @GetMapping(value = "getUserShoppingCartById")
    public UserVO getUserShoppingCartById(String id) {
        LOGGER.info("======根据ID获取用户购物车======");
        return userViewService.getUserShoppingCartById(id);
    }

    @GetMapping(value = "selectUserPage")
    public IPage<User> selectUserPage(Page<User> page){
        return userService.page(page);
    }

}
