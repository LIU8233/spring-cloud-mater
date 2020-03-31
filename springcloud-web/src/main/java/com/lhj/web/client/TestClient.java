package com.lhj.web.client;

import com.lhj.web.bean.People;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author lhj
 * @Date 2019/10/22 15:51
 * @Description
 */
@Component
@FeignClient(name = "springcloud-producer",fallback = HystrixTest.class)
public interface TestClient {

    @GetMapping("/index/test")
    public String test(HttpServletResponse response);

    @GetMapping("index/list")
    public List<People> list();

    @GetMapping("/index/getOne")
    public People getOne(@RequestParam(value = "id") String id);

    @PostMapping("/index/save")
    public String save(@RequestBody People people);

    @PostMapping("/index/del")
    public String del(@RequestParam(value = "id") String id);

    @PostMapping("/index/getPage")
    Map<String,Object> getPage(@RequestBody Map<String,Object> params);

    @PostMapping(value = "/index/order")
    public String createOrder(@RequestParam(name = "id") int id);

    @PostMapping(value = "/index/order1")
    public String createOptimisticOrder(@RequestParam(name = "id") int id);

    @PostMapping(value = "/index/order2")
    public String createPessimisticOrder(@RequestParam(name = "id") int id);

}
