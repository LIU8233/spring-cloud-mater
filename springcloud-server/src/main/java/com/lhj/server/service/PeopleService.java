package com.lhj.server.service;

import com.lhj.server.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @Author lhj
 * @Date 2019/10/22 16:22
 * @Description
 */
public interface PeopleService {

    List<People> list();
    People getOne(int id);
    String add(People people);
    String del(int id);
    Page<People> page(Pageable pageable, Map<String,String> params);
}
