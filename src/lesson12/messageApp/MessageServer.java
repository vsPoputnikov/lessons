package lesson12.messageApp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MessageServer {
    private int port;

    public MessageServer(int port) {
        this.port = port;
    }



    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started...");
            while (true) {
                Socket socket = serverSocket.accept();

                try {
                    getMessage(socket);
                    sendMessage(socket);



                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void sendMessage(Socket socket){
        Message message = new Message("server", "accepted");
        try (ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream())){
            out.writeObject(message);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private boolean getMessage(Socket socket)throws IOException, ClassNotFoundException{
        try(ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream())) {
            Object obj = objIn.readObject();
            printMessage((Message)obj);
            return true;
        }
    }

    private void printMessage(Message message) {
        System.out.println("получено сообщение"+ message.getMessageText()+ " от "+ message.getSender());
    }
// TCP protocol
    public static void main(String[] args) {
        int port = 8090;
        MessageServer messageServer = new MessageServer(port);
        try {
            messageServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
