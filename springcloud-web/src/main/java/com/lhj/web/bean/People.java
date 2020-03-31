package com.lhj.web.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * @Author lhj
 * @Date 2019/10/22 16:33
 * @Description
 */
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
public class People   {


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
