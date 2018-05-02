package com.xiaobin.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 11:03 2018/4/20
 * @Modified by:
 */
public class User {

    private Integer id;
    private String name;
    private Integer age;
    @Qualifier("Cars")
    @Autowired
    private Car car;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    @PostConstruct //对象创建后调用==init-method
    public void init() {
        System.out.println("我是初始化方法！");
    }

    @PreDestroy //在对象销毁的时候调用==destory-method
    public void destory() {
        System.out.println("我是销毁方法！");
    }
}
