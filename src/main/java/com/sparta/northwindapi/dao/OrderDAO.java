package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.OrderDTO;

import java.util.List;
import java.util.Optional;

public class OrderDAO implements DAO<OrderDTO> {
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
        return Optional.empty();
    }

    @Override
    public List<OrderDTO> findAll() {
        return null;
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
