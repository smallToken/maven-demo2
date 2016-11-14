package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entities.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/13
 * Time:17:22
 */


/**
 * spring 和junit 的整合
 * spring-test junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入DAO依赖
    @Resource
    private SeckillDao seckillDao;
    @Test
    public void reduceNumber() throws Exception {
       int count = seckillDao.reduceNumber(1000,new Date());
        System.out.println(count);


    }

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        Seckill seckill =seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);


    }

    @Test
    public void queryAll() throws Exception {

        List<Seckill> list = seckillDao.queryAll(0,100);
        for (Seckill seckill : list) {
            System.out.println(seckill);

        }

    }

}