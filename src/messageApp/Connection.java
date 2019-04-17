package messageApp;

import java.io.*;
import java.net.Socket;

public class Connection {
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out =new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    public void sendMessage(Message message) throws IOException {
        out.writeObject(message);
        out.flush();
    }

    public Message readMessage() throws IOException, ClassNotFoundException {
        return (Message) in.readObject();
    }

}
