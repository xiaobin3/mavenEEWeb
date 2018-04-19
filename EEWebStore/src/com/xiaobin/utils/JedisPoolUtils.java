package com.xiaobin.utils;

import com.google.gson.Gson;
import com.xiaobin.domain.Category;
import com.xiaobin.service.ProductService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class JedisPoolUtils {

    private static JedisPool pool = null;

    static {

        //加载配置文件
        InputStream in = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));//最大闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));//最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));//最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
    }

    //获得jedis资源的方法
    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = getJedis();
        ProductService service = new ProductService();
        String categoryListJson = jedis.get("categoryListJson");
        //2、判断categoryListJson是否为空
        if (categoryListJson == null) {
            System.out.println("缓存没有数据 查询数据库");
            //准备分类数据
            List<Category> categoryList = service.findAllCategory();
            Gson gson = new Gson();
            categoryListJson = gson.toJson(categoryList);
            System.out.println("***"+categoryListJson);
            jedis.set("categoryListJson", categoryListJson);
        }
        System.out.println(jedis.get("categoryListJson")+"***");
        System.out.println(jedis.get("myKey")+"***");
        // 获取数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator() ;
        while(it.hasNext()){
            String key = it.next();
            System.out.println(key);
        }
    }


}
