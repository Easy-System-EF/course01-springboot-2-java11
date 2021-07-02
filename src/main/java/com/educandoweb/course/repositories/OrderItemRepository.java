package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.OrderItem;

// vai instanciar um obj repository (entidade e tipo id)
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
