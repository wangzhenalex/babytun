
package com.example.babytun.dao;


import com.example.babytun.entity.GoodsCover;

import java.util.List;

public interface GoodsCoverDAO {
     List<GoodsCover> findByGoodsId(Long goodsId);
}
