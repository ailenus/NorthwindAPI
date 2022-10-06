package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.ShipperDTO;
import com.sparta.northwindapi.entity.Shipper;
import com.sparta.northwindapi.repo.ShipperRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipperDao {
    private final ShipperRepository REPOSITORY;

    public ShipperDao(ShipperRepository repository) {
        this.REPOSITORY = repository;
    }

    public ShipperDTO read(ShipperDTO dto) {
        Optional<Shipper> optional = REPOSITORY.findById(dto.getId());
        if (optional.isEmpty()) {
            return new ShipperDTO(-1, null, null);
        } else {
            Shipper shipper = optional.get();
            return new ShipperDTO(shipper.getId(), shipper.getCompanyName(),
                    shipper.getPhone());
        }
    }

    public ShipperDTO update(ShipperDTO dto) {
        Optional<Shipper> optional = REPOSITORY.findById(dto.getId());
        if (optional.isEmpty()) {
             return new ShipperDTO(-1, null, null);
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
        return new ShipperDTO(shipper.getId(), shipper.getCompanyName(),
                shipper.getPhone());
    }
}
