package com.example.demo.controller;

import com.example.demo.bean.User;
import com.example.demo.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    //    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView register(HttpServletRequest request,
//                                 @RequestParam("password") String username, String password,
//                                 @RequestParam("repassword") String rePassword,
//                                 @RequestParam("wxname") String wxname,
//                                 @RequestParam("email") String email) {
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request,
                                 @RequestParam Map<String, Object> params) {

        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String email = (String) params.get("email");
        String wxname = (String) params.get("wxname");
        String rePassword = (String) params.get("repassword");

        ModelAndView modelAndView = new ModelAndView("redirect:/login.jsp");
        User user = new User(null, username, password, wxname, email);
        if (user.getPassword().equals(rePassword)) {
            int count = iUserService.selectByUsernameCount(user.getUsername());
            if (count == 0) {
                user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
                int i = iUserService.addUser(user);
                if (i > 0) {
                    modelAndView.addObject("msg", "注册成功");
                } else {
                    modelAndView.addObject("msg", "注册失败");
                }
            }
        }
        return modelAndView;
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/verification")
    public ModelAndView login(HttpServletRequest request, String username,
                              String password,
                              @RequestParam(defaultValue = "0000") String verifyCode, Model model) {

        ModelAndView modelAndView = new ModelAndView();
        String msg = "";
        HttpSession session = request.getSession();
        String sessionVerifyCode = "0000";
        if (sessionVerifyCode != null && sessionVerifyCode.equals(verifyCode)) {
            session.setAttribute("verifyCode", DigestUtils.md5DigestAsHex((Math.random() + "").getBytes(StandardCharsets.UTF_8)));
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            if (subject.isAuthenticated()) {
                subject.logout();
            }

            try {
                subject.login(token);
                User user = iUserService.selectByUsername(username);
                session.setAttribute("UserName", username);
                session.setAttribute("loginEntity", user);
                session.setAttribute("loginFlag", true);
                String cotroUrl = (String) session.getAttribute("Referer");
                if (cotroUrl != null && "".equals(cotroUrl)) {
                    String temp = cotroUrl.substring(cotroUrl.lastIndexOf("/"));
                    modelAndView.setViewName("redirect:/" + temp);
                } else {
                    modelAndView.setViewName("redirect:/index.jsp");
                }
            } catch (IncorrectCredentialsException e) {
                msg = "登录密码错误.Password for account" + token.getPrincipal() + "was incorrect";
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (ExcessiveAttemptsException e) {
                msg = "登录次数过多";
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (LockedAccountException e) {
                msg = "账号已被锁定" + token.getPrincipal() + "was lock";
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (DisabledAccountException e) {
                msg = "登录已被禁用.The account for username" + token.getPrincipal() + "was disable";
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (ExpiredCredentialsException e) {
                msg = "账号已过期.the account for username" + token.getPrincipal() + "was expired";
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (UnknownAccountException e) {
                msg = "账号不存在.This is no user with username of " + token.getPrincipal();
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            } catch (UnauthorizedException e) {
                msg = "你没有得到授权!" + e.getMessage();
                model.addAttribute("message", msg);
                System.out.println(msg);
                modelAndView.setViewName("redirect:/login.jsp");
            }
        } else {
            modelAndView.addObject("msg", "验证码错误");
            modelAndView.setViewName("redirect:/login.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/verification2")
    public ModelAndView login2(HttpServletRequest request, String username,
                         String password,
                         @RequestParam(defaultValue = "0000") String verifyCode,
                         Model model) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8)));
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session =  request.getSession();
        String msg = "";
        try {
            subject.login(token);
            modelAndView.setViewName("redirect:/index.jsp");
            return modelAndView;
        } catch (UnknownAccountException e) {
//            token.getPrincipal() 拿到用户输入错误的用户名
//            msg = "账号不存在" + token.getPrincipal();
            msg = "账号不存在";
//            model.addAttribute("message", msg);
            modelAndView.addObject("message", msg);
            System.out.println(msg);
        } catch (IncorrectCredentialsException e) {
            msg = "登录密码错误";
//            model.addAttribute("message", msg);
            modelAndView.addObject("message", msg);
        }
        modelAndView.setViewName("redirect:/login.jsp");
        return modelAndView;
    }
}