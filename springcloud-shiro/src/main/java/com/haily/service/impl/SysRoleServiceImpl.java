package com.haily.service.impl;

import com.haily.domain.SysRole;
import com.haily.mapper.SysRoleMapper;
import com.haily.service.ISysRoleService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 服务层实现
 *
 * @author d
 * @date 2020-07-21
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    /**
     * 查询角色信息
     *
     * @param userId 角色ID
     * @return 角色信息
     */
    @Override
    public List<SysRole> selectSysRoleByuserId(Long userId) {
        return sysRoleMapper.selectSysRoleByUserId(userId);
    }

    /**
     * 查询角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    @Override
    public SysRole selectSysRoleById(Long roleId) {
        return sysRoleMapper.selectSysRoleById(roleId);
    }

    /**
     * 查询角色列表
     *
     * @param sysRole 角色信息
     * @return 角色集合
     */
    @Override
    public List<SysRole> selectSysRoleList(SysRole sysRole) {
        return sysRoleMapper.selectSysRoleList(sysRole);
    }

    /**
     * 新增角色
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int insertSysRole(SysRole sysRole) {
        return sysRoleMapper.insertSysRole(sysRole);
    }

    /**
     * 修改角色
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    @Override
    public int updateSysRole(SysRole sysRole) {
        return sysRoleMapper.updateSysRole(sysRole);
    }

    /**
     * 删除角色对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleByIds(String ids) {
        return sysRoleMapper.deleteSysRoleByIds(Convert.toStrArray(ids));
    }
}