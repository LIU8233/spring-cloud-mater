package com.lhj.web.client;

import com.lhj.web.bean.People;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author lhj
 * @Date 2020/3/10 17:55
 * @Description
 */
@Component
public class HystrixTest implements TestClient{
    public String test(HttpServletResponse response) {
        int status = response.getStatus();
        System.out.println(status);
        return "request failed"+status;
    }

    public List<People> list() {
        return null;
    }

    public People getOne(String id) {
        return null;
    }

    public String save(People people) {
        return null;
    }

    public String del(String id) {
        return null;
    }

    public Map<String, Object> getPage(Map<String, Object> params) {
        return null;
    }

    public String createOrder(int id) {
        return "400";
    }

    public String createOptimisticOrder(int id) {

        return "500";
    }

    public String createPessimisticOrder(int id) {
        return "500";
    }
}
