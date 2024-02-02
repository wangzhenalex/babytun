package com.example.babytun.dao;

import com.example.babytun.entity.Evaluate;

import java.util.List;

public interface EvaluateDAO {
    public List<Evaluate> findByGoodsId(Long goodsId);
}
