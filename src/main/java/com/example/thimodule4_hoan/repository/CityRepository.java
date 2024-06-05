package com.example.thimodule4_hoan.repository;


import com.example.thimodule4_hoan.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
}
