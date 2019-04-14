package patterns.command;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class TextProcessor {
    public static void main(String[] args) {
        TextProcessor processor = new TextProcessor();
        processor.start();
    }



    private CommandHistory history = new CommandHistory();

    public void executeCommand(Command command) {
        if (command.execute()) {
            history.add(command);
        }
    }

public void start(){
    Scanner scanner = new Scanner(System.in);
        while(true){
            // можно заменить на фабричный метод
            switch (scanner.nextLine()){
                case "process":
                    executeCommand(new ProcessCommand());
                    break;
                case "exit":
                    executeCommand(new ExitCommand());
                    break;
            }
        }

}
// фабричный метод
private Command getInstance(String command){
   Command command1 = null;
   if ("process".equals(command)){
       command1 = new ProcessCommand();
   } else if("exit".equals(command)){
       command1 = new ExitCommand();
   }
   return command1;
}
}

class CommandHistory {
    private Stack<Command> history = new Stack<>();

    public void add(Command command) {
        history.push(command);
    }

    public Command delete() {
        return history.pop();
    }

    public boolean isEmpty() {
        return history.isEmpty();
    }
}