package com.example.babytun.controller;

import com.example.babytun.entity.Goods;
import com.example.babytun.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    @GetMapping("/goods")
    public ModelAndView showGoods(Long gid) {
        logger.info("gid:" + gid);
        ModelAndView mav = new ModelAndView("goods");
        Goods goods = goodsService.getGoods(gid);
        mav.addObject("goods", goods);
        mav.addObject("covers", goodsService.getGoodsCovers(gid));
        mav.addObject("details", goodsService.getGoodsDetails(gid));
        mav.addObject("params", goodsService.getGoodsParams(gid));
        return mav;
    }
}
