package com.lhj.server.dao;

import com.lhj.server.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author lhj
 * @Date 2020/3/28 17:00
 * @Description
 */
@Repository
public interface OrderRepositry extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
}
