package com.xiaobin.core.service;

import com.xiaobin.core.bean.BaseDict;

import java.util.List;


public interface SystemService {

    //根据类型查询数据字典
    public List<BaseDict> findBaseDictListByType(String typecode);

}
