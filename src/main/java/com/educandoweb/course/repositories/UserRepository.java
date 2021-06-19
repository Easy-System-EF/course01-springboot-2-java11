package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.User;

// vai instanciar um obj repository (entidade e tipo id)
public interface UserRepository extends JpaRepository<User, Long>{

}
