package com.haily.service;

import com.haily.domain.SysUser;

import java.util.List;

/**
 * 系统用户 服务层
 *
 * @author d
 * @date 2020-07-21
 */
public interface ISysUserService {

    /**
     * 查询系统用户信息
     *
     * @param userId 系统用户ID
     * @return 系统用户信息
     */
    public SysUser selectSysUserById(Long userId);

    /**
     * 查询系统用户列表
     *
     * @param sysUser 系统用户信息
     * @return 系统用户集合
     */
    public List<SysUser> selectSysUserList(SysUser sysUser);

    /**
     * 新增系统用户
     *
     * @param sysUser 系统用户信息
     * @return 结果
     */
    public int insertSysUser(SysUser sysUser);

    /**
     * 修改系统用户
     *
     * @param sysUser 系统用户信息
     * @return 结果
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 删除系统用户信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserByIds(String ids);
}