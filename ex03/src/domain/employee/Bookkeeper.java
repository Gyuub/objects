package domain.employee;

import domain.calculator.Calculator;

import java.util.Arrays;
import java.util.List;

public class Bookkeeper {

    private EmployeeStorage employeeStorage;
    private List<Calculator> calculators;

    public Bookkeeper(EmployeeStorage employeeStorage, Calculator... calculator) {
        this.employeeStorage = employeeStorage;
        this.calculators = Arrays.asList(calculator);
    }

    public double getPay(Employee employee) {
        for (Calculator calculator : calculators) {
            if (calculator.isSatisfiedBy(employee.getRole())) {
                return calculator.calculatePay(employee);
            }
        }
        return 0;
    }

    public double getAllPay(Role role) {
        for (Calculator calculator : calculators) {
            if (calculator.isSatisfiedBy(role)) {
                return calculator.calculateAllPay(employeeStorage);
            }
        }
        return 0;
    }
}
