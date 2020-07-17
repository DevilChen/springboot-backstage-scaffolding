package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.vo.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author DevilChen
 */
@Repository
public interface UserViewMapper {

    /**
     * 根据ID获取用户购物车
     * @param id ID
     * @return Object
     */
    @Select(value = "SELECT\n" +
            "\t* \n" +
            "FROM\n" +
            "USER \n" +
            "WHERE\n" +
            "\tid =#{id}")
    UserVO getUserShoppingCartById(String id);
}
