package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.DTO;

import java.util.List;
import java.util.Optional;

public class TerritoryDAO implements DAO {

    @Override
    public int insert(DTO item) {
        return 0;
    }

    @Override
    public boolean insertById(DTO item, int id) {
        return false;
    }

    @Override
    public Optional findById(int id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public int update(DTO item) {
        return 0;
    }

    @Override
    public boolean updateById(DTO item, int id) {
        return false;
    }

    @Override
    public int delete(DTO item) {
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
