package domain.pay;

import domain.employee.Employee;
import domain.employee.EmployeeStorage;
import domain.employee.Role;

public class Bookkeeper {

    private EmployeeStorage employeeStorage;
    private Calculator calculator;

    public Bookkeeper(EmployeeStorage employeeStorage) {
        this(employeeStorage, new Calculator());
    }

    public Bookkeeper(EmployeeStorage employeeStorage, Calculator calculator) {
        this.employeeStorage = employeeStorage;
        this.calculator = calculator;
    }

    public double getPay(Employee employee){
        return calculator.calculatePay(employee);
    }

    public double getAllPay(Role role){
        return calculator.calculateAllPay(employeeStorage, role);
    }






}
