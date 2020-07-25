package com.haily.service.impl;

import com.haily.domain.SysUser;
import com.haily.mapper.SysUserMapper;
import com.haily.service.ISysUserService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 系统用户 服务层实现
 *
 * @author d
 * @date 2020-07-21
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 查询系统用户信息
     *
     * @param userId 系统用户ID
     * @return 系统用户信息
     */
    @Override
    public SysUser selectSysUserById(Long userId) {
        return sysUserMapper.selectSysUserById(userId);
    }

    /**
     * 查询系统用户列表
     *
     * @param sysUser 系统用户信息
     * @return 系统用户集合
     */
    @Override
    public List<SysUser> selectSysUserList(SysUser sysUser) {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增系统用户
     *
     * @param sysUser 系统用户信息
     * @return 结果
     */
    @Override
    public int insertSysUser(SysUser sysUser) {
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改系统用户
     *
     * @param sysUser 系统用户信息
     * @return 结果
     */
    @Override
    public int updateSysUser(SysUser sysUser) {
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 删除系统用户对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserByIds(String ids) {
        return sysUserMapper.deleteSysUserByIds(Convert.toStrArray(ids));
    }
}