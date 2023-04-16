package com.example.demo.realm;

import com.example.demo.bean.Role;
import com.example.demo.bean.User;
import com.example.demo.bean.UserRole;
import com.example.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        // 设置角色
        Set<String> roles = new HashSet<>();
        List<UserRole> userRoles = userService.selectRoleIdByUserId(user.getLoginId());
        for (UserRole userRole  : userRoles) {
           roles.add(userService.selectRolesByRoleId(userRole.getRoleId()));
        }
        user.setRoles(roles);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);

        // 设置权限
        for (String role : roles) {
            info.addStringPermission(role);
        }

        return info;
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
