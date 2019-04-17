package multithreading.messageApp;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Set;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

public class MessageServer {
    private  int port;

    private Set<Connection> connections = new CopyOnWriteArraySet<>();
    private BlockingDeque<Message> messages = new LinkedBlockingDeque<>();

    public static void main(String[] args) {
        MessageServer server = new MessageServer(8090);
        server.start();
    }

    public MessageServer(int port) {
        this.port = port;
    }

    public void start(){
        new Thread(new Writer()).start();
        try (ServerSocket serverSocket = new ServerSocket(port);
        ){
            System.out.println("server started");
            while(true){
                Socket socket = serverSocket.accept();
                Connection connection = new Connection(socket);
                connections.add(connection);
                new Thread(new Reader(connection)).start();
            }
        }catch (Exception e){}

    }

    private class Writer implements Runnable{
        @Override
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    Message message = messages.take();
                    for (Connection connection: connections){
                        connection.sendMessage(message);

                    }
                    messages.remove(message);
                }


            }catch (Exception e){}
        }
    }

    private class Reader implements Runnable{
        private Connection connection;

        public Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Message message = connection.readMessage();
                    messages.add(message);
                } catch (Exception e){}
                }
        }
    }
}
