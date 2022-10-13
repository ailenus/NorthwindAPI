package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.Territory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TerritoryRepository extends JpaRepository<Territory, Integer> {
    @Query(value = "SELECT coalesce(max(id), 0) FROM Territory")
    public int getMaxId();
}