package bad.domain;

public class Audience {

    private bad.domain.Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }
}
