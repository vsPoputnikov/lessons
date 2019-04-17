package multithreading.messageApp;

import java.net.Socket;
import java.util.Scanner;

public class MessageClient {
    public static void main(String[] args) {
        try {
            MessageClient client = new MessageClient(new Connection(new Socket("127.0.0.1", 8090)));
            client.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Scanner in = new Scanner(System.in);
    private Connection connection;

    public MessageClient(Connection connection) {
        this.connection = connection;
    }

    public void start() throws Exception {
        System.out.println("Введите имя");
        String name = in.nextLine();

        Thread reader = new Thread(new Reader(connection));
        reader.start();

        System.out.println("введите сообщение");
        while (true) {
            String mess = in.nextLine();
            if (mess != null) {
                Message message = new Message(mess, name);
                connection.sendMessage(message);
            }
        }

    }


    private class Reader implements Runnable {
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Message message = connection.readMessage();
                    System.out.println(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
