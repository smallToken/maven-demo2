package org.seckill.service.impl;

import org.seckill.dao.SeckillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entities.Seckill;
import org.seckill.entities.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/13
 * Time:20:39
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillDao seckillDao;
    @Autowired
    private SuccessKilledDao successKilledDao;

    private final String slat ="sssssssss";

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0,4);
    }

    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {

        Seckill seckill = seckillDao.queryById(seckillId);
        if(seckill == null)
            return new Exposer(false,seckillId);
        Date start = seckill.getStartTime();
        Date end = seckill.getEndTime();
        Date now = new Date();
        if(now.getTime()<start.getTime() || end.getTime()<now.getTime())
            return new Exposer(false,seckillId,now.getTime(),start.getTime(),end.getTime());



        return new Exposer(true,getMd5(seckillId),seckillId);
    }

    private String getMd5(long seckillId)
    {
        String base = seckillId+"/"+slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }
    @Transactional
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        if(md5==null|| !md5.equals(getMd5(seckillId)))
            throw new SeckillException("data rewrite");
        try {
            int updateCount = seckillDao.reduceNumber(seckillId,new Date());
            if(updateCount<=0)
                throw new SeckillCloseException("close");
            else
            {
                int insertCount=successKilledDao.insertSuccessKilled(seckillId, userPhone);
                if(insertCount<=0)
                    throw new RepeatKillException("repeate");
                else
                {
                    SuccessKilled successKilled =successKilledDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillExecution(seckillId, SeckillStatEnum.SUCCESS,successKilled);
                }
            }

        }catch (SeckillCloseException e1){
            throw e1;

        }catch (RepeatKillException e2){
            throw e2;

        } catch (Exception e){
            logger.error(e.getMessage(),e);
            throw new SeckillException("inner exception");
        }

    }
}
