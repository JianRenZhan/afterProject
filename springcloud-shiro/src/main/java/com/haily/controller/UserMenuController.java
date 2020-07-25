package com.haily.controller;


import com.haily.domain.SysMenu;
import com.haily.domain.SysRole;
import com.haily.domain.SysRoleMenu;
import com.haily.domain.SysUser;
import com.haily.service.ISysMenuService;
import com.haily.service.ISysRoleMenuService;
import com.haily.service.ISysRoleService;
import com.haily.service.ISysUserService;
import com.haily.util.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 权限测试
 * @Author Sans
 * @CreateTime 2019/6/19 11:38
 */
@RestController
@RequestMapping("/menu")
public class UserMenuController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /**
     * 获取用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:36
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getUserInfoList")
    @RequiresPermissions("sys:user:info")
    public Map<String,Object> getUserInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysUser> sysUserEntityList = sysUserService.selectSysUserList(new SysUser());
        map.put("sysUserEntityList",sysUserEntityList);
        return map;
    }

    /**
     * 获取角色信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:37
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getRoleInfoList")
    @RequiresPermissions("sys:role:info")
    public Map<String,Object> getRoleInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysRole> sysRoleEntityList = sysRoleService.selectSysRoleList(new SysRole());
        map.put("sysRoleEntityList",sysRoleEntityList);
        return map;
    }

    /**
     * 获取权限信息集合
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getMenuInfoList")
    @RequiresPermissions("sys:menu:info")
    public Map<String,Object> getMenuInfoList(){
        Map<String,Object> map = new HashMap<>();
        List<SysMenu> sysMenuEntityList = sysMenuService.selectSysMenuList(new SysMenu());
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    /**
     * 获取所有数据
     * @Author Sans
     * @CreateTime 2019/6/19 10:38
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/getInfoAll")
    @RequiresPermissions("sys:info:all")
    public Map<String,Object> getInfoAll(){
        Map<String,Object> map = new HashMap<>();
        List<SysUser> sysUserEntityList = sysUserService.selectSysUserList(null);
        map.put("sysUserEntityList",sysUserEntityList);
        List<SysRole> sysRoleEntityList = sysRoleService.selectSysRoleList(null);
        map.put("sysRoleEntityList",sysRoleEntityList);
        List<SysMenu> sysMenuEntityList = sysMenuService.selectSysMenuList(null);
        map.put("sysMenuEntityList",sysMenuEntityList);
        return map;
    }

    /**
     * 添加管理员角色权限(测试动态权限更新)
     * @Author Sans
     * @CreateTime 2019/6/19 10:39
     * @Param  username 用户ID
     * @Return Map<String,Object> 返回结果
     */
    @RequestMapping("/addMenu")
    public Map<String,Object> addMenu(){
        //添加管理员角色权限
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setMenuId(4L);
        sysRoleMenu.setRoleId(1L);
        sysRoleMenuService.insertSysRoleMenu(sysRoleMenu);
        //清除缓存
        String username = "admin";
        ShiroUtils.deleteCache(username,false);
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","权限添加成功");
        return map;
    }




}
