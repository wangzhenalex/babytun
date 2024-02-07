package com.example.babytun.controller;

import com.example.babytun.entity.Goods;
import com.example.babytun.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    @Value("${server.port}")
    private String port;

    @GetMapping("/goods-{gid}.html")
    public ModelAndView showGoods(@PathVariable("gid") Long gid) {
        logger.info("port:" + port);
        ModelAndView mav = new ModelAndView("goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.getGoodsCovers(gid));
        mav.addObject("details", goodsService.getGoodsDetails(gid));
        mav.addObject("params", goodsService.getGoodsParams(gid));
        return mav;
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(String u , WebRequest request){
        request.setAttribute("user" , u , WebRequest.SCOPE_SESSION);
        return "port:" + port +",login success";
    }
    @GetMapping("/check")
    @ResponseBody
    public String checkUser(WebRequest request){
        String user = (String)request.getAttribute("user", WebRequest.SCOPE_SESSION);
        if(user != null){
            return "port:" + port + ",user=" + user;
        }else{
            return "port:" + port + ", redirect to login!";
        }
    }
}
