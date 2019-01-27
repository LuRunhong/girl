package com.lew.girl;
/*
* Girl实体类映射到 数据库
* 用于自动创建sql表
* */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity                     //@entity注解 使得可以直接将实体映射到数据库中
public class Girl {

    @Id
    @GeneratedValue         //id自增注解
    private Integer  id;
    private  String cupSize;
    private  Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
