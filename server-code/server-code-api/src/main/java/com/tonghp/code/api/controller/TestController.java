package com.tonghp.code.api.controller;

import com.tonghp.code.api.exception.ApiException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Tonghp
 * @CreateDate: 2020/04/24 10:45
 * @Version: 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/id")
    public Integer getId(@RequestParam Integer id) {
        if (id == 0) {
            throw new ApiException(1001L, "xx");
        }
        return id / 0;
    }
}