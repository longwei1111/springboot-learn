package com.coody.springboot04.controller;

import com.coody.springboot04.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname TestController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-22 19:22
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String testGet() {
        return "success";
    }

    @GetMapping("/user/{id}")
    public String testPathVariable(@PathVariable Integer id) {
        log.info("获取到的id={}", id);
        return "success";
    }

    @GetMapping("/user/{idd}/{name}")
    public String testPathVariable1(@PathVariable(value = "idd") Integer id, @PathVariable String name) {
        log.info("获取到的id={}, name={}", id, name);
        return "success";
    }

    @GetMapping("/user")
    public String testRequestParam(@RequestParam(value = "idd", required = false) Integer id) {
        log.info("获取到的id={}", id);
        return "success";
    }

    @PostMapping("/form1")
    public String testForm1(@RequestParam String username, @RequestParam String password) {
        log.info("获取到的username={},password={}", username, password);
        return "success";
    }

    @PostMapping("/form2")
    public String testForm2(User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return "success";
    }

    @PostMapping("/userInfo")
    public String testRequestBody(@RequestBody User user) {
        log.info("获取到的username={},password={}", user.getUsername(), user.getPassword());
        return "success";
    }

}
