package com.backstage.scaffolding.service.impl;

import com.backstage.scaffolding.mapper.UserPermissionMapper;
import com.backstage.scaffolding.service.UserPermissionService;
import com.backstage.scaffolding.vo.UserPermissionVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author DevilChen
 */
@Service
public class UserPermissionServiceImpl implements UserPermissionService {

    private final UserPermissionMapper userPermissionMapper;

    public UserPermissionServiceImpl(UserPermissionMapper userPermissionMapper) {
        this.userPermissionMapper = userPermissionMapper;
    }

    @Override
    public List<UserPermissionVO> selectPermissionByUserName(String userName) {
        return userPermissionMapper.selectPermissionByUserName(userName);
    }

    @Override
    public List<UserPermissionVO> selectUserByPermissionName(String permissionName) {
        return userPermissionMapper.selectUserByPermissionName(permissionName);
    }
}
