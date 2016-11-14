package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entities.SuccessKilled;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/13
 * Time:15:30
 */
public interface SuccessKilledDao {

    public int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
    public SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}
