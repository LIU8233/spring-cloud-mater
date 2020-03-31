package com.lhj.server.dao;

import com.lhj.server.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author lhj
 * @Date 2019/10/22 16:18
 * @Description
 */
@Repository
public interface PeopleRepositry  extends JpaRepository<People,Integer>, JpaSpecificationExecutor<People> {
}
