package com.haily.mapper;

import com.haily.domain.SysUserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户与角色关系 数据层
 *
 * @author d
 * @date 2020-07-21
 */
@Repository
public interface SysUserRoleMapper {

    /**
     * 查询用户与角色关系信息
     *
     * @param id 用户与角色关系ID
     * @return 用户与角色关系信息
     */
    public SysUserRole selectSysUserRoleById(Long id);

    /**
     * 查询用户与角色关系列表
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 用户与角色关系集合
     */
    public List<SysUserRole> selectSysUserRoleList(SysUserRole sysUserRole);

    /**
     * 新增用户与角色关系
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 结果
     */
    public int insertSysUserRole(SysUserRole sysUserRole);

    /**
     * 修改用户与角色关系
     *
     * @param sysUserRole 用户与角色关系信息
     * @return 结果
     */
    public int updateSysUserRole(SysUserRole sysUserRole);

    /**
     * 删除用户与角色关系
     *
     * @param id 用户与角色关系ID
     * @return 结果
     */
    public int deleteSysUserRoleById(Long id);

    /**
     * 批量删除用户与角色关系
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysUserRoleByIds(String[] ids);
}