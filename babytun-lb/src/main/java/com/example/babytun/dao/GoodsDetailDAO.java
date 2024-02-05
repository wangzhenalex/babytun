package com.example.babytun.dao;

import com.example.babytun.entity.GoodsDetail;

import java.util.List;

public interface GoodsDetailDAO {
    List<GoodsDetail> findByGoodsId(Long goodsId);
}
