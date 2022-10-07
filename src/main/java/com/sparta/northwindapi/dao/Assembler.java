package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.*;
import com.sparta.northwindapi.entity.*;
import org.springframework.stereotype.Component;

@Component
class Assembler {
    CustomerDTO assembleCustomer(Customer customer) {
        return null;
    }

    EmployeeDTO assembleEmployee(Employee employee) {
        return null;
    }

    OrderDAO assembleOrder(Order order) {
        return null;
    }

    ShipperDTO assembleShipper(Shipper shipper) {
        return null;
    }

    TerritoryDTO assembleTerritory(Territory territory) {
        return new TerritoryDTO(
                territory.getId(),
                territory.getTerritoryDescription()
        );
    }
}
