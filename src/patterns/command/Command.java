package patterns.command;

public abstract class Command {
    abstract String name();
    abstract  boolean execute();

    public Command() {
    }

    protected TextProcessor processor;
    public Command(TextProcessor processor){
        this.processor = processor;
    }
}


