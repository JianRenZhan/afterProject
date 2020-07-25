package com.haily.service;

import com.haily.domain.SysMenu;

import java.util.List;

/**
 * 权限 服务层
 *
 * @author d
 * @date 2020-07-21
 */
public interface ISysMenuService {

    /**
     * 查询权限信息
     *
     * @param menuId 权限ID
     * @return 权限信息
     */
    public SysMenu selectSysMenuById(Long menuId);

    /**
     * 查询权限信息
     *
     * @param roleId 角色ID
     * @return 权限信息
     */
    public List<SysMenu> selectSysMenuByRoleId(Long roleId);

    /**
     * 查询权限列表
     *
     * @param sysMenu 权限信息
     * @return 权限集合
     */
    public List<SysMenu> selectSysMenuList(SysMenu sysMenu);

    /**
     * 新增权限
     *
     * @param sysMenu 权限信息
     * @return 结果
     */
    public int insertSysMenu(SysMenu sysMenu);

    /**
     * 修改权限
     *
     * @param sysMenu 权限信息
     * @return 结果
     */
    public int updateSysMenu(SysMenu sysMenu);

    /**
     * 删除权限信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysMenuByIds(String ids);
}