package com.haily.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 角色与权限关系表 sys_role_menu
 *
 * @author d
 * @date 2020-07-21
 */
@Data
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID=1L;

    /** ID */
    private Long id;

    /** 角色ID */
    private Long roleId;

    /** 权限ID */
    private Long menuId;

}