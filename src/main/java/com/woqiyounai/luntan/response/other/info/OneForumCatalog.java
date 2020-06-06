package com.woqiyounai.luntan.response.other.info;

import com.woqiyounai.luntan.entity.TbForumCatalogV1;
import com.woqiyounai.luntan.entity.TbForumCatalogV2;

import java.io.Serializable;
import java.util.List;

public class OneForumCatalog implements Serializable {
    private TbForumCatalogV1 tbForumCatalogV1;
    private List<TbForumCatalogV2> tbForumCatalogV2List;
    public OneForumCatalog() {
    }

    public OneForumCatalog(TbForumCatalogV1 tbForumCatalogV1, List<TbForumCatalogV2> tbForumCatalogV2List) {
        this.tbForumCatalogV1 = tbForumCatalogV1;
        this.tbForumCatalogV2List = tbForumCatalogV2List;
    }

    public TbForumCatalogV1 getTbForumCatalogV1() {
        return tbForumCatalogV1;
    }

    public void setTbForumCatalogV1(TbForumCatalogV1 tbForumCatalogV1) {
        this.tbForumCatalogV1 = tbForumCatalogV1;
    }

    public List<TbForumCatalogV2> getTbForumCatalogV2List() {
        return tbForumCatalogV2List;
    }

    public void setTbForumCatalogV2List(List<TbForumCatalogV2> tbForumCatalogV2List) {
        this.tbForumCatalogV2List = tbForumCatalogV2List;
    }
}
