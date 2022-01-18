package domain.pay;

import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;

public class Calculator {

    public double calculatePay(Employee employee){
        switch (employee.getRole()){
            case PERMANENT:
                return calculatePermanentPay(employee);
            case TEMPORARY:
                return calculateTemporaryPay(employee);
            default:
                return 0;
        }
    }
    public double calculateAllPay(EmployeeStorage employeeStorage, Role role){
        switch (role){
            case PERMANENT:
                return calculateAllPermanentPay(employeeStorage);
            case TEMPORARY:
                return calculateAllTemporaryPay(employeeStorage);
            default:
                return calculateAllPay(employeeStorage);
        }
    }

    private double calculateAllPay(EmployeeStorage employeeStorage) {
        return employeeStorage.getEmployees().stream().
                mapToInt(o -> o.getPay()).
                sum();
    }

    private double calculateAllPermanentPay(EmployeeStorage employeeStorage) {
        return employeeStorage.getEmployees().
                stream().
                filter(employee ->employee.getRole() == Role.PERMANENT).
                mapToDouble(o -> calculatePermanentPay(o)).
                sum();
    }
    private double calculateAllTemporaryPay(EmployeeStorage employeeStorage) {
        return employeeStorage.getEmployees().
                stream().
                filter(employee ->employee.getRole() == Role.TEMPORARY).
                mapToDouble(o -> calculateTemporaryPay(o)).
                sum();
    }

    private double calculatePermanentPay(Employee employee) {
        return employee.getPay() - (employee.getPay() * employee.getTaxRate());
    }

    private double calculateTemporaryPay(Employee employee) {
        return employee.getPay() - (employee.getPay() * 0.3);
    }


}
