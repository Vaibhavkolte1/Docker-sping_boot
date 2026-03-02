package com.college.e_commarce.repository;

import com.college.e_commarce.entity.Order;
import com.college.e_commarce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByBuyer_Id(Long userId);
}
