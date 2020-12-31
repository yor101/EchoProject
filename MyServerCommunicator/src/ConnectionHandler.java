import java.io.*;
import java.net.Socket;
import java.util.function.DoubleToIntFunction;

public class ConnectionHandler extends Thread{

    private Socket socket;

    public ConnectionHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            while (true) {
                String echo = input.readLine();
                System.out.println("recived client input " + echo + "\n" + socket.getInetAddress());
                if (echo.equals("exit")) {
                    break;
                }
                out.println(echo);
            }
        } catch (IOException e) {
            System.out.println("oops " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("..." + e.getMessage());
            }
        }
    }
}
