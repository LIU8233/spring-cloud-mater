package com.lhj.server.service;

import com.lhj.server.dao.PeopleRepositry;
import com.lhj.server.entity.People;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author lhj
 * @Date 2019/10/22 16:23
 * @Description
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepositry peopleRepositry;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<People> list() {
        return peopleRepositry.findAll();
    }

    public People getOne(int id) {
        System.out.println("==="+id);

        People p = peopleRepositry.getOne(id);
        System.out.println(p.getName());
        return p;
    }

    public String add(People people) {
        try {
            peopleRepositry.saveAndFlush(people);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "No";
        }
    }

    public String del(int id) {
        try {
            peopleRepositry.deleteById(id);
            return "ok";
        }catch (Exception e){
            e.printStackTrace();
            return "fault";
        }
    }

    public Page<People> page(Pageable pageable, Map<String, String> params) {

        final String name=params.get("name");
        Specification<People> specification=new Specification<People>() {
            public Predicate toPredicate(Root<People> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicateList=new ArrayList<Predicate>();

                if (StringUtils.isNotBlank(name)){
                    predicateList.add(cb.like(root.<String>get("name"),"%"+name+"%"));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
        return peopleRepositry.findAll(specification,pageable);
    }
}
