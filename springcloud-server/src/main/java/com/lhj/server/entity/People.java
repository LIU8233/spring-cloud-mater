package com.lhj.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author lhj
 * @Date 2019/10/22 16:12
 * @Description
 */
@Entity
@Table(name = "people")
@NamedQuery(name = "people.all",query = "select p from People p")
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class People implements Serializable {


    private static final long serialVersionUID = 2265140092446419218L;

    @Id
    private int id;
    private String name;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
