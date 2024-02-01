package com.example.babytun.dao;

import com.example.babytun.entity.Goods;

import java.util.List;

public interface GoodsDAO {
    Goods findById(Long goodsId);

    List<Goods> findAll();
}
