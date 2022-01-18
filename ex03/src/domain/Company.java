package domain;

import domain.employee.Employee;
import domain.employee.Role;
import domain.pay.Bookkeeper;

public class Company {
    private String name;
    private Bookkeeper bookkeeper;

    public Company(String name, Bookkeeper bookkeeper) {
        this.name = name;
        this.bookkeeper = bookkeeper;
    }

    public double informAllPay(Role role){
        return bookkeeper.getAllPay(role);
    }

    public double informPay(Employee employee){
        return bookkeeper.getPay(employee);
    }
}
