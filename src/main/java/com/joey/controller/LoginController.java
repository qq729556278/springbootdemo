package com.joey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by joey on 2017/7/19.
 */
@Controller
@RequestMapping({"/doLogin"})
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public boolean getAll(HttpServletRequest request, String name, String pwd) {
        HttpSession session = request.getSession();
        if (name.equals("admin") && pwd.equals("admin")) {
            session.setAttribute("userSession", name);
            return true;
        }
        return false;
    }

}
