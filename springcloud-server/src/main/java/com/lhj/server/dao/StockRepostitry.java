package com.lhj.server.dao;

import com.lhj.server.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author lhj
 * @Date 2020/3/28 16:39
 * @Description
 */
@Repository
public interface StockRepostitry extends JpaRepository<Stock,Integer>, JpaSpecificationExecutor<Stock> {
    //
    @Modifying
    @Transactional
    @Query("update Stock set sale=?1 ,version=?2 where id=?3 and version=?4")
    public int update(int sale,int v,int id,int version);

    @Query(value = "select * from stock  where id=?1 FOR UPDATE",nativeQuery = true)
    public Stock findById(int id);
}
