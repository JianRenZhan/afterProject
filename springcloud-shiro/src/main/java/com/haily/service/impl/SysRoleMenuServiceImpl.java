package com.haily.service.impl;

import com.haily.domain.SysRoleMenu;
import com.haily.mapper.SysRoleMenuMapper;
import com.haily.service.ISysRoleMenuService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色与权限关系 服务层实现
 *
 * @author d
 * @date 2020-07-21
 */
@Service
public class SysRoleMenuServiceImpl implements ISysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    /**
     * 查询角色与权限关系信息
     *
     * @param id 角色与权限关系ID
     * @return 角色与权限关系信息
     */
    @Override
    public SysRoleMenu selectSysRoleMenuById(Long id) {
        return sysRoleMenuMapper.selectSysRoleMenuById(id);
    }

    /**
     * 查询角色与权限关系列表
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 角色与权限关系集合
     */
    @Override
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.selectSysRoleMenuList(sysRoleMenu);
    }

    /**
     * 新增角色与权限关系
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 结果
     */
    @Override
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.insertSysRoleMenu(sysRoleMenu);
    }

    /**
     * 修改角色与权限关系
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 结果
     */
    @Override
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu) {
        return sysRoleMenuMapper.updateSysRoleMenu(sysRoleMenu);
    }

    /**
     * 删除角色与权限关系对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysRoleMenuByIds(String ids) {
        return sysRoleMenuMapper.deleteSysRoleMenuByIds(Convert.toStrArray(ids));
    }
}