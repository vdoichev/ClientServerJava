import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            OutputStreamWriter writer = new OutputStreamWriter(clientSocket.getOutputStream());

            String request = reader.readLine();
            System.out.println(request);
            String response = "#" + count + ", your message length is " + request.length() + "\n";
            writer.write(response);
//            writer.write("HTTP/1.0 200 ok\n" +
//                    "Content-type: text/html\n" +"\n" +
//                    "<h1>JAVA<h1>\n");
            writer.flush();
            writer.close();
            reader.close();
            clientSocket.close();
        }
    }
}