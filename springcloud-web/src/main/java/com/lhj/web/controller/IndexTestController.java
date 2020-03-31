package com.lhj.web.controller;

import com.google.common.util.concurrent.RateLimiter;
import com.lhj.web.bean.People;
import com.lhj.web.client.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author lhj
 * @Date 2019/10/21 15:51
 * @Description
 */
@RestController
@RequestMapping("/springcloud")
public class IndexTestController {


    @Autowired
    private TestClient testClient;


    @GetMapping("/web")
    public String test(HttpServletResponse response){
        System.out.println("------------------");
        //return indexClient.test();
        return testClient.test(response);
    }

    @GetMapping("/list")
    public List<People> list(){
        return testClient.list();
    }

    @GetMapping("/getOne")
    public People getOne(@RequestParam String id){
        System.out.println(id+"---");

        return testClient.getOne(id);
    }

    @PostMapping("/del")
    public String del(@RequestParam String id){
        return testClient.del(id);
    }

    @PostMapping("/save")
    public String save(@RequestBody People people){
        System.out.println(people.getName());
        return testClient.save(people);
    }

    @PostMapping("/page")
    public Map<String,Object> page(@RequestBody Map<String,Object> params){

        return testClient.getPage(params);
    }

    @PostMapping(value = "/create/{id}")
    public String createWrongOrder(@PathVariable int id){
        return testClient.createOrder(id)+"";
    }

    /**
     * @Author lhj
     * @Description //TODO 乐观锁+版本号
     * @Date 21:33 2020/3/28
     * @Param [id]
     * @return java.lang.String
     **/
    @PostMapping(value = "/order/{id}")
    public String createOptimisticOrder(@PathVariable int id){
        return testClient.createOptimisticOrder(id);
    }

    private RateLimiter rateLimiter=RateLimiter.create(100);

    /**
     * @Author lhj
     * @Description //TODO 令牌桶限流+乐观锁
     * @Date 21:32 2020/3/28
     * @Param [id]
     * @return java.lang.String
     **/
    @PostMapping(value = "/lingpai/{id}")
    public String lingpai(@PathVariable int id){

//        System.out.println("等待时间："+rateLimiter.acquire());

        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)){
            System.out.println("你被限流了！");
            return "购买失败，库存不足";
        }
        return testClient.createOptimisticOrder(id);
    }

    /**
     * @Author lhj
     * @Description //TODO 事务行锁，悲观锁
     * @Date 21:32 2020/3/28
     * @Param [id]
     * @return java.lang.String
     **/
    @PostMapping(value = "/order2/{id}")
    public String createPessimisticOrder(@PathVariable int id){
        return testClient.createPessimisticOrder(id);
    }

}
