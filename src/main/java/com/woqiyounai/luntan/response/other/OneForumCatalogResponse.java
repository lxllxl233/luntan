package com.woqiyounai.luntan.response.other;

import com.woqiyounai.luntan.entity.TbForumCatalogV1;
import com.woqiyounai.luntan.entity.TbForumCatalogV2;
import com.woqiyounai.luntan.response.other.info.OneBlogCatalog;
import com.woqiyounai.luntan.response.other.info.OneForumCatalog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OneForumCatalogResponse implements Serializable {
    private List<OneForumCatalog> forumCatalogList;
    public OneForumCatalogResponse() {
    }

    public OneForumCatalogResponse(List<OneForumCatalog> forumCatalogList) {
        this.forumCatalogList = forumCatalogList;
    }

    public OneForumCatalogResponse(List<TbForumCatalogV1> tbForumCatalogV1List, Map<Integer, List<TbForumCatalogV2>> map) {
        forumCatalogList = new ArrayList<>();
        tbForumCatalogV1List.forEach(e->{
            forumCatalogList.add(new OneForumCatalog(e,map.get(e.getId())));
        });
    }

    public List<OneForumCatalog> getForumCatalogList() {
        return forumCatalogList;
    }

    public void setForumCatalogList(List<OneForumCatalog> forumCatalogList) {
        this.forumCatalogList = forumCatalogList;
    }
}
