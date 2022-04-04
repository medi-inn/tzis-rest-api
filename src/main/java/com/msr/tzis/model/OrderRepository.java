package com.msr.tzis.model;


import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderRepository extends JpaRepository<Ordering, Long> {
}
