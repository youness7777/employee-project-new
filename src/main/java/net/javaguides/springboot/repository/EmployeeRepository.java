package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<employee , Long> {

}
