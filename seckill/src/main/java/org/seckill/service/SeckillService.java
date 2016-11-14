package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entities.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/13
 * Time:20:16
 * 站在使用者的角度
 * 三个方面：方法定义粒度    参数（越简练越好） 返回的类型（友好）
 */


public interface SeckillService {

    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    /**
     * @Author:Yuan XiaoLei
     * @Date:2016/11/13
     * @Time:20:22
     * 输出秒杀url  否则输出开始时间
     */
    Exposer exportSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,SeckillCloseException,RepeatKillException;

}
