package com.coody.springbootaop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AspectController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-24 17:44
 */
@Slf4j
@RestController
@RequestMapping("/aop")
public class AspectController {

    @GetMapping("/getMapping")
    public String testGetMapping() {
        log.info("===== testGetMapping =====");
        return "success";
    }

    @GetMapping("/{name}")
    public String testAop(@PathVariable String name) {
        return "Hello " + name;
    }
}
