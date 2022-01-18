package domain.employee;

import java.util.*;

public class EmployeeStorage {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeStorage(Employee ...employees) {
        this.employees = Arrays.asList(employees);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

}

