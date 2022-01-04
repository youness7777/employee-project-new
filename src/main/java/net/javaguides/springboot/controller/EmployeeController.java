package net.javaguides.springboot.controller;


import net.javaguides.springboot.exeption.ResourceNotfoundexeption;
import net.javaguides.springboot.model.employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //update employe
    @PutMapping("/employees/{id}")
    public ResponseEntity<employee> updateEmployee(@PathVariable Long id, @RequestBody employee employeeDetails){
        employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        employee employeet = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employeet);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}






