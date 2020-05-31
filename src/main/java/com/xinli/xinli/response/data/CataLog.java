package com.xinli.xinli.response.data;

import com.xinli.xinli.bean.TbCatalogV1Entity;
import com.xinli.xinli.bean.TbCatalogV2Entity;

import java.io.Serializable;
import java.util.List;

public class CataLog implements Serializable {
    private TbCatalogV1Entity v1;
    private List<TbCatalogV2Entity> v2List;

    public CataLog( ) {
    }

    public CataLog(TbCatalogV1Entity v1, List<TbCatalogV2Entity> v2List) {
        this.v1 = v1;
        this.v2List = v2List;
    }

    public TbCatalogV1Entity getV1() {
        return v1;
    }

    public void setV1(TbCatalogV1Entity v1) {
        this.v1 = v1;
    }

    public List<TbCatalogV2Entity> getV2List() {
        return v2List;
    }

    public void setV2List(List<TbCatalogV2Entity> v2List) {
        this.v2List = v2List;
    }

    @Override
    public String toString() {
        return "CataLog{" +
                "v1=" + v1 +
                ", v2List=" + v2List +
                '}';
    }
}
