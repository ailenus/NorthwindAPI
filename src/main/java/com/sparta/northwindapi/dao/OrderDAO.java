package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.*;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.repo.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class OrderDAO implements DAO<OrderDTO>{
    private final OrderRepository repository;
    private final Assembler assembler;

    public OrderDAO(OrderRepository repository, Assembler assembler){
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public int insert(OrderDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(OrderDTO item, int id) {
        return false;
    }

    @Override
    public Optional<OrderDTO> findById(int id) {
        Optional<OrderDTO> result;
        Optional<Order> order;
        if ((order = repository.findById(id)).isPresent())
            result = Optional.of(assembler.assembleOrder(order.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = repository.findAll();
        List<OrderDTO> results = new ArrayList<>();
        for (Order order: orders)
            results.add(assembler.assembleOrder(order));
        return results;
    }

    @Override
    public int update(OrderDTO item) {
        return 0;
    }

    @Override
    public boolean updateById(OrderDTO item, int id) {
        return false;
    }

    @Override
    public int delete(OrderDTO item) {
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
