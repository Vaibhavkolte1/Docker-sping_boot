package com.college.e_commarce.repository;

import com.college.e_commarce.entity.Cart;
import com.college.e_commarce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByOwner(User owner);
}
