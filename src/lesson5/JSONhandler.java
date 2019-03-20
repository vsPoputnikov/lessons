package lesson5;

public class JSONhandler implements Handler {
    @Override
    public void read() {
        System.out.println("JSON file read");
    }

    @Override
    public void write() {
        System.out.println("Json file write");
    }
}
