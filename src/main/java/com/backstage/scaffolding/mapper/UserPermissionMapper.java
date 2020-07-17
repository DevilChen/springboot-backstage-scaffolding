package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.vo.UserPermissionVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DevilChen
 */
@Repository
public interface UserPermissionMapper {

    /**
     * 查询某用户拥有的权限
     *
     * @param userName 用户名
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tp.`name` permissionName\n" +
            "FROM\n" +
            "\tpermission p,\n" +
            "\trole_permission rp,\n" +
            "\trole r \n" +
            "WHERE\n" +
            "\tr.id = rp.role_id \n" +
            "\tAND rp.permission_id = p.id \n" +
            "\tAND r.id IN (\n" +
            "SELECT\n" +
            "\tr.id \n" +
            "FROM\n" +
            "\tuser u,\n" +
            "\trole r,\n" +
            "\tuser_role ur \n" +
            "WHERE\n" +
            "\tu.user_name = #{userName} \n" +
            "\tAND u.id = ur.user_id \n" +
            "\tAND ur.role_id = r.id \n" +
            "\t)")
    List<UserPermissionVO> selectPermissionByUserName(String userName);

    /**
     * 查询拥有某权限的用户
     *
     * @param permissionName 权限名称
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
            "\tr.id = ur.role_id \n" +
            "\tAND ur.user_id = u.id \n" +
            "\tAND r.id IN (\n" +
            "SELECT\n" +
            "\tr.id \n" +
            "FROM\n" +
            "\tpermission p,\n" +
            "\trole_permission rp,\n" +
            "\trole r \n" +
            "WHERE\n" +
            "\tp.`name` = #{permissionName} \n" +
            "\tAND p.id = rp.permission_id \n" +
            "\tAND rp.role_id = r.id \n" +
            "\t)")
    List<UserPermissionVO> selectUserByPermissionName(String permissionName);
}
