import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client accepted #" + (++count));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());
            writer.write("Client accepted #" + count);
//            writer.write("HTTP/1.0 200 ok\n" +
//                    "Content-type: text/html\n" +"\n" +
//                    "<h1>JAVA<h1>\n");
            writer.flush();
            writer.close();
            clientSocket.close();
        }
    }
}