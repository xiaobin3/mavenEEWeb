package com.xiaobin.bean;

import java.util.List;

/**
 * @Author: xiaobin3
 * @Description:
 * @Date: Created in 14:14 2018/4/20
 * @Modified by:
 */
public class OrdCust {
    private String ordCode;
    private Long ordId;
    private List<?> ordList;

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode;
    }

    public Long getOrdId() {
        return ordId;
    }

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
                '}';
    }
}
