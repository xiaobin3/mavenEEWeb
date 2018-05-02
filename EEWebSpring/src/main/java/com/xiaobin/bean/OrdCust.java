package com.xiaobin.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 14:14 2018/4/20
 * @Modified by:
 */
@Component("OrdCust")
//相当于applicationContext.xml中增加配置：
//<bean name="OrdCust" class="com.xiaobin.bean.OrdCust">
@Scope(scopeName = "prototype")//指定对象的作用域范围
public class OrdCust {

    @Value("277777777")//属性注入
    private String ordCode;
    private Long ordId;
    private List<?> ordList;
    @Autowired //自动装配
    //问题:如果匹配多个类型一致的对象.将无法选择具体注入哪一个对象.
//    @Qualifier("Cars")//使用@Qualifier注解告诉spring容器自动装配哪个名称的对象

    @Resource(name="Cars")//手动注入,指定注入哪个名称的对象**推荐
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public Long getOrdId() {
        return ordId;
    }

    @Value("277777777")//属性注入
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public List<?> getOrdList() {
        return ordList;
    }

    public void setOrdList(List<?> ordList) {
        this.ordList = ordList;
    }

    @Override
    public String toString() {
        return "OrdCust{" +
                "ordCode='" + ordCode + '\'' +
                ", ordId=" + ordId +
                ", ordList=" + ordList +
                ", car=" + car +
                '}';
    }
}
