package com.joey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by joey on 2017/7/19.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {
        return "/index";
    }
}
