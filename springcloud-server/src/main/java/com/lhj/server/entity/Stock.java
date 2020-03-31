package com.lhj.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author lhj
 * @Date 2020/3/28 16:35
 * @Description
 */
@Table(name = "stock")
@Entity
@NamedQuery(name = "stock.findall",query = "select s from Stock s")
public class Stock implements Serializable {

    private static final long serialVersionUID = -8761754265297351307L;
    @Id
    private int id;
    private String name;
    private int count;
    private int sale;
    private int version;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
