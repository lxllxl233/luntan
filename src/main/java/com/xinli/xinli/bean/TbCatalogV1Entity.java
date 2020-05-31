package com.xinli.xinli.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_catalog_v1", schema = "xinli", catalog = "")
public class TbCatalogV1Entity {
    private int v1Id;
    private String v1Name;

    @Id
    @Column(name = "v1_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getV1Id() {
        return v1Id;
    }

    public void setV1Id(int v1Id) {
        this.v1Id = v1Id;
    }

    @Basic
    @Column(name = "v1_name", nullable = true, length = 64)
    public String getV1Name() {
        return v1Name;
    }

    public void setV1Name(String v1Name) {
        this.v1Name = v1Name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbCatalogV1Entity that = (TbCatalogV1Entity) o;
        return v1Id == that.v1Id &&
                Objects.equals(v1Name, that.v1Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1Id, v1Name);
    }
}
