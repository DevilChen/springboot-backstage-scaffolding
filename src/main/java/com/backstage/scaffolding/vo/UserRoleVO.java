package com.backstage.scaffolding.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户角色显示
 * @author DevilChen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleVO implements Serializable {

    private Long id;

    private String userName;

    private String roleName;

}
