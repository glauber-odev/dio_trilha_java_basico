package me.dio.santander_dev_week_2023.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.santander_dev_week_2023.model.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
