package net.javaguides.springboot.controller;


import net.javaguides.springboot.exeption.ResourceNotfoundexeption;
import net.javaguides.springboot.model.employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    // get all employees
    @GetMapping("/employees")
    public List<employee> getAllEmployees(){

        return employeeRepository.findAll();
    }

  //create employe
    @PostMapping("/createemp")
    public employee createEmployee (@RequestBody employee emp){
        return employeeRepository.save(emp);
    }
    //getemployeebyid
    @GetMapping("/employee/{id}")
    public ResponseEntity<employee> getEmployeebyid(@PathVariable long id){
        employee empl=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("employe not exist with id:"+id));
      return  ResponseEntity.ok(empl);
    }
}






