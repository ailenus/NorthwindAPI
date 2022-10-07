package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Customer;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link Customer} entity
 */
public class CustomerDTO extends DTO {
    private String companyName;
    private String contactName;
    private String contactTitle;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String phone;
    private String fax;

    public CustomerDTO() {
    }

    public CustomerDTO(Integer id, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax) {
        this.id = id;
        this.companyName = companyName;
        this.contactName = contactName;
        this.contactTitle = contactTitle;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.fax = fax;
    }

    @Override
    public CustomerDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCompanyName() {
        return companyName;
    }

    public CustomerDTO setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public String getContactName() {
        return contactName;
    }

    public CustomerDTO setContactName(String contactName) {
        this.contactName = contactName;
        return this;
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public CustomerDTO setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public CustomerDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public CustomerDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public CustomerDTO setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public CustomerDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CustomerDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getFax() {
        return fax;
    }

    public CustomerDTO setFax(String fax) {
        this.fax = fax;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO entity = (CustomerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.companyName, entity.companyName) &&
                Objects.equals(this.contactName, entity.contactName) &&
                Objects.equals(this.contactTitle, entity.contactTitle) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.region, entity.region) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.fax, entity.fax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "companyName = " + companyName + ", " +
                "contactName = " + contactName + ", " +
                "contactTitle = " + contactTitle + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "region = " + region + ", " +
                "postalCode = " + postalCode + ", " +
                "country = " + country + ", " +
                "phone = " + phone + ", " +
                "fax = " + fax + ")";
    }
}