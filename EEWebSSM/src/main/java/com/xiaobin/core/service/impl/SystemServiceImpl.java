package com.xiaobin.core.service.impl;

import com.xiaobin.core.bean.BaseDict;
import com.xiaobin.core.dao.BaseDictDao;
import com.xiaobin.core.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 基础信息数据字典
 *
 * @author lx
 */

@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    private BaseDictDao baseDictDao;

    //根据类型编号查询数据字典
    public List<BaseDict> findBaseDictListByType(String typecode) {
        return baseDictDao.selectByTypecode(typecode);
    }

}
