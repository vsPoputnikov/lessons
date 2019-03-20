package lesson5;

public class XMLhandler implements Handler {
    @Override
    public void read() {
        System.out.println("XML file read");
    }

    @Override
    public void write() {
        System.out.println("XML file write");
    }
}
