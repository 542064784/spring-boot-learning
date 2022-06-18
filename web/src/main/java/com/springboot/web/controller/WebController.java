package com.springboot.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen qi hui
 * @date 2022/06/17
 */
@RestController
@Slf4j
@RequestMapping("/web")
public class WebController {

    @GetMapping("/hello")
    public String web(final String name) {
        return "hello " + name;
    }


}
