package com.haily.controller;


import com.haily.service.ISysMenuService;
import com.haily.service.ISysRoleMenuService;
import com.haily.service.ISysRoleService;
import com.haily.service.ISysUserService;
import com.haily.util.ShiroUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class UserRoleController {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysMenuService sysMenuService;
    @Autowired
    private ISysRoleMenuService sysRoleMenuService;

    /** 管理员角色测试接口 */
    @RequestMapping("/getAdminInfo")
    @RequiresRoles("ADMIN")
    public Map<String,Object> getAdminInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有管理员角色能访问的接口");
        return map;
    }

    /** 用户角色测试接口 */
    @RequestMapping("/getUserInfo")
    @RequiresRoles("USER")
    public Map<String,Object> getUserInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只有用户角色能访问的接口");
        return map;
    }

    /** 角色测试接口 */
    @RequestMapping("/getRoleInfo")
    @RequiresRoles(value={"ADMIN","USER"},logical = Logical.OR)
    //验证用户是否被记忆，user有两种含义：
    //一种是成功登录的（subject.isAuthenticated() 结果为true）
    //另外一种是被记忆的（subject.isRemembered()结果为true）
    @RequiresUser
    public Map<String,Object> getRoleInfo(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","这里是只要有ADMIN或者USER角色能访问的接口");
        return map;
    }

    /** 登出 */
    @RequestMapping("/getLogout")
    @RequiresUser
    public Map<String,Object> getLogout(){
        ShiroUtils.logout();
        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","登出");
        return map;
    }


}
