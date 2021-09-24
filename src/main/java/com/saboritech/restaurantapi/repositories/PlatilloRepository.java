package com.saboritech.restaurantapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saboritech.restaurantapi.models.Platillo;

public interface PlatilloRepository extends JpaRepository<Platillo, Long> {
    public Platillo findByNombre(String nombre);
}
