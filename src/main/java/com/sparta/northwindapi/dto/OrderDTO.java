package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Order;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link Order} entity
 */
public class OrderDTO extends DTO {
    private Integer id;
    private CustomerDTO customerID;
    private EmployeeDTO employeeID;
    private Instant orderDate;
    private Instant requiredDate;
    private Instant shippedDate;
    private ShipperDTO shipVia;
    private BigDecimal freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;

    public OrderDTO() {
    }

    public OrderDTO(Integer id, CustomerDTO customerID, EmployeeDTO employeeID, Instant orderDate, Instant requiredDate, Instant shippedDate, ShipperDTO shipVia, BigDecimal freight, String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry) {
        this.id = id;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
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

    public OrderDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public CustomerDTO getCustomerID() {
        return customerID;
    }

    public OrderDTO setCustomerID(CustomerDTO customerID) {
        this.customerID = customerID;
        return this;
    }

    public EmployeeDTO getEmployeeID() {
        return employeeID;
    }

    public OrderDTO setEmployeeID(EmployeeDTO employeeID) {
        this.employeeID = employeeID;
        return this;
    }

    public Instant getOrderDate() {
        return orderDate;
    }

    public OrderDTO setOrderDate(Instant orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Instant getRequiredDate() {
        return requiredDate;
    }

    public OrderDTO setRequiredDate(Instant requiredDate) {
        this.requiredDate = requiredDate;
        return this;
    }

    public Instant getShippedDate() {
        return shippedDate;
    }

    public OrderDTO setShippedDate(Instant shippedDate) {
        this.shippedDate = shippedDate;
        return this;
    }

    public ShipperDTO getShipVia() {
        return shipVia;
    }

    public OrderDTO setShipVia(ShipperDTO shipVia) {
        this.shipVia = shipVia;
        return this;
    }

    public BigDecimal getFreight() {
        return freight;
    }

    public OrderDTO setFreight(BigDecimal freight) {
        this.freight = freight;
        return this;
    }

    public String getShipName() {
        return shipName;
    }

    public OrderDTO setShipName(String shipName) {
        this.shipName = shipName;
        return this;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public OrderDTO setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
        return this;
    }

    public String getShipCity() {
        return shipCity;
    }

    public OrderDTO setShipCity(String shipCity) {
        this.shipCity = shipCity;
        return this;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public OrderDTO setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
        return this;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public OrderDTO setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
        return this;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public OrderDTO setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDTO entity = (OrderDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.customerID, entity.customerID) &&
                Objects.equals(this.employeeID, entity.employeeID) &&
                Objects.equals(this.orderDate, entity.orderDate) &&
                Objects.equals(this.requiredDate, entity.requiredDate) &&
                Objects.equals(this.shippedDate, entity.shippedDate) &&
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
        return Objects.hash(id, customerID, employeeID, orderDate, requiredDate, shippedDate, shipVia, freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "customerID = " + customerID + ", " +
                "employeeID = " + employeeID + ", " +
                "orderDate = " + orderDate + ", " +
                "requiredDate = " + requiredDate + ", " +
                "shippedDate = " + shippedDate + ", " +
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