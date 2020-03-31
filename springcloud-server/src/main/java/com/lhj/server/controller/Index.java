package com.lhj.server.controller;

import com.lhj.server.entity.People;
import com.lhj.server.service.OrderService;
import com.lhj.server.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author lhj
 * @Date 2019/10/21 15:43
 * @Description
 */
@RestController
@RequestMapping("/index")
public class Index {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/test")
    public String test(){
        return "哈哈！";
    }

    @GetMapping("/list")
    public List<People> findAll(){
        return peopleService.list();
    }

    @GetMapping("/getOne")
    public People getOne(@RequestParam(value = "id") String id){
        System.out.println("------------"+id);
        People p = peopleService.getOne(Integer.parseInt(id));
        return p;
    }

    @PostMapping("/del")
    public String del(@RequestParam String id){
        return peopleService.del(Integer.parseInt(id));
    }

    @PostMapping("/save")
    public String save(@RequestBody People people){
        return peopleService.add(people);
    }

    @PostMapping("/getPage")
    public Map<String,Object> getPage(@RequestBody Map<String,String> params){

        String offset=params.get("page");
        String limit=params.get("rows");
        int size=Integer.valueOf(limit);
        int p=Integer.valueOf(offset);
        System.out.println("page:"+offset);
        System.out.println("row:"+limit);
        Pageable pageable=PageRequest.of(p-1,size,new Sort(Sort.Direction.DESC,"name"));
        Page<People> page = peopleService.page(pageable, params);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("total",page.getTotalElements());
        map.put("rows",page.getContent());
        return map;
    }


    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public String createOrder(@RequestParam(name = "id") int id){
        System.out.println(id);
        return orderService.createWrongOrder(id);
    }

    @PostMapping(value = "/order1")
    public String createOptimisticOrder(@RequestParam(name = "id") int id){
        System.out.println(id);
        return orderService.createOptimisticOrder(id);
    }

    @PostMapping(value = "/order2")
    public String createPessimisticOrder(@RequestParam(name = "id") int id){
        System.out.println(id);
        return orderService.createPessimisticOrder(id);
    }

    @PostMapping(value = "/getRedisData")
    public String getRedisData(@RequestParam(name = "key") String key){

        String result = (String) redisTemplate.opsForValue().get(key);
        return result;
    }

    @PostMapping(value = "/getRedisDataList")
    public String getRedisDataList(@RequestParam(name = "key") String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        List list = redisTemplate.opsForList().range(key, 0, -1);
        System.out.println(list.toString());
        String result=list.toString();
        return result;
    }

    @PostMapping(value = "/getRedisDataSet")
    public String getRedisDataSet(@RequestParam(name = "key") String key){

        Map<String,String> map=new HashMap<String, String>();
        map.put("name","locy");
        map.put("age","25");
        map.put("sex","girl");


        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForHash().putAll(key,map);

        Map entries = redisTemplate.opsForHash().entries(key);

        System.out.println(entries.toString());

        String result=entries.toString();
        return result;
    }

    @PostMapping(value = "setRedisValue")
    public String setRedisValue(@RequestParam(name = "value") String value){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.opsForValue().set(value,value+"321");
        return "ok";
    }
}
