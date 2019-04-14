package homework12SC;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
private int port = 8090;
Connection connection;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(3345)){
            System.out.println("server up");
            Socket client = serverSocket.accept();
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());

            while (!client.isClosed()){
                System.out.println("Server reading from chanell");

                String entry = in.readUTF();

                if(entry.equals("quit")){
                    out.flush();
                    break;
                }
                out.writeUTF("server reply: "+ entry);
                System.out.println("server replies");
                out.flush();
            }

            System.out.println("disconected");
            in.close();
            out.close();
            client.close();






        }catch (Exception e){}
    }
}
