package org.example.seckillsample.sevice;

import org.example.seckillsample.dao.SKDao;
import org.springframework.stereotype.Service;

@Service
public class SKService {
    private SKDao dao = new SKDao();
    public void seckill(){
        Integer count = dao.getCount();
        if(count>0){
            System.out.println("恭喜你，秒杀成功");
            dao.updateCount(count-1);
        }else{
            System.out.println("秒杀失败");
        }
    }
}
