package com.xinli.xinli.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_catalog_v2", schema = "xinli", catalog = "")
public class TbCatalogV2Entity {
    private int v2Id;
    private Integer v1Id;
    private String v2Name;

    @Id
    @Column(name = "v2_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getV2Id() {
        return v2Id;
    }

    public void setV2Id(int v2Id) {
        this.v2Id = v2Id;
    }

    @Basic
    @Column(name = "v1_id", nullable = true)
    public Integer getV1Id() {
        return v1Id;
    }

    public void setV1Id(Integer v1Id) {
        this.v1Id = v1Id;
    }

    @Basic
    @Column(name = "v2_name", nullable = true, length = 64)
    public String getV2Name() {
        return v2Name;
    }

    public void setV2Name(String v2Name) {
        this.v2Name = v2Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCatalogV2Entity that = (TbCatalogV2Entity) o;
        return v2Id == that.v2Id &&
                Objects.equals(v1Id, that.v1Id) &&
                Objects.equals(v2Name, that.v2Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v2Id, v1Id, v2Name);
    }
}
