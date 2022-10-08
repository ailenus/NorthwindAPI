package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.*;
import com.sparta.northwindapi.entity.*;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
class Assembler {
    CustomerDTO assembleCustomer(Customer customer) {
        return new CustomerDTO(
                customer.getId(),
                customer.getCompanyName(),
                customer.getContactName(),
                customer.getContactTitle(),
                customer.getAddress(),
                customer.getCity(),
                customer.getRegion(),
                customer.getPostalCode(),
                customer.getCountry(),
                customer.getPhone(),
                customer.getFax()
        );
    }

    EmployeeDTO assembleEmployee(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getTitle(),
                employee.getTitleOfCourtesy(),
                employee.getBirthDate(),
                employee.getHireDate(),
                employee.getAddress(),
                employee.getCity(),
                employee.getRegion(),
                employee.getPostalCode(),
                employee.getCountry(),
                employee.getHomePhone(),
                employee.getExtension(),
                employee.getPhoto(),
                employee.getNotes(),
                employee.getPhotoPath(),
                employee.getSalary(),
                employee.getTerritories().stream().map(this::assembleTerritory).collect(Collectors.toSet())
        );
    }

    OrderDTO assembleOrder(Order order) {

        return new OrderDTO(
                order.getId(),
                assembleEmployee(order.getEmployeeID()),
                assembleCustomer(order.getCustomerID()),
                order.getOrderDate(),
                order.getRequiredDate(),
                order.getShippedDate(),
                assembleShipper(order.getShipVia()),
                order.getFreight(),
                order.getShipName(),
                order.getShipAddress(),
                order.getShipRegion(),
                order.getShipPostalCode(),
                order.getShipCountry(),
                order.getShipAddress()
        );
    }

    ShipperDTO assembleShipper(Shipper shipper) {
        return new ShipperDTO(
                shipper.getId(),
                shipper.getCompanyName(),
                shipper.getPhone()
        );
    }

    TerritoryDTO assembleTerritory(Territory territory) {
        return new TerritoryDTO(
                territory.getId(),
                territory.getTerritoryDescription()
        );
    }
}
