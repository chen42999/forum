package com.example.demo.config;

import com.example.demo.realm.UserRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);

        // 权限认证
        HashMap<String, String> map = new HashMap<>();
//        map.put("/jsp/")

        //需要登录的接口，如果访问某个接口，需要登录却没登录，则调用此接口(如果不是前后端分离，则跳转页面)
        factoryBean.setLoginUrl("/login");

        //登录成功，跳转url，如果前后端分离，则没这个调用
        factoryBean.setSuccessUrl("/");

        //没有权限，未授权就会调用此方法， 先验证登录-》再验证是否有权限
        factoryBean.setUnauthorizedUrl("/pub/not_permit");

        //拦截器路经 坑一 部分路径无法进行拦截，时有时无，必须要有序的map  LinkedHasMap
        Map<String ,String > filterChainDefinitionMap = new LinkedHashMap<>();

        //退出过滤器
        filterChainDefinitionMap.put("/logout","logout");

        //匿名可以访问，也是就游客模式
        filterChainDefinitionMap.put("/index","anon");
        filterChainDefinitionMap.put("/login","anon");

        //登录用户才可以访问
        filterChainDefinitionMap.put("/jsp/mainContent","authc");

        //管理员角色才可以访问
        filterChainDefinitionMap.put("/admin/**","roles[admin]");

        //有编辑权限才可以访问
        filterChainDefinitionMap.put("/video/update","perms[video_update]");
        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
