package com.example.BioskopApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.BioskopApp.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
