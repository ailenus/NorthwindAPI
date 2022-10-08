package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.ShipperDTO;
import com.sparta.northwindapi.entity.Shipper;
import com.sparta.northwindapi.repo.ShipperRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ShipperDAO implements DAO<ShipperDTO> {
    private final ShipperRepository repository;
    private final Assembler assembler;

    public ShipperDAO(ShipperRepository repository, Assembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @Override
    public int insert(ShipperDTO item) {
        // TODO
        return 0;
    }

    @Override
    public boolean insertById(ShipperDTO item, int id) {
        // TODO
        return false;
    }

    @Override
    public Optional<ShipperDTO> findById(int id) {
        Optional<ShipperDTO> result;
        Optional<Shipper> shipper;
        if ((shipper = repository.findById(id)).isPresent())
            result = Optional.of(assembler.assembleShipper(shipper.get()));
        else
            result = Optional.empty();
        return result;
    }

    @Override
    public List<ShipperDTO> findAll() {
        List<Shipper> shippers = repository.findAll();
        List<ShipperDTO> results = new ArrayList<>();
        for (Shipper shipper: shippers)
            results.add(assembler.assembleShipper(shipper));
        return results;
    }

    @Override
    public int update(ShipperDTO item) {
        Optional<Shipper> optional = repository.findById(item.getId());
        if (optional.isEmpty()) {
             return -1;
        }
        Shipper shipper = optional.get();
        if (item.getCompanyName() != null) {
            shipper.setCompanyName(item.getCompanyName());
        }
        if (item.getPhone() != null) {
            shipper.setPhone(item.getPhone());
        }
        repository.save(shipper);
        Optional<Shipper> result = repository.findById(item.getId());
        if (result.isPresent()) {
            shipper = result.get();
        }
        return shipper.getId();
    }

    @Override
    public boolean updateById(ShipperDTO item, int id) {
        // TODO
        return false;
    }

    @Override
    public int delete(ShipperDTO item) {
        if (item == null) {
            return -1;
        }
        int id = item.getId();
        try {
            repository.deleteById(id);
            return id;
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }

    @Override
    public boolean deleteById(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
