package Prak8.ChainofResponsibility;

public class Client {
    public static void main(String[] args) {

        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.handleRequest(handler1);
        handler2.handleRequest(handler2);
    }
}

