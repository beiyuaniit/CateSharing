package com.beiyuan.user.common.shiro;

import com.beiyuan.user.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import user.entity.User;

/**
 * @author: beiyuan
 * @date: 2023/3/7  15:43
 */
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String name=token.getPrincipal().toString();
        User user=userService.getByName(name);
        if(user!=null){
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(
                    token.getPrincipal(),
                    user.getPassword(),
            ByteSource.Util.bytes("salt"),
                    token.getPrincipal().toString()
            );
            return authenticationInfo;
        }
        return null;
    }
}
