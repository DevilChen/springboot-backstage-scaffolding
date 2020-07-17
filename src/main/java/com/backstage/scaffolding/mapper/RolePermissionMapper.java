package com.backstage.scaffolding.mapper;

import com.backstage.scaffolding.vo.RolePermissionVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author DevilChen
 */
@Repository
public interface RolePermissionMapper {

    /**
     * 查询拥有某权限的角色
     *
     * @param permissionName 权限名称
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tp.`name` permissionName,\n" +
            "\tr.`name` roleName\n" +
            "FROM\n" +
            "\tpermission p,\n" +
            "\trole_permission rp,\n" +
            "\trole r \n" +
            "WHERE\n" +
            "\tp.`name` = #{permissionName} \n" +
            "\tAND p.id = rp.permission_id \n" +
            "\tAND rp.role_id = r.id")
    List<RolePermissionVO> selectRoleByPermissionName(String permissionName);

    /**
     * 查询某角色拥有的权限
     *
     * @param roleName 角色名称
     * @return List
     */
    @Select(value = "SELECT\n" +
            "\tr.`name` roleName,\n" +
            "\tp.`name` permissionName\n" +
            "FROM\n" +
            "\tpermission p,\n" +
            "\trole_permission rp,\n" +
            "\trole r \n" +
            "WHERE\n" +
            "\tr.`name` = #{roleName} \n" +
            "\tAND r.id = rp.role_id \n" +
            "\tAND rp.permission_id = p.id;")
    List<RolePermissionVO> selectPermissionByRoleName(String roleName);
}
