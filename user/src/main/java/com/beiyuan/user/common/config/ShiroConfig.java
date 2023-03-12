package com.beiyuan.user.common.config;

import com.beiyuan.user.common.shiro.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: beiyuan
 * @date: 2023/3/7  16:14
 */
@Configuration
public class ShiroConfig {

    @Autowired
    MyRealm myRealm;
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        //1 创建 defaultWebSecurityManager 对象
        DefaultWebSecurityManager webSecurityManager = new DefaultWebSecurityManager();
        //2 创建加密对象，并设置相关属性
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher("md5");
        matcher.setHashIterations(3);
        myRealm.setCredentialsMatcher(matcher);
        webSecurityManager.setRealm(myRealm);
        return webSecurityManager;

    }

    @Bean
    public DefaultShiroFilterChainDefinition
    shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new
                DefaultShiroFilterChainDefinition();
        //设置不认证可以访问的资源
        //definition.addPathDefinition("/catesharing/user/user/login","anon");
        definition.addPathDefinition("/**","anon");
        //设置需要进行登录认证的拦截范围
        //definition.addPathDefinition("/catesharing/user/user/**","authc");
        return definition;
    }


}
