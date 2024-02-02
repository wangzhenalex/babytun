package com.example.babytun.service;

import com.example.babytun.dao.*;
import com.example.babytun.entity.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsService {
    @Resource
    private GoodsDAO goodsDAO;

    @Resource
    private GoodsCoverDAO goodsCoverDAO;
    @Resource
    private GoodsDetailDAO goodsDetailDAO;
    @Resource
    private GoodsParamDAO goodsParamDAO;
    @Resource
    private EvaluateDAO evaluateDAO;

    /**
     * 根据商品id查询商品信息
     * view->controller->service->dao
     * @param goodsId
     * @return
     */
    @Cacheable(cacheNames = "goods", key = "#goodsId")
    public Goods getGoods(Long goodsId) {
        return goodsDAO.findById(goodsId);
    }
    public List<Goods> findAll() {
        return goodsDAO.findAll();
    }

    @Cacheable(cacheNames = "covers", key = "#goodsId")
    public List<GoodsCover> getGoodsCovers(Long goodsId) {
        return goodsCoverDAO.findByGoodsId(goodsId);
    }
    @Cacheable(cacheNames = "details", key = "#goodsId")
    public List<GoodsDetail> getGoodsDetails(Long goodsId) {
        return goodsDetailDAO.findByGoodsId(goodsId);
    }

    @Cacheable(cacheNames = "params", key = "#goodsId")
    public List<GoodsParam> getGoodsParams(Long goodsId) {
        return goodsParamDAO.findByGoodsId(goodsId);
    }

    @Cacheable(cacheNames = "evaluates", key = "#goodsId")
    public List<Evaluate> getEvaluates(Long goodsId) {
        return evaluateDAO.findByGoodsId(goodsId);
    }
}
