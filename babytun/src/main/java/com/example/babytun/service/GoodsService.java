package com.example.babytun.service;

import com.example.babytun.dao.GoodsCoverDAO;
import com.example.babytun.dao.GoodsDAO;
import com.example.babytun.dao.GoodsDetailDAO;
import com.example.babytun.dao.GoodsParamDAO;
import com.example.babytun.entity.Goods;
import com.example.babytun.entity.GoodsCover;
import com.example.babytun.entity.GoodsDetail;
import com.example.babytun.entity.GoodsParam;
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

    /**
     * 根据商品id查询商品信息
     * view->controller->service->dao
     * @param goodsId
     * @return
     */
    public Goods getGoods(Long goodsId) {
        return goodsDAO.findById(goodsId);
    }

    public List<GoodsCover> getGoodsCovers(Long goodsId) {
        return goodsCoverDAO.findByGoodsId(goodsId);
    }
    public List<GoodsDetail> getGoodsDetails(Long goodsId) {
        return goodsDetailDAO.findByGoodsId(goodsId);
    }
    public List<GoodsParam> getGoodsParams(Long goodsId) {
        return goodsParamDAO.findByGoodsId(goodsId);
    }
}
