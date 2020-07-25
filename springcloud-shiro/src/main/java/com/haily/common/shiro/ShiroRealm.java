package com.haily.common.shiro;

import com.haily.domain.SysMenu;
import com.haily.domain.SysRole;
import com.haily.domain.SysUser;
import com.haily.service.ISysMenuService;
import com.haily.service.ISysRoleService;
import com.haily.service.ISysUserService;
import com.haily.util.AssertUtil;
import com.haily.util.ShiroUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;

public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private ISysRoleService sysRoleService;
    @Autowired
    private ISysMenuService sysMenuService;

    private static final Logger log = LoggerFactory.getLogger(ShiroRealm.class);

    /**
     * 授权权限
     * 用户进行权限验证时候Shiro会去缓存中找,如果查不到数据,会执行这个方法去查权限,并放入缓存中
     * @Author Sans
     * @CreateTime 2019/6/12 11:44
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("ShiroRealm - doGetAuthorizationInfo方法=======================================");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SysUser sysUser = (SysUser) principals.getPrimaryPrincipal();
        //获取用户ID
        Long userId = sysUser.getUserId();
        //这里可以进行授权和处理
        HashSet<String> rolesSet = new HashSet<>();
        HashSet<String> permsSet = new HashSet<>();
        //查询角色和权限(这里根据业务自行查询)
        List<SysRole> sysRoleList = sysRoleService.selectSysRoleByuserId(userId);
        for (SysRole sysRole : sysRoleList) {
            rolesSet.add(sysRole.getRoleName());
            List<SysMenu> sysMenuList = sysMenuService.selectSysMenuByRoleId(sysRole.getRoleId());
            for (SysMenu sysMenu : sysMenuList) {
                permsSet.add(sysMenu.getPerms());
            }
        }
        //将查到的权限和角色分别传入authorizationInfo中
        authorizationInfo.setStringPermissions(permsSet);
        authorizationInfo.setRoles(rolesSet);
        return authorizationInfo;
    }

    /**
     *  身份认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.debug("ShiroRealm - doGetAuthorizationInfo方法=======================================");
        //获取用户输入的账号
        String username = (String) token.getPrincipal();
        //通过username从数据库中查找usre对象 如果找到进行验证
        //实际项目中 这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制 2分钟内不会重复执行该方法
        SysUser user = SysUser.builder().username(username).build();
        List<SysUser> sysUsers = sysUserService.selectSysUserList(user);
        //判断账号是否存在
        Assert.notEmpty(sysUsers,"用户不存在");
        SysUser sysUser = sysUsers.get(0);
        //判断账号是否被冻结
        Assert.isTrue(!AssertUtil.isEmpty2(sysUser.getState(),"PROHIBIT"),"账号已经被冻结");
        //进行验证
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                sysUser,                                   //用户名
                sysUser.getPassword(),                     //密码
                ByteSource.Util.bytes(sysUser.getSalt()),  //设置盐值
                getName()
        );
        //验证成功开始踢人（清除缓存和session）
        ShiroUtils.deleteCache(username,true);
        return authenticationInfo;
    }
}
