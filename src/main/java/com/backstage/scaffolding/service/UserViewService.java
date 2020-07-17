package com.backstage.scaffolding.service;

import com.backstage.scaffolding.vo.UserVO;

/**
 * @author DevilChen
 */
public interface UserViewService {

    /**
     * 根据ID获取用户购物车
     * @param id ID
     * @return Object
     */
    UserVO getUserShoppingCartById(String id);
}
