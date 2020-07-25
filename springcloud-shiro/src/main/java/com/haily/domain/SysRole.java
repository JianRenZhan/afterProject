package com.haily.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 角色表 sys_role
 *
 * @author d
 * @date 2020-07-21
 */
@Data
public class SysRole implements Serializable {
    private static final long serialVersionUID=1L;

    /** 角色ID */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

}