package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

// vai instanciar um obj repository (entidade e tipo id)
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
