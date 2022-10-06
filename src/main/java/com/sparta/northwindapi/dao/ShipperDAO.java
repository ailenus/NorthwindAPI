package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.ShipperDTO;
import com.sparta.northwindapi.entity.Shipper;
import com.sparta.northwindapi.repo.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipperDAO implements DAO<ShipperDTO> {
    private final ShipperRepository REPOSITORY;

    public ShipperDAO(ShipperRepository repository) {
        this.REPOSITORY = repository;
    }

    @Override
    public int insert(ShipperDTO item) {
        return 0;
    }

    @Override
    public boolean insertById(ShipperDTO item, int id) {
        return false;
    }

    @Override
    public int update(ShipperDTO dto) {
        Optional<Shipper> optional = REPOSITORY.findById(dto.getId());
        if (optional.isEmpty()) {
             return -1;
        }
        Shipper shipper = optional.get();
        if (dto.getCompanyName() != null) {
            shipper.setCompanyName(dto.getCompanyName());
        }
        if (dto.getPhone() != null) {
            shipper.setPhone(dto.getPhone());
        }
        REPOSITORY.save(shipper);
        Optional<Shipper> result = REPOSITORY.findById(dto.getId());
        if (result.isPresent()) {
            shipper = result.get();
        }
        return shipper.getId();
    }

    @Override
    public boolean updateById(ShipperDTO item, int id) {
        return false;
    }

    @Override
    public int delete(ShipperDTO item) {
        return 0;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }

    @Override
    public Optional<ShipperDTO> findById(int id) {
        Optional<Shipper> optional = REPOSITORY.findById(id);
        if (optional.isPresent()) {
            Shipper shipper = optional.get();
            return Optional.of(
                    new ShipperDTO(shipper.getId(), shipper.getCompanyName(),
                            shipper.getPhone()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<ShipperDTO> findAll() {
        return null;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }
}
