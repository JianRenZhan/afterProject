package com.haily.controller;

import com.haily.domain.SysUser;
import com.haily.domain.SysUserRole;
import com.haily.service.ISysUserRoleService;
import com.haily.service.ISysUserService;
import com.haily.util.SHA256Util;
import com.haily.util.ShiroUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户登录
 * @Author Sans
 * @CreateTime 2019/6/17 15:21
 */
@RestController
@RequestMapping("/userLogin")
public class UserLoginController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysUserRoleService userRoleService;

    /**
     *  登录
     */
    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody SysUser sysUser){
        Map<String,Object> map = new HashMap<>();
        //进行身份验证
        try{
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(sysUser.getUsername(), sysUser.getPassword());
            //验证成功进行登录操作
            subject.login(token);
        }catch (IncorrectCredentialsException e) {
            map.put("code",500);
            map.put("msg","用户不存在或者密码错误");
            return map;
        } catch (LockedAccountException e) {
            map.put("code",500);
            map.put("msg","登录失败，该用户已被冻结");
            return map;
        } catch (AuthenticationException e) {
            map.put("code",500);
            map.put("msg","该用户不存在");
            return map;
        } catch (Exception e) {
            map.put("code",500);
            map.put("msg","未知异常");
            return map;
        }
        map.put("code",0);
        map.put("msg","登录成功");
        map.put("token", ShiroUtils.getSession().getId().toString());
        return map;
    }

    /**
     * 未登录
     * @Author Sans
     * @CreateTime 2019/6/20 9:22
     */
    @RequestMapping("/unauth")
    public Map<String,Object> unauth(){
        Map<String,Object> map = new HashMap<>();
        map.put("code",500);
        map.put("msg","未登录");
        return map;
    }

    /**
     * 添加一个用户演示接口
     * 这里仅作为演示不加任何权限和重复查询校验
     * @Author Sans
     * @CreateTime 2020/1/6 9:22
     */
    @RequestMapping("/testAddUser")
    public Map<String,Object> testAddUser(){
        // 设置基础参数
        SysUser sysUser = new SysUser();
        sysUser.setUsername("user1");
        sysUser.setState("NORMAL");
        // 随机生成盐值
        String salt = RandomStringUtils.randomAlphanumeric(20);
        sysUser.setSalt(salt);
        // 进行加密
        String password ="123456";
        sysUser.setPassword(SHA256Util.sha256(password, sysUser.getSalt()));
        // 保存用户
        userService.insertSysUser(sysUser);
        // 保存角色
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUser.getUserId()); // 保存用户完之后会把ID返回给用户实体
        userRoleService.insertSysUserRole(sysUserRole);
        // 返回结果
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","添加成功");
        return map;
    }

}
