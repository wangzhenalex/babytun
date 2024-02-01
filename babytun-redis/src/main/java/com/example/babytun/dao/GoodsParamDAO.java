package com.example.babytun.dao;

import com.example.babytun.entity.GoodsParam;

import java.util.List;

public interface GoodsParamDAO {
    List<GoodsParam> findByGoodsId(Long goodsId);
}
