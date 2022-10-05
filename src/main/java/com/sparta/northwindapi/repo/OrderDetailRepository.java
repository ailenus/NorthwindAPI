package com.sparta.northwindapi.repo;

import com.sparta.northwindapi.entity.OrderDetail;
import com.sparta.northwindapi.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}