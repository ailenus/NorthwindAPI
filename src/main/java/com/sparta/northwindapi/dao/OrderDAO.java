package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.*;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.repo.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrderDAO implements DAO<OrderDTO>{

    private OrderRepository orderRepository;
    private Assembler assembler;


    public OrderDAO(OrderRepository orderRepository,Assembler assembler){
        this.orderRepository = orderRepository;
        this.assembler = assembler;
    }


//    @Override
//    public int insert(DTO item) {
//        return 0;
//    }
//
//    @Override
//    public boolean insertById(DTO item, int id) {
//        return false;
//    }
//
//    @Override
//    public int update(DTO item) {
//        return 0;
//    }
//
//    @Override
//    public boolean updateById(DTO item, int id) {
//        return false;
//    }

    @Override
    public int insert(OrderDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(OrderDTO item, int id) {
        return false;
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
    public Optional<OrderDTO> findById(int id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = null;
        if(optional.isPresent()) {
            order = optional.get();
            return Optional.of(assembler.assembleOrder(optional.get()))
                    ;
        }

        else
            return Optional.empty();


    }

    @Override
    public List findAll() {
        return null;
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
