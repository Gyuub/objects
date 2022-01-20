package domain;

public class Calculator {

    public double getFee(Phone phone){
        return calculator(phone);
    }

    private double calculator(Phone phone){
        return phone.getCalls().stream().
                mapToDouble(each -> each.getDuration().getSeconds()/10 * 5 ).
                sum();
    }


}
