package com.example.thimodule4_hoan.controller;


import com.example.thimodule4_hoan.model.City;
import com.example.thimodule4_hoan.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/cities")
public class CityController {
@Autowired
    private ICityService cityService;
@GetMapping("")//hien thi toan bo thanh pho
    public ResponseEntity<List<City>> getAllCities() {
    List<City> cities = cityService.findAll();
    return new ResponseEntity<>(cities, HttpStatus.OK);
}
@GetMapping("{id}")//hien thi ra thong tin cua thanh pho theo id
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
    City city = cityService.findById(id);
    return new ResponseEntity<>(city, HttpStatus.OK);
}
@PostMapping("")//Tao 1 thanh pho moi
    public ResponseEntity<String> addNewCity(@RequestBody City city) {
    cityService.save(city);
    String message = "City added";
    return new ResponseEntity<>(message, HttpStatus.OK);
}
@PutMapping("{id}")//Chinh sua thong tin thanh pho theo id
    public ResponseEntity<String> editCity(@PathVariable Long id, @RequestBody City city) {
        city.setId(id);
cityService.save(city);
String message = "Updated";
return new ResponseEntity<>(message, HttpStatus.OK);
}
@DeleteMapping("{id}")//Xoa thanh pho theo id
    public ResponseEntity<String> deleteCity(@PathVariable Long id){
        cityService.remove(id);
        String message = "Deleted";
        return new ResponseEntity<>(message, HttpStatus.OK);
}
}
