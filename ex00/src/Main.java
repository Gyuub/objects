public class Main {
    public static void main(String[] args) {
        Tiger tiger = new Tiger(new Animal(), "타이거");
        System.out.println(tiger.name);
        System.out.println(tiger.animal.name);
    }
}
