package com.example.demo.realm;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        // 设置角色
        HashSet<Role> roles = new HashSet<>();
//        roles.add(user)

        // 设置权限

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.selectByUsername(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
        }
        return null;
    }
}
