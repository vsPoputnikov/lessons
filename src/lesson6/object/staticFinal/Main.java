package lesson6.object.staticFinal;

public class Main {
    public static void main(String[] args) {
        String fileName = "file.json";

        Handler handler = Handler.getInstance(fileName);
        handler.read();
        handler.write();
    }
}
