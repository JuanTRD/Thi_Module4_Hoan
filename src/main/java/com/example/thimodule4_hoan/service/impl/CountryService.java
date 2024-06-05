package com.example.thimodule4_hoan.service.impl;

import com.example.thimodule4_hoan.model.Country;
import com.example.thimodule4_hoan.repository.CountryRepository;
import com.example.thimodule4_hoan.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).get();
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
