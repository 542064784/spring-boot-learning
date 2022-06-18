package com.springboot.servletjsp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Chen qi hui
 * @date 2022/06/18
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "user";
    }

}
