package com.xinli.xinli.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_model", schema = "xinli", catalog = "")
public class TbModelEntity {
    private int mdId;
    private Integer v2Id;
    private String mdName;
    private String mdDescription;
    private String mdSmallUrl;
    private String mdBigUrl;

    @Id
    @Column(name = "md_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getMdId() {
        return mdId;
    }

    public void setMdId(int mdId) {
        this.mdId = mdId;
    }

    @Basic
    @Column(name = "v2_id", nullable = true)
    public Integer getV2Id() {
        return v2Id;
    }

    public void setV2Id(Integer v2Id) {
        this.v2Id = v2Id;
    }

    @Basic
    @Column(name = "md_name", nullable = true, length = 64)
    public String getMdName() {
        return mdName;
    }

    public void setMdName(String mdName) {
        this.mdName = mdName;
    }

    @Basic
    @Column(name = "md_description", nullable = true, length = 255)
    public String getMdDescription() {
        return mdDescription;
    }

    public void setMdDescription(String mdDescription) {
        this.mdDescription = mdDescription;
    }

    @Basic
    @Column(name = "md_small_url", nullable = true, length = 255)
    public String getMdSmallUrl() {
        return mdSmallUrl;
    }

    public void setMdSmallUrl(String mdSmallUrl) {
        this.mdSmallUrl = mdSmallUrl;
    }

    @Basic
    @Column(name = "md_big_url", nullable = true, length = 255)
    public String getMdBigUrl() {
        return mdBigUrl;
    }

    public void setMdBigUrl(String mdBigUrl) {
        this.mdBigUrl = mdBigUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbModelEntity that = (TbModelEntity) o;
        return mdId == that.mdId &&
                Objects.equals(v2Id, that.v2Id) &&
                Objects.equals(mdName, that.mdName) &&
                Objects.equals(mdDescription, that.mdDescription) &&
                Objects.equals(mdSmallUrl, that.mdSmallUrl) &&
                Objects.equals(mdBigUrl, that.mdBigUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mdId, v2Id, mdName, mdDescription, mdSmallUrl, mdBigUrl);
    }
}
