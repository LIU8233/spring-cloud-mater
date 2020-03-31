package com.lhj.server.service;

import com.lhj.server.dao.OrderRepositry;
import com.lhj.server.dao.StockRepostitry;
import com.lhj.server.entity.Order;
import com.lhj.server.entity.Stock;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @Author lhj
 * @Date 2020/3/28 16:49
 * @Description
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private StockRepostitry repostitry;

    @Autowired
    private OrderRepositry orderRepositry;

    public String createWrongOrder(int sid) {
        //校验库存
        System.out.println("--------------");
        Stock stock = repostitry.getOne(sid);
        if (stock.getSale()<stock.getCount()){
            //扣库存
            stock.setSale(stock.getSale()+1);
            repostitry.saveAndFlush(stock);

            //创建订单
            Order order=new Order();
            order.setName(stock.getName());
            order.setSid(stock.getId());
            order.setCreate_time(new Date());

            orderRepositry.save(order);

            return "下单成功";
        }else {
            return "库存不足";
        }
    }

    public String createOptimisticOrder(int sid) {
        //校验库存
        Stock stock = repostitry.getOne(sid);
        System.out.println(stock.getName());
        if (stock.getSale()<stock.getCount()){
            //扣库存
            int id = repostitry.update(stock.getSale() + 1, stock.getVersion() + 1, stock.getId(), stock.getVersion());
            System.out.println("结果："+id);
            if (id==0){
                logger.info("乐观锁并发更新库存失败");
                return "下单失败";
            }else {
                //创建订单
                Order order=new Order();
                order.setName(stock.getName());
                order.setSid(stock.getId());
                order.setCreate_time(new Date());
                orderRepositry.save(order);
                return "下单成功";
            }
        }else {
            return "库存不足";
        }
    }

    /**
     * @Author lhj
     * @Description //TODO 事务锁
     * @Date 21:46 2020/3/28
     * @Param [sid]
     * @return java.lang.String
     **/
    public String createPessimisticOrder(int sid) {
        //校验库存
        Stock stock = repostitry.findById(sid);
        if (stock.getSale()<stock.getCount()){
            //扣库存
            stock.setSale(stock.getSale()+1);
            repostitry.saveAndFlush(stock);

            //创建订单
            Order order=new Order();
            order.setName(stock.getName());
            order.setSid(stock.getId());
            order.setCreate_time(new Date());

            orderRepositry.save(order);

            return "下单成功";
        }else {
            return "库存不足";
        }

    }
}
