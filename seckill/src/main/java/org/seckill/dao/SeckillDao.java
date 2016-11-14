package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entities.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/13
 * Time:15:25
 */
public interface SeckillDao {

    /**
     * @Author:Yuan XiaoLei
     * @Date:2016/11/13
     * @Time:15:28
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
    Seckill queryById(long seckillId);
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
