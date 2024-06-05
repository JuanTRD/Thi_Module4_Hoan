package com.example.thimodule4_hoan.controller;

import com.example.thimodule4_hoan.model.City;
import com.example.thimodule4_hoan.model.Country;
import com.example.thimodule4_hoan.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private ICountryService countryService;
    @GetMapping("")//hien thi toan bo quoc gia
    public ResponseEntity<List<Country>> getAllCountry(){
        List<Country> countryList = countryService.findAll();
        return new ResponseEntity<>(countryList, HttpStatus.OK);
    }
    @GetMapping("/{id}")//hien thi ra thong tin cua quoc gia theo id
    public ResponseEntity<Country> getCountryById(Long id) {
        Country country = countryService.findById(id);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }
    @PostMapping("")//Tao 1 quoc gia moi
    public ResponseEntity<String> addNewCountry(@RequestBody Country country) {
        countryService.save(country);
        String message = "Country added";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @PutMapping("/{id}")//Chinh sua thong tin quoc gia theo id
    public ResponseEntity<String> editCity(@PathVariable Long id, @RequestBody Country country) {
        country.setId(id);
        countryService.save(country);
        String message = "Updated";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")//Xoa quoc gia theo id
    public ResponseEntity<String> deleteCity(@PathVariable Long id){
        countryService.remove(id);
        String message = "Deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
