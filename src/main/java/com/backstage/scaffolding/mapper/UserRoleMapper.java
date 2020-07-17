package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.vo.UserRoleVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DevilChen
 */
@Repository
public interface UserRoleMapper {

    /**
     * 查询拥有某角色的用户信息
     *
     * @param roleId 角色ID
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tu.id,\n" +
            "\tu.user_name \n" +
            "FROM\n" +
            "\tUSER u,\n" +
            "\trole r,\n" +
            "\tuser_role ur \n" +
            "WHERE\n" +
            "\tr.id = #{roleId} \n" +
            "\tAND r.id = ur.role_id \n" +
            "\tAND ur.user_id = u.id")
    List<UserRoleVO> selectUserByRoleId(String roleId);

    /**
     * 查询某用户的对应的角色（模糊查询）
     *
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tu.id,\n" +
            "\tu.user_name,\n" +
            "\tr.`name` role_name \n" +
            "FROM\n" +
            "\tUSER u,\n" +
            "\trole r,\n" +
            "\tuser_role ur \n" +
            "WHERE\n" +
            "\tu.user_name LIKE 'J%' \n" +
            "\tAND u.id = ur.user_id \n" +
            "\tAND ur.role_id = r.id")
    List<UserRoleVO> selectRoleByUserName();
}
