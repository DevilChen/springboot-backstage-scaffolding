package com.backstage.scaffolding.service.impl;

import com.backstage.scaffolding.mapper.UserRoleMapper;
import com.backstage.scaffolding.service.UserRoleService;
import com.backstage.scaffolding.vo.UserRoleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DevilChen
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleMapper userRoleMapper;

    public UserRoleServiceImpl(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    @Override
    public List<UserRoleVO> selectUserByRoleId(String roleId) {
        return userRoleMapper.selectUserByRoleId(roleId);
    }

    @Override
    public List<UserRoleVO> selectRoleByUserName() {
        return userRoleMapper.selectRoleByUserName();
    }
}
