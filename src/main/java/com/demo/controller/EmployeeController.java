package com.demo.controller;

import com.demo.entity.Country;
import com.demo.entity.Employee;
import com.demo.repository.CountryRepository;
import com.demo.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    private EmployeeRepository employeeRepository;
    private CountryRepository countryRepository;

    public EmployeeController(EmployeeRepository employeeRepository, CountryRepository countryRepository) {
        this.employeeRepository = employeeRepository;
        this.countryRepository = countryRepository;
    }
@PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestParam long countryId,@RequestBody Employee employee){

    Country country=countryRepository.findById(countryId).get();
    employee.setCountry(country);
       Employee savedEmp= employeeRepository.save(employee);
       return ResponseEntity.ok().body(savedEmp);
       }
//other  way to save the record what is another way to save the record by the way?
  // nested object
    //other way to now url you can give  the country id and body you can give the json
    //basied on the country id get the country id and then save///


}
