package domain.calculator;

import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;

public class TemporaryCalculator implements Calculator{

    @Override
    public boolean isSatisfiedBy(Role role) {
        return role == Role.TEMPORARY;
    }

    @Override
    public double calculatePay(Employee employee){
        return employee.getPay() - (employee.getPay() * 0.3);
    }

    @Override
    public double calculateAllPay(EmployeeStorage employeeStorage) {
        return employeeStorage.getEmployees().
                stream().
                filter(employee ->isSatisfiedBy(employee.getRole())).
                mapToDouble(o -> calculatePay(o)).
                sum();
    }





}
