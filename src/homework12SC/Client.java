package homework12SC;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost",3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())){
            System.out.println("client connected");
        }catch (Exception e){

        }
    }
}
