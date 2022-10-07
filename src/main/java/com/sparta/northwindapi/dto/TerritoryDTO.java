package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Territory;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Territory} entity
 */
public class TerritoryDTO extends DTO {
    private String id;
    private String territoryDescription;

    public TerritoryDTO() {
    }

    public TerritoryDTO(String id, String territoryDescription) {
        this.id = id;
        this.territoryDescription = territoryDescription;
    }

    public String getId() {
        return id;
    }

    public TerritoryDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getTerritoryDescription() {
        return territoryDescription;
    }

    public TerritoryDTO setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TerritoryDTO entity = (TerritoryDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.territoryDescription, entity.territoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, territoryDescription);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "territoryDescription = " + territoryDescription + ")";
    }
}