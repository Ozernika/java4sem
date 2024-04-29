package Prak8.ChainofResponsibility;

public interface Handler {
    void handleRequest(Handler handler);
}

