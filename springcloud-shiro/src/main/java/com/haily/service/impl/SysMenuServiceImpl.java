package com.haily.service.impl;

import com.haily.domain.SysMenu;
import com.haily.mapper.SysMenuMapper;
import com.haily.service.ISysMenuService;
import com.haily.util.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限 服务层实现
 *
 * @author d
 * @date 2020-07-21
 */
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuMapper sysMenuMapper;

    /**
     * 查询权限信息
     *
     * @param roleId 角色ID
     * @return 权限信息
     */
    @Override
    public List<SysMenu> selectSysMenuByRoleId(Long roleId) {
        return sysMenuMapper.selectSysMenuByRoleId(roleId);
    }

    /**
     * 查询权限信息
     *
     * @param menuId 权限ID
     * @return 权限信息
     */
    @Override
    public SysMenu selectSysMenuById(Long menuId) {
        return sysMenuMapper.selectSysMenuById(menuId);
    }

    /**
     * 查询权限列表
     *
     * @param sysMenu 权限信息
     * @return 权限集合
     */
    @Override
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu) {
        return sysMenuMapper.selectSysMenuList(sysMenu);
    }

    /**
     * 新增权限
     *
     * @param sysMenu 权限信息
     * @return 结果
     */
    @Override
    public int insertSysMenu(SysMenu sysMenu) {
        return sysMenuMapper.insertSysMenu(sysMenu);
    }

    /**
     * 修改权限
     *
     * @param sysMenu 权限信息
     * @return 结果
     */
    @Override
    public int updateSysMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateSysMenu(sysMenu);
    }

    /**
     * 删除权限对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSysMenuByIds(String ids) {
        return sysMenuMapper.deleteSysMenuByIds(Convert.toStrArray(ids));
    }
}