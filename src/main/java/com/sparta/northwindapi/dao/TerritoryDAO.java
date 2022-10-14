package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.TerritoryDTO;
import com.sparta.northwindapi.entity.Territory;
import com.sparta.northwindapi.repo.TerritoryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TerritoryDAO implements DAO<TerritoryDTO> {
    private final TerritoryRepository repository;
    private final Assembler assembler;

    public TerritoryDAO(TerritoryRepository repository, Assembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public int insert(TerritoryDTO item) {
        if (repository.existsById(item.getId()))
            item.setId(repository.getMaxId() + 1);
        try {
            repository.saveAndFlush(assembler.dismantleTerritory(item));
            return item.getId();
        } catch (Exception e) { return -1; }
    }

    @Override
    public boolean insertById(TerritoryDTO item, int id) {
        if (repository.existsById(id))
            return false;
        item.setId(id);
        try {
            repository.saveAndFlush(assembler.dismantleTerritory(item));
            return true;
        } catch (Exception e) { return false; }
    }

    @Override
    public Optional<TerritoryDTO> findById(int id) {
        Optional<TerritoryDTO> result;
        Optional<Territory> territory;
        if ((territory = repository.findById(id)).isPresent())
            result = Optional.of(assembler.assembleTerritory(territory.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<TerritoryDTO> findAll() {
        List<Territory> territories = repository.findAll();
        List<TerritoryDTO> results = new ArrayList<>();
        territories.forEach(assembler::assembleTerritory);
        for (Territory territory: territories)
            results.add(assembler.assembleTerritory(territory));
        return results;
    }

    @Override
    public int update(TerritoryDTO item) {
        if (!repository.existsById(item.getId()))
            return -1;
        try {
            repository.saveAndFlush(assembler.dismantleTerritory(item));
            return item.getId();
        } catch (Exception e) { return -1; }
    }

    @Override
    public boolean updateById(TerritoryDTO item, int id) {
        item.setId(id);
        return update(item)!=-1;
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
