package com.haily.domain;

import lombok.Data;
import java.io.Serializable;

/**
 * 权限表 sys_menu
 *
 * @author d
 * @date 2020-07-21
 */
@Data
public class SysMenu implements Serializable {
    private static final long serialVersionUID=1L;

    /** 权限ID */
    private Long menuId;

    /** 权限名称 */
    private String name;

    /** 权限标识 */
    private String perms;

}