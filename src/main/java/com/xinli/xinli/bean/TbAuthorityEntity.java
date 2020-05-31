package com.xinli.xinli.bean;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_authority", schema = "xinli", catalog = "")
public class TbAuthorityEntity {
    private int auCharacter;
    private Boolean auViewRecords;
    private Boolean auViewImg;
    private Boolean auViewHistory;
    private Boolean auPlaceModel;

    @Id
    @Column(name = "au_character", nullable = false)
    public int getAuCharacter() {
        return auCharacter;
    }

    public void setAuCharacter(int auCharacter) {
        this.auCharacter = auCharacter;
    }

    @Basic
    @Column(name = "au_view_records", nullable = true)
    public Boolean getAuViewRecords() {
        return auViewRecords;
    }

    public void setAuViewRecords(Boolean auViewRecords) {
        this.auViewRecords = auViewRecords;
    }

    @Basic
    @Column(name = "au_view_img", nullable = true)
    public Boolean getAuViewImg() {
        return auViewImg;
    }

    public void setAuViewImg(Boolean auViewImg) {
        this.auViewImg = auViewImg;
    }

    @Basic
    @Column(name = "au_view_history", nullable = true)
    public Boolean getAuViewHistory() {
        return auViewHistory;
    }

    public void setAuViewHistory(Boolean auViewHistory) {
        this.auViewHistory = auViewHistory;
    }

    @Basic
    @Column(name = "au_place_model", nullable = true)
    public Boolean getAuPlaceModel() {
        return auPlaceModel;
    }

    public void setAuPlaceModel(Boolean auPlaceModel) {
        this.auPlaceModel = auPlaceModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TbAuthorityEntity that = (TbAuthorityEntity) o;
        return auCharacter == that.auCharacter &&
                Objects.equals(auViewRecords, that.auViewRecords) &&
                Objects.equals(auViewImg, that.auViewImg) &&
                Objects.equals(auViewHistory, that.auViewHistory) &&
                Objects.equals(auPlaceModel, that.auPlaceModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auCharacter, auViewRecords, auViewImg, auViewHistory, auPlaceModel);
    }
}
