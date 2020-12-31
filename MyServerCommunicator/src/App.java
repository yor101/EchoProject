import java.io.*;
import java.net.ServerSocket;

public class App {

    public static void main(String[] args) {




        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            while (true) {
                new ConnectionHandler(serverSocket.accept()).start();
                System.out.println("Client connected");
            }

        }catch (IOException e){
            System.out.println("Error server side " + e.getMessage());
        }

    }
}
