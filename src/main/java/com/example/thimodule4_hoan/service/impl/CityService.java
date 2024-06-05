package com.example.thimodule4_hoan.service.impl;


import com.example.thimodule4_hoan.model.City;
import com.example.thimodule4_hoan.repository.CityRepository;
import com.example.thimodule4_hoan.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;
    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}
