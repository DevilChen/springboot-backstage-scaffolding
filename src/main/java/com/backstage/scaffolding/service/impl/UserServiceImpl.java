package com.backstage.scaffolding.service.impl;

import com.backstage.scaffolding.mapper.*;
import com.backstage.scaffolding.model.*;
import com.backstage.scaffolding.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


/**
 * @author DevilChen
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
