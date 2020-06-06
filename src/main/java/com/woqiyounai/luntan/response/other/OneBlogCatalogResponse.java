package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbBlogCatalogV1;
import com.woqiyounai.luntan.entity.TbBlogCatalogV2;
import com.woqiyounai.luntan.response.other.info.OneBlogCatalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OneBlogCatalogResponse implements Serializable {
    private List<OneBlogCatalog> blogCatalogList;
    public OneBlogCatalogResponse() {
    }

    public OneBlogCatalogResponse(List<OneBlogCatalog> blogCatalogList) {
        this.blogCatalogList = blogCatalogList;
    }

    public OneBlogCatalogResponse(List<TbBlogCatalogV1> tbBlogCatalogV1List, Map<Integer, List<TbBlogCatalogV2>> map) {
        blogCatalogList = new ArrayList<>();
        tbBlogCatalogV1List.forEach(e->{
            blogCatalogList.add(new OneBlogCatalog(e,map.get(e.getId())));
        });
    }

    public List<OneBlogCatalog> getBlogCatalogList() {
        return blogCatalogList;
    }

    public void setBlogCatalogList(List<OneBlogCatalog> blogCatalogList) {
        this.blogCatalogList = blogCatalogList;
    }
}
