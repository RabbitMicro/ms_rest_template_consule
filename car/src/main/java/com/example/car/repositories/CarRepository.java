package com.example.car.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.car.entities.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> { 
    
    @Query("SELECT c FROM Car c WHERE c.client_id = :clientId")
    List<Car> findByClientId(@Param("clientId") Long clientId);
}