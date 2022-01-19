package domain.calculator;

import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;

public interface Calculator {

    public boolean isSatisfiedBy(Role role);

    public double calculatePay(Employee employee);

    public double calculateAllPay(EmployeeStorage employee);

}
