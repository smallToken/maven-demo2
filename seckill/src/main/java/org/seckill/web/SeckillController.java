package org.seckill.web;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entities.Seckill;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User:YuanXiaolei
 * Date:2016/11/14
 * Time:9:34
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;

    @RequestMapping(value="/list",method= RequestMethod.GET)
    public String list(Model model)
    {
       List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list",list);

        return "list";
    }


    @RequestMapping(value="/{seckillId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckillId") Long seckillId, Model model)
    {
        if(seckillId==null)
            return "redirect:/seckill/list";
        Seckill seckill = seckillService.getById(seckillId);
        if(seckill==null)
            return "forward:/seckill/list";
        model.addAttribute("seckill",seckill);

        return "detail";

    }

    //ajax json
    @RequestMapping(value = "/{seckillId}/exposer",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId){
        SeckillResult<Exposer> result;

        try {
            Exposer exposer=seckillService.exportSeckillUrl(seckillId);
            result=new SeckillResult<Exposer>(true,exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
            result=new SeckillResult<Exposer>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution",method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "killPhone" ,required = false) Long phone )
    {
        if(phone==null)
            return new SeckillResult<SeckillExecution>(false,"未注册");
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution seckillExecution = seckillService.executeSeckill(seckillId,phone,md5);
            return new SeckillResult<SeckillExecution>(true,seckillExecution);

        }
        catch (SeckillCloseException e1){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.END);
           return new SeckillResult<SeckillExecution>(false,seckillExecution);
        }
        catch (RepeatKillException e2){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.REPETE_KILL);
            return new SeckillResult<SeckillExecution>(false,seckillExecution);
        }catch (Exception e){
            SeckillExecution seckillExecution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(false,seckillExecution);
        }


    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long>  time()
    {
        Date date = new Date();
        return new SeckillResult<Long>(true,date.getTime());

    }
}