package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

// vai instanciar um obj repository (entidade e tipo id)
public interface OrderRepository extends JpaRepository<Order, Long> {

}
