package com.demo.specification;


import org.springframework.data.jpa.domain.Specification;
import com.demo.model.Employee;

public class EmployeeSpecifications {

    public static Specification<Employee> filterByAge(Integer age) {
        return (root, query, criteriaBuilder) -> {
            if (age != null) {
                return criteriaBuilder.greaterThan(root.get("age"), age);
            }
            return null;
        };
    }

    public static Specification<Employee> filterByName(String name) {
        return (root, query, criteriaBuilder) -> {
            if (name != null && !name.isEmpty()) {
                return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("employeeName")), 
                    "%" + name.toLowerCase() + "%"
                );
            }
            return null;
        };
    }
}
