package com.haily.service.impl;

import com.haily.domain.SysUserRole;
import com.haily.mapper.SysUserRoleMapper;
import com.haily.service.ISysUserRoleService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户与角色关系 服务层实现
 *
 * @author d
 * @date 2020-07-21
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 查询用户与角色关系信息
     *
     * @param id 用户与角色关系ID
     * @return 用户与角色关系信息
     */
    @Override
    public SysUserRole selectSysUserRoleById(Long id) {
        return sysUserRoleMapper.selectSysUserRoleById(id);
    }

    /**
     * 查询用户与角色关系列表
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 用户与角色关系集合
     */
    @Override
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole) {
        return sysUserRoleMapper.selectSysUserRoleList(sysUserRole);
    }

    /**
     * 新增用户与角色关系
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 结果
     */
    @Override
    public int insertSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.insertSysUserRole(sysUserRole);
    }

    /**
     * 修改用户与角色关系
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 结果
     */
    @Override
    public int updateSysUserRole(SysUserRole sysUserRole) {
        return sysUserRoleMapper.updateSysUserRole(sysUserRole);
    }

    /**
     * 删除用户与角色关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysUserRoleByIds(String ids) {
        return sysUserRoleMapper.deleteSysUserRoleByIds(Convert.toStrArray(ids));
    }
}