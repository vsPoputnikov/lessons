package messageApp;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MessageClient {
    private Scanner in = new Scanner(System.in);
    private Connection connection;
    private String name="";


    public MessageClient(Connection connection) {
        this.connection = connection;
    }

    public static void main(String[] args) {
        try {
            ( new MessageClient(new Connection(new Socket("127.0.0.1",8090)))).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        Thread reader = new Thread(new Reader(connection));
        reader.start();

        try {
            while (this.getName().equals("")) {
                System.out.println("введите имя");
                connection.sendMessage(new Message(in.nextLine(), "server", "login"));
                Thread.sleep(1000);
            }
            } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) {
            System.out.println("To:");
            String to = in.nextLine();
            System.out.println("введите сообщение");
            String mess = in.nextLine();
            if (mess != null) {
                Message message = new Message(name, to, mess);
                try {
                    connection.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
            while (!Thread.currentThread().isInterrupted()) {
                Message message = null;
                try {
                    message = connection.readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (message.getFrom().equals("server")) {
                    switch (message.getText()) {
                        case "correct login":
                            System.out.println("login accepted");
                            name = message.getTo();
                            break;
                        case "incorrect login":
                            System.out.println("login denied");
                            break;
                    }
                } else {
                    System.out.println(message);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
