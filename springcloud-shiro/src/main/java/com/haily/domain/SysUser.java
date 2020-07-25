package com.haily.domain;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;

/**
 * 系统用户表 sys_user
 *
 * @author d
 * @date 2020-07-21
 */
@Data
@Builder
public class SysUser implements Serializable {
    private static final long serialVersionUID=1L;

    /** 用户ID */
    private Long userId;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 盐值 */
    private String salt;

    /** 状态:NORMAL正常  PROHIBIT禁用 */
    private String state;

    @Tolerate
    public SysUser(){};

}