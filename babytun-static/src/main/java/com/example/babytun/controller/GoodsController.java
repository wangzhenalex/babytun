package com.example.babytun.controller;

import com.example.babytun.entity.Goods;
import com.example.babytun.service.GoodsService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {
    Logger logger = LoggerFactory.getLogger(GoodsController.class);
    @Resource
    private GoodsService goodsService;

    @Resource
    private Configuration freeMarkerConfig;
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

    @GetMapping("/static/{gid}")
    @ResponseBody
    public String doStatic(@PathVariable("gid") Long gid) throws Exception{
        Goods goods = goodsService.getGoods(gid);
        Template template = freeMarkerConfig.getTemplate("goods.ftl");
        Map param = new HashMap();
        param.put("goods", goods);
        param.put("covers",  goodsService.getGoodsCovers(gid));
        param.put("details", goodsService.getGoodsDetails(gid));
        param.put("params", goodsService.getGoodsParams(gid));
        File targetFile = new File("/Users/zhenwang/Documents/files/babytun/" + gid + ".html");
        FileWriter out = new FileWriter(targetFile);
        template.process(param, out);
        out.close();
        return targetFile.getAbsolutePath();
    }

    @GetMapping("/static_all")
    public void staticAll() throws Exception{
        List<Goods> all = goodsService.findAll();
        if (CollectionUtils.isEmpty(all)) {
            return;
        }
        for (Goods goods : all) {
            doStatic(goods.getGoodsId());
        }
    }
}
