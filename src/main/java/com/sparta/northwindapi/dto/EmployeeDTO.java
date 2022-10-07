package com.sparta.northwindapi.dto;

import com.sparta.northwindapi.entity.Employee;

import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A DTO for the {@link Employee} entity
 */
public class EmployeeDTO extends DTO {
    private String lastName;
    private String firstName;
    private String title;
    private String titleOfCourtesy;
    private Instant birthDate;
    private Instant hireDate;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String homePhone;
    private String extension;
    private byte[] photo;
    private String notes;
    private String photoPath;
    private Float salary;
    private Set<TerritoryDTO> territories = new LinkedHashSet<>();

    public EmployeeDTO() {
    }

    public EmployeeDTO(Integer id, String lastName, String firstName, String title, String titleOfCourtesy, Instant birthDate, Instant hireDate, String address, String city, String region, String postalCode, String country, String homePhone, String extension, byte[] photo, String notes, String photoPath, Float salary, Set<TerritoryDTO> territories) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.title = title;
        this.titleOfCourtesy = titleOfCourtesy;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.homePhone = homePhone;
        this.extension = extension;
        this.photo = photo;
        this.notes = notes;
        this.photoPath = photoPath;
        this.salary = salary;
        this.territories = territories;
    }

    @Override
    public EmployeeDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public EmployeeDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public EmployeeDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public EmployeeDTO setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitleOfCourtesy() {
        return titleOfCourtesy;
    }

    public EmployeeDTO setTitleOfCourtesy(String titleOfCourtesy) {
        this.titleOfCourtesy = titleOfCourtesy;
        return this;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public EmployeeDTO setBirthDate(Instant birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public Instant getHireDate() {
        return hireDate;
    }

    public EmployeeDTO setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public EmployeeDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getCity() {
        return city;
    }

    public EmployeeDTO setCity(String city) {
        this.city = city;
        return this;
    }

    public String getRegion() {
        return region;
    }

    public EmployeeDTO setRegion(String region) {
        this.region = region;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public EmployeeDTO setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public EmployeeDTO setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public EmployeeDTO setHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getExtension() {
        return extension;
    }

    public EmployeeDTO setExtension(String extension) {
        this.extension = extension;
        return this;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public EmployeeDTO setPhoto(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public EmployeeDTO setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public EmployeeDTO setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }

    public Float getSalary() {
        return salary;
    }

    public EmployeeDTO setSalary(Float salary) {
        this.salary = salary;
        return this;
    }

    public Set<TerritoryDTO> getTerritories() {
        return territories;
    }

    public EmployeeDTO setTerritories(Set<TerritoryDTO> territories) {
        this.territories = territories;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDTO entity = (EmployeeDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.title, entity.title) &&
                Objects.equals(this.titleOfCourtesy, entity.titleOfCourtesy) &&
                Objects.equals(this.birthDate, entity.birthDate) &&
                Objects.equals(this.hireDate, entity.hireDate) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.region, entity.region) &&
                Objects.equals(this.postalCode, entity.postalCode) &&
                Objects.equals(this.country, entity.country) &&
                Objects.equals(this.homePhone, entity.homePhone) &&
                Objects.equals(this.extension, entity.extension) &&
                Objects.equals(this.photo, entity.photo) &&
                Objects.equals(this.notes, entity.notes) &&
                Objects.equals(this.photoPath, entity.photoPath) &&
                Objects.equals(this.salary, entity.salary) &&
                Objects.equals(this.territories, entity.territories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, city, region, postalCode, country, homePhone, extension, photo, notes, photoPath, salary, territories);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "lastName = " + lastName + ", " +
                "firstName = " + firstName + ", " +
                "title = " + title + ", " +
                "titleOfCourtesy = " + titleOfCourtesy + ", " +
                "birthDate = " + birthDate + ", " +
                "hireDate = " + hireDate + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "region = " + region + ", " +
                "postalCode = " + postalCode + ", " +
                "country = " + country + ", " +
                "homePhone = " + homePhone + ", " +
                "extension = " + extension + ", " +
                "photo = " + photo + ", " +
                "notes = " + notes + ", " +
                "photoPath = " + photoPath + ", " +
                "salary = " + salary + ", " +
                "territories = " + territories + ")";
    }
}