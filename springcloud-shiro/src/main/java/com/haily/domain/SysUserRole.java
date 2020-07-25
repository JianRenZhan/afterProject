package com.haily.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 用户与角色关系表 sys_user_role
 *
 * @author d
 * @date 2020-07-21
 */
@Data
public class SysUserRole implements Serializable {
    private static final long serialVersionUID=1L;

    /** ID */
    private Long id;

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;

}