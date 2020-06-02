package com.woqiyounai.luntan.request;

import java.io.Serializable;

public class LunTanUpdateRequest implements Serializable {
    private Integer id;
    private String title;
    private String text;
    public LunTanUpdateRequest() {
    }

    public LunTanUpdateRequest(Integer id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
