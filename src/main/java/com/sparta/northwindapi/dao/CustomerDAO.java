package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.CustomerDTO;
import com.sparta.northwindapi.entity.Customer;
import com.sparta.northwindapi.repo.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Component
public class CustomerDAO implements DAO<CustomerDTO> {

    private final CustomerRepository repository;
    private final Assembler assembler;


    public CustomerDAO(CustomerRepository repository, Assembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public int insert(CustomerDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(CustomerDTO item, int id) {
        return false;
    }

    @Override
    public Optional<CustomerDTO> findById(int id) {
        Optional<CustomerDTO> result;
        Optional<Customer> customer;
        if ((customer = repository.findById(id)).isPresent())
            result = Optional.of(assembler.assembleCustomer(customer.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<CustomerDTO> findAll() {
        List<Customer> customers = repository.findAll();
        List<CustomerDTO> results = new ArrayList<>();
        for (Customer customer: customers)
            results.add(assembler.assembleCustomer(customer));
        return results;
    }

    @Override
    public int update(CustomerDTO customerDTO) {
        return 0;
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
