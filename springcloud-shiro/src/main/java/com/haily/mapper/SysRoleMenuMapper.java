package com.haily.mapper;

import com.haily.domain.SysRoleMenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色与权限关系 数据层
 *
 * @author d
 * @date 2020-07-21
 */
@Repository
public interface SysRoleMenuMapper {

    /**
     * 查询角色与权限关系信息
     *
     * @param id 角色与权限关系ID
     * @return 角色与权限关系信息
     */
    public SysRoleMenu selectSysRoleMenuById(Long id);

    /**
     * 查询角色与权限关系列表
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 角色与权限关系集合
     */
    public List<SysRoleMenu> selectSysRoleMenuList(SysRoleMenu sysRoleMenu);

    /**
     * 新增角色与权限关系
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 结果
     */
    public int insertSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 修改角色与权限关系
     *
     * @param sysRoleMenu 角色与权限关系信息
     * @return 结果
     */
    public int updateSysRoleMenu(SysRoleMenu sysRoleMenu);

    /**
     * 删除角色与权限关系
     *
     * @param id 角色与权限关系ID
     * @return 结果
     */
    public int deleteSysRoleMenuById(Long id);

    /**
     * 批量删除角色与权限关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRoleMenuByIds(String[] ids);
}