package domain;

public class Company {
    Bookkeeper bookkeeper;

    public Company(Bookkeeper bookkeeper) {
        this.bookkeeper = bookkeeper;
    }

    public double requestStipend(Employee employee){
        return bookkeeper.calculateStipend(employee);
    }
}
