package com.sparta.northwindapi.dto;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link com.sparta.northwindapi.entity.Shipper} entity
 */
public class ShipperDto implements Serializable {
    private Integer id;
    private String companyName;
    private String phone;
    private Set<OrderDto> orders = new LinkedHashSet<>();

    public ShipperDto() {
    }

    public ShipperDto(Integer id, String companyName, String phone,
                      Set<OrderDto> orders) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
        this.orders = orders;
    }

    public ShipperDto(Integer id, String companyName, String phone) {
        this.id = id;
        this.companyName = companyName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<OrderDto> getOrders() {
        return orders;
    }

    public void setOrders(Set<OrderDto> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipperDto entity = (ShipperDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.companyName, entity.companyName) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.orders, entity.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, phone, orders);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "companyName = " + companyName + ", " +
                "phone = " + phone + ", " +
                "orders = " + orders + ")";
    }
}