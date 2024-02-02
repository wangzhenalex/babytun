package org.example.seckillsample.dao;

public class SKDao {
    public static Integer count =10;

    public  Integer getCount() {
        return SKDao.count;
    }

    public void updateCount(Integer count){
        SKDao.count = count;
    }

}
