package lesson12.messageApp;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Properties;
import java.util.Scanner;

public class MessageClient {
    SocketAddress address;
    private Scanner scanner;

    public MessageClient(SocketAddress address) {
        this.address = address;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        while (true) {
            System.out.println("Введите сообщение");
            String messageText = scanner.nextLine();
            try {
                buildAndSend(name, messageText);

            } catch (IOException e) {
                e.printStackTrace();
            }

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
    private void buildAndSend(String name, String messageText) throws IOException {
        Message message = new Message(name, messageText);
        Socket socket = new Socket();
        try {

            socket.connect(address);
            try (OutputStream out = socket.getOutputStream();
                 ObjectOutputStream objOut = new ObjectOutputStream(out)) {
                objOut.writeObject(message);
                objOut.flush();

            }

        } finally {
            if (socket != null)
                socket.close();
        }
    }

    public static void main(String[] args) {
        try (InputStream inputStream = MessageClient.class
                .getClassLoader()
                .getResourceAsStream("config.properties")){
            Properties properties = new Properties();
            properties.load(inputStream);
            String server = properties.getProperty("server");//"127.0.0.1";
            int port = Integer.parseInt(properties.getProperty("port"));//8090;
            MessageClient messageClient = new MessageClient(new InetSocketAddress(server, port));
            messageClient.start();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
