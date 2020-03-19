package com.coody.springboot.exception.controller;

import com.coody.springboot.exception.exception.BusinessException;
import com.coody.springboot.exception.result.JsonResult;
import com.coody.springboot.exception.enums.BusinessMsgEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Classname ExceptionController
 * @Description TODO
 * @Author lw
 * @Date 2020-02-24 15:37
 */
@Slf4j
@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @PostMapping("/test")
    public JsonResult test(@RequestParam("name") String name, @RequestParam("pass") String pass) {
        log.info("name={}", name);
        log.info("pass={}", pass);
        return new JsonResult();
    }

    @GetMapping("/testNpe")
    public JsonResult testNullPointerException() {
        String name = null;
        log.info("name长度= {}", name.length());
        return new JsonResult();
    }

    @GetMapping("/business")
    public JsonResult testBusinessException() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            throw new BusinessException(BusinessMsgEnum.UNEXPECTED_EXCEPTION);
        }
        return new JsonResult();
    }
}
