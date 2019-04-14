package patterns.command;

public class ProcessCommand extends Command {
    @Override
    String name() {
        return "ProcessCommand";
    }

    @Override
    boolean execute() {
        // реализация добавления пакета пользовательских данных
        System.out.println("реализация метода ProcessCommand");
        return true;
    }
}
