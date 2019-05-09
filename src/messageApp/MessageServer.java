package messageApp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer {
    private int port;
    private ArrayList<Connection> connections = new ArrayList<>();
    private HashMap<String,Connection> userConnections = new HashMap<>();
    private BlockingDeque<Message> messages = new LinkedBlockingDeque<>();

    public MessageServer(int port){
        this.port = port;
    }

    public static void main(String[] args) {
        MessageServer server = new MessageServer(8090);
        server.start();
    }

    public void start(){
        new Thread(new Writer()).start();
        try(ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Server started");
            while(true) {
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
                connections.add(connection);
                new Thread(new Reader(connection)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private class Reader implements Runnable{
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                Message message = null;
                try {
                    message = connection.readMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("on fire");
                } catch (ClassNotFoundException e) {

                    e.printStackTrace();
                }
                if (message.getTo().equals("server")) {

                    switch (message.getText()) {
                        case "login":
                            if(!userConnections.containsKey(message.getFrom())){
                                messages.add(new Message("server",message.getFrom(),"correct login"));
                                userConnections.put(message.getFrom(),connection);
                                connections.remove(connection);
                            }else{
                                messages.add(new Message("server","","incorrect login"));
                            }

                            break;

                    }
                } else {
                    System.out.println("on fire 2");
                    messages.add(message);
                }
            }
        }
    }

    private class Writer implements Runnable{

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()){
                Message message = null;
                try {
                    message = messages.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (message.getTo().equals("")) {
                    for (Connection connection : connections) {
                        try {
                            connection.sendMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                messages.remove(message);
                } else {
                    try {
                        userConnections.get(message.getTo()).sendMessage(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    messages.remove(message);
                }
            }
        }
    }

}
