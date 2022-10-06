package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.ShipperDto;
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

    public ShipperDto update(ShipperDto dto) {
        Optional<Shipper> optional = REPOSITORY.findById(dto.getId());
        if (optional.isEmpty()) {
             return new ShipperDto(-1, null, null);
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
        return new ShipperDto(shipper.getId(), shipper.getCompanyName(),
                shipper.getPhone());
    }
}
