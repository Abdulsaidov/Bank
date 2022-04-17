package com.banksystem.core.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//todo: need remove
@RestController("/v1/test")
public class TestController {

    @GetMapping()
    public String test() {
        return "test";
    }

}
