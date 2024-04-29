package Prak8.Command;

public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }
}

