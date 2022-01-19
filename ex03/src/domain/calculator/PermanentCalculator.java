package domain.calculator;

import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;

public class PermanentCalculator implements Calculator{
    @Override
    public boolean isSatisfiedBy(Role role) {
        return role == Role.PERMANENT;
    }

    @Override
    public double calculatePay(Employee employee) {
        return employee.getPay() - (employee.getPay() * employee.getTaxRate());
    }

    @Override
    public double calculateAllPay(EmployeeStorage employeeStorage) {
        return employeeStorage.getEmployees().
                stream().
                filter(employee ->employee.getRole() == Role.PERMANENT).
                mapToDouble(o -> calculatePay(o)).
                sum();
    }
}
