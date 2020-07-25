package com.haily.mapper;

import com.haily.domain.SysRole;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色 数据层
 *
 * @author d
 * @date 2020-07-21
 */
@Repository
public interface SysRoleMapper {

    /**
     * 查询角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    public SysRole selectSysRoleById(Long roleId);

    /**
     * 查询角色信息
     *
     * @param userId 角色ID
     * @return 角色信息
     */
    public List<SysRole> selectSysRoleByUserId(@Param("userId") Long userId);

    /**
     * 查询角色列表
     *
     * @param sysRole 角色信息
     * @return 角色集合
     */
    public List<SysRole> selectSysRoleList(SysRole sysRole);

    /**
     * 新增角色
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    public int insertSysRole(SysRole sysRole);

    /**
     * 修改角色
     *
     * @param sysRole 角色信息
     * @return 结果
     */
    public int updateSysRole(SysRole sysRole);

    /**
     * 删除角色
     *
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteSysRoleById(Long roleId);

    /**
     * 批量删除角色
     *
     * @param roleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysRoleByIds(String[] roleIds);
}