package patterns.command;

public class ExitCommand extends Command {
    @Override
    String name() {
        return null;
    }

    @Override
    boolean execute() {
        // реализация выхода из программы
        System.out.println( " Выход из программы");
        return true;
    }
}
