package com.baeldung.sqlinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.baeldung.sqlinjection.model.Employee;
import com.baeldung.sqlinjection.springdata.EmployeeRepository;

@SpringBootApplication
public class SpringDataApplication {

    public static void main(String[] args) {

        EmployeeRepository repository = SpringApplication.run(SpringDataApplication.class, args)
            .getBean(EmployeeRepository.class);

        Employee emp1 = new Employee(1L, "Trudy");
        Employee emp2 = new Employee(2L, "Bob");
        repository.save(emp1);
        repository.save(emp2);

        // search by last name
        for (Employee emp : repository.findByName("Trudy")) {
            System.out.println(emp);
        }
    }

}
