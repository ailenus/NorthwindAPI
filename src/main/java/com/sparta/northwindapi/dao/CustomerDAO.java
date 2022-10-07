package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.CustomerDTO;
import com.sparta.northwindapi.dto.TerritoryDTO;
import com.sparta.northwindapi.entity.Customer;
import com.sparta.northwindapi.entity.Territory;
import com.sparta.northwindapi.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CustomerDAO implements DAO<CustomerDTO>{

    private CustomerRepository REPOSITORY;

    private final Assembler assembler;


    public CustomerDAO(CustomerRepository custRepo, Assembler assembler) {
        this.assembler = assembler;
        this.REPOSITORY = custRepo;

    }

    @Override
    public int insert(CustomerDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(CustomerDTO item, int id) {
        return false;
    }

    public Optional<CustomerDTO> findById(int id) {
        Optional<CustomerDTO> result;
        Optional<Customer> customer;
        if ((customer = REPOSITORY.findById(id)).isPresent())
            result = Optional.of(assembler.assembleCustomer(customer.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = REPOSITORY.findAll();
        List<CustomerDTO> results = new ArrayList<>();
        for (Customer customer: customers)
            results.add(assembler.assembleCustomer(customer));
        return results;
    }


    @Override
    public int update(CustomerDTO customerDTO) {
        Optional<Customer> optional = REPOSITORY.findById(customerDTO.getId());
        Customer theCustomer = null;
        if (optional.isPresent())
            theCustomer = optional.get();
        else
            return -1;
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


        REPOSITORY.save(theCustomer);
        return customerDTO.getId();
    }

    @Override
    public boolean updateById(CustomerDTO item, int id) {
        return false;
    }

    @Override
    public int delete(CustomerDTO item) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
