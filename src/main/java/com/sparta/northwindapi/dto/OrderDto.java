package com.sparta.northwindapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.sparta.northwindapi.entity.Order} entity
 */
public class OrderDto implements Serializable {
    private Integer id;
    private ShipperDto shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    public OrderDto() {
    }

    public OrderDto(Integer id, ShipperDto shipVia, BigDecimal freight,
                    String shipName, String shipAddress, String shipCity,
                    String shipRegion, String shipPostalCode,
                    String shipCountry) {
        this.id = id;
        this.shipVia = shipVia;
        this.freight = freight;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ShipperDto getShipVia() {
        return shipVia;
    }

    public void setShipVia(ShipperDto shipVia) {
        this.shipVia = shipVia;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public void setFreight(BigDecimal freight) {
        this.freight = freight;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDto entity = (OrderDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.shipVia, entity.shipVia) &&
                Objects.equals(this.freight, entity.freight) &&
                Objects.equals(this.shipName, entity.shipName) &&
                Objects.equals(this.shipAddress, entity.shipAddress) &&
                Objects.equals(this.shipCity, entity.shipCity) &&
                Objects.equals(this.shipRegion, entity.shipRegion) &&
                Objects.equals(this.shipPostalCode, entity.shipPostalCode) &&
                Objects.equals(this.shipCountry, entity.shipCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipVia, freight, shipName, shipAddress,
                shipCity, shipRegion, shipPostalCode, shipCountry);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "shipVia = " + shipVia + ", " +
                "freight = " + freight + ", " +
                "shipName = " + shipName + ", " +
                "shipAddress = " + shipAddress + ", " +
                "shipCity = " + shipCity + ", " +
                "shipRegion = " + shipRegion + ", " +
                "shipPostalCode = " + shipPostalCode + ", " +
                "shipCountry = " + shipCountry + ")";
    }
}