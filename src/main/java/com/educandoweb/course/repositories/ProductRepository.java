package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Product;

// vai instanciar um obj repository (entidade e tipo id)
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
