package com.xinli.xinli.bean.other;

import com.xinli.xinli.bean.TbCatalogV2Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_catalog_v1", schema = "xinli", catalog = "")
public class TbAllCatalog {
    private int v1Id;
    private String v1Name;
    private List<TbCatalogV2Entity> tbCatalogV2Entity;

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

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "v1_id")
    public List<TbCatalogV2Entity> getTbCatalogV2Entity() {
        return tbCatalogV2Entity;
    }

    public void setTbCatalogV2Entity(List<TbCatalogV2Entity> tbCatalogV2Entity) {
        this.tbCatalogV2Entity = tbCatalogV2Entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com.xinli.xinli.bean.TbCatalogV1Entity that = (com.xinli.xinli.bean.TbCatalogV1Entity) o;
        return v1Id == that.getV1Id() &&
                Objects.equals(v1Name, that.getV1Name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1Id, v1Name);
    }

}

