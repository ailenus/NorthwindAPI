package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.TerritoryDTO;
import com.sparta.northwindapi.repo.TerritoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TerritoryDAO implements DAO<TerritoryDTO> {
    TerritoryRepository repository;

    public TerritoryDAO(TerritoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public int insert(TerritoryDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(TerritoryDTO item, int id) {
        return false;
    }

    @Override
    public Optional<TerritoryDTO> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<TerritoryDTO> findAll() {
        return null;
    }

    @Override
    public int update(TerritoryDTO item) {
        return 0;
    }

    @Override
    public boolean updateById(TerritoryDTO item, int id) {
        return false;
    }

    @Override
    public int delete(TerritoryDTO item) {
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
