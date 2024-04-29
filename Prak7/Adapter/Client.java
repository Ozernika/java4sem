package Prak7.Adapter;

public class Client {
    public static void main(String[] args) {

        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request();
    }
}

