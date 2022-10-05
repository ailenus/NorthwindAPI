package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipperRepository extends JpaRepository<Shipper, Integer> {
}