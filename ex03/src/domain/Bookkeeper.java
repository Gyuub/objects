package domain;

public class Bookkeeper {

    public double calculateStipend(Employee employee){
        return getStipend(employee);
    }

    private double getStipend(Employee employee){
        return employee.getStipend() - ( employee.getStipend() * employee.getTaxRate() );
    }


}
