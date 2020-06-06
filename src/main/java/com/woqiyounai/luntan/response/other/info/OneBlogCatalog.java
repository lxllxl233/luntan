package com.woqiyounai.luntan.response.other.info;

import com.woqiyounai.luntan.entity.TbBlogCatalogV1;
import com.woqiyounai.luntan.entity.TbBlogCatalogV2;

import java.io.Serializable;
import java.util.List;

public class OneBlogCatalog implements Serializable {
    private TbBlogCatalogV1 value;
    private List<TbBlogCatalogV2> option;
    public OneBlogCatalog() {
    }

    public OneBlogCatalog(TbBlogCatalogV1 tbBlogCatalogV1, List<TbBlogCatalogV2> tbBlogCatalogV2List) {
        this.value = tbBlogCatalogV1;
        this.option = tbBlogCatalogV2List;
    }

    public TbBlogCatalogV1 getValue() {
        return value;
    }

    public void setValue(TbBlogCatalogV1 value) {
        this.value = value;
    }

    public List<TbBlogCatalogV2> getOption() {
        return option;
    }

    public void setOption(List<TbBlogCatalogV2> option) {
        this.option = option;
    }
}
