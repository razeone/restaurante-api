package com.saboritech.restaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saboritech.restaurantapi.models.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Long> {
    
}
