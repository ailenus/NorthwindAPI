package com.sparta.northwindapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "territories")
public class Territory {
    @Id
    @Column(name = "TerritoryID", nullable = false)
    private Integer id;

    @Column(name = "TerritoryDescription", nullable = false, length = 50)
    private String territoryDescription;

    @Column(name = "RegionID", nullable = false)
    private Integer regionId = 1;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

}