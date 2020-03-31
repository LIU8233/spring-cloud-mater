package com.lhj.server.service;

/**
 * @Author lhj
 * @Date 2020/3/28 16:49
 * @Description
 */
public interface OrderService {

    /**
     * 创建订单
     * @param sid
     *  库存ID
     * @return
     *  订单ID
     */
    public String createWrongOrder(int sid);


    /**
     * 创建订单 乐观锁
     * @param sid
     * @return
     * @throws Exception
     */
    public String createOptimisticOrder(int sid);

    /**
     * 创建订单 悲观锁 for update
     * @param sid
     * @return
     * @throws Exception
     */
    public String createPessimisticOrder(int sid);
}
