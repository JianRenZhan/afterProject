package com.haily.common.config;


import com.haily.common.shiro.ShiroRealm;
import com.haily.common.shiro.ShiroSessionIdGenerator;
import com.haily.common.shiro.ShiroSessionManager;
import com.haily.util.SHA256Util;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {
    private final String CACHE_KEY = "shiro:cache:";
    private final String SESSION_KEY = "shiro:session:";

    //redis 配置
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;
//    @Value("${spring.redis.password}")
//    private String password;

    /**
     *  开启Shiro-apo注解支持
     * @Attention 使用代理方式所以需要开启代码支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     *  shiro基础配置
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        //注意过滤器配置顺序不能颠倒
        //配置过滤：不会被拦截的链接
        linkedHashMap.put("/static/**","anon");
        linkedHashMap.put("/userLogin/**","anon");
        linkedHashMap.put("/**","authc");
        // 配置shiro 默认登录界面地址,前后端分离中登录界面跳转应由前端路由控制，后台仅返回json数据
        shiroFilterFactoryBean.setLoginUrl("/client/userLogin/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(linkedHashMap);
        return shiroFilterFactoryBean;
    }


    /**
     *  安全管理器
     */
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //自定义Session管理
        securityManager.setSessionManager(sessionManager());
        //自定义Cache实现
        securityManager.setCacheManager(cacheManager());
        //自定义Realm验证
        securityManager.setRealm(shiroRealm());
        return securityManager;
    }

    /**
     *   身份验证器
     */
    @Bean
    public ShiroRealm shiroRealm(){
        ShiroRealm shiroRealm = new ShiroRealm();
        shiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return shiroRealm;
    }

    /**
     *  凭证匹配器
     *  将密码校验交给Shiro的SimpleAuthenticationInfo进行处理，在这里做匹配配置
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用SHA256算法
        hashedCredentialsMatcher.setHashAlgorithmName(SHA256Util.HASH_ALGORIHM_NAME);
        //散列的次数，比如散列两次，相当于 MD5(md5(""))
        hashedCredentialsMatcher.setHashIterations(SHA256Util.HASH_ITERATIONS);
        return hashedCredentialsMatcher;
    }

    /**
     *  配置Redis管理器
     */
    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setTimeout(timeout);
//        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     *  配置Cache管理器
     */
    @Bean
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        redisCacheManager.setKeyPrefix(CACHE_KEY);
        //配置缓存的话要求放在session里面的实体类必须有个id标识
        redisCacheManager.setPrincipalIdFieldName("userId");
        return redisCacheManager;
    }

    /**
     *  SessionID 生成器
     */
    @Bean
    public ShiroSessionIdGenerator sessionIdGenerator(){
        return new ShiroSessionIdGenerator();
    }

    /**
     *  配置RedisSessionDao
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(){
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        redisSessionDAO.setKeyPrefix(SESSION_KEY);
        redisSessionDAO.setExpire(timeout);
        return redisSessionDAO;
    }

    /**
     *  配置session管理器
     */
    @Bean
    public SessionManager sessionManager(){
        ShiroSessionManager shiroSessionManager = new ShiroSessionManager();
        shiroSessionManager.setSessionDAO(redisSessionDAO());
        return shiroSessionManager;
    }
}
