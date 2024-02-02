package org.example.seckillsample.controller;

import org.example.seckillsample.sevice.SKService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SKController {
    @Resource
    private SKService service;

    @GetMapping("/seckill")
    @ResponseBody
    public String seckill() {
        service.seckill();
        return "success";
    }
}
