package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.CustomerDTO;
import com.sparta.northwindapi.entity.Customer;
import com.sparta.northwindapi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CustomerDAO implements DAO<CustomerDTO> {

    @Autowired
    private CustomerRepository REPOSITORY;


    public CustomerDAO() {

    }


    public CustomerDTO findById(String id) {
        Optional<Customer> optionalCust = REPOSITORY.findById(id);
        if (optionalCust.isPresent()) {
            return new CustomerDTO(optionalCust.get().getId(),
                    optionalCust.get().getCompanyName(),
                    optionalCust.get().getContactName(),
                    optionalCust.get().getContactTitle(),
                    optionalCust.get().getAddress(),
                    optionalCust.get().getCity(),
                    optionalCust.get().getRegion(),
                    optionalCust.get().getPostalCode(),
                    optionalCust.get().getCountry(),
                    optionalCust.get().getPhone(),
                    optionalCust.get().getFax());
        }
        return new CustomerDTO("-1",
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null);
    }


    public CustomerDTO update(CustomerDTO customerDTO) {
        Optional<Customer> optional = REPOSITORY.findById(customerDTO.getId());
        Customer theCustomer = null;
        if (optional.isPresent())
            theCustomer = optional.get();
        else
            return new CustomerDTO("-1",
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null,
                    null);
        if (customerDTO.getId() != null)
            theCustomer.setId(customerDTO.getId());
        if (customerDTO.getCompanyName() != null)
            theCustomer.setCompanyName(customerDTO.getCompanyName());
        if (customerDTO.getContactName() != null)
            theCustomer.setContactName(customerDTO.getContactName());
        if (customerDTO.getContactTitle() != null)
            theCustomer.setContactTitle(customerDTO.getContactTitle());
        if (customerDTO.getAddress() != null)
            theCustomer.setAddress(customerDTO.getAddress());
        if (customerDTO.getCity() != null)
            theCustomer.setCity(customerDTO.getCity());
        if (customerDTO.getRegion() != null)
            theCustomer.setRegion(customerDTO.getRegion());
        if (customerDTO.getPostalCode() != null)
            theCustomer.setPostalCode(customerDTO.getPostalCode());
        if (customerDTO.getCountry() != null)
            theCustomer.setCountry(customerDTO.getCountry());
        if (customerDTO.getPhone() != null)
            theCustomer.setPhone(customerDTO.getPhone());
        if (customerDTO.getFax() != null)
            theCustomer.setFax(customerDTO.getFax());


        //actorRepo.save(theActor);
        theCustomer = REPOSITORY.findById(customerDTO.getId()).get();
        return new CustomerDTO(theCustomer.getId(),
                theCustomer.getCompanyName(),
                theCustomer.getContactName(),
                theCustomer.getContactTitle(),
                theCustomer.getAddress(),
                theCustomer.getCity(),
                theCustomer.getRegion(),
                theCustomer.getPostalCode(),
                theCustomer.getCountry(),
                theCustomer.getPhone(),
                theCustomer.getFax());
    }
}
