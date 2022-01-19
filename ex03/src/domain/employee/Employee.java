package domain.employee;


public class Employee {
    private String name;
    private int pay;
    private double taxRate;
    private Role role;

    public Employee(String name, int pay, Role role) {
        this(name, pay, 0, role);
    }
    public Employee(String name, int pay, double taxRate, Role role) {
        this.name = name;
        this.pay = pay;
        this.taxRate = taxRate;
        this.role = role;
    }


    public int getPay() {
        return pay;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public Role getRole() {
        return role;
    }
}
