package com.lhj.server.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author lhj
 * @Date 2020/3/28 16:56
 * @Description
 */
@Entity
@Table(name = "stock_order")
@NamedQuery(name = "order.all",query = "select o from Order o")
public class Order implements Serializable {

    private static final long serialVersionUID = 1744648198279736706L;
    @Id
    private int id;
    private int sid;
    private String name;
    @Column(name = "create_time")
    private Date create_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
