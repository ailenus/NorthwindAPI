package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Shipper;

import java.util.Objects;

/**
 * A DTO for the {@link Shipper} entity
 */
public class ShipperDTO extends DTO {
    private String companyName;
    private String phone;

    public ShipperDTO() {
    }

    public ShipperDTO(Integer id, String companyName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
    }

    @Override
    public ShipperDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public ShipperDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ShipperDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipperDTO entity = (ShipperDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.companyName, entity.companyName) &&
                Objects.equals(this.phone, entity.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, phone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "companyName = " + companyName + ", " +
                "phone = " + phone + ")";
    }
}