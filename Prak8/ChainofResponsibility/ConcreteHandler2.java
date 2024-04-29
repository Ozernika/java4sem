package Prak8.ChainofResponsibility;

public class ConcreteHandler2 implements Handler {
    private Handler handler;

    @Override
    public void handleRequest(Handler handler) {
        this.handler = handler;
        System.out.println("Request is handling by ConcreteHandler2!");
    }
}
