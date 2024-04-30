package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketConnection {

    public void fetchDataFromServer() {
        try {
            // Connect to the server
            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("localhost", 8081));

            // Send request to the server
            String requestKey = "all_student_data";
            ByteBuffer requestBuffer = ByteBuffer.wrap(requestKey.getBytes());
            socketChannel.write(requestBuffer);

//            // Receive response from the server
//            ByteBuffer responseBuffer = ByteBuffer.allocate(1024);
//            socketChannel.read(responseBuffer);
//            responseBuffer.flip();
//            byte[] responseData = new byte[responseBuffer.limit()];
//            responseBuffer.get(responseData);
//            String response = new String(responseData);

            // Print the response received from the server
//            System.out.println("Response from server: " + response);

            // Close the connection
//            socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






//import java.io.*;
//import java.net.*;
//
//public class SocketConnection {
//  private static final String HOST = "localhost";
//  private static final int PORT = 8080;
//  
//  public static void main(String[] args) throws Exception {
//    Socket socket = new Socket(HOST, PORT);
//    OutputStream outputStream = socket.getOutputStream();
//    PrintWriter writer = new PrintWriter(outputStream, true);
//    
//    writer.write("Hello, Server"); 
//    writer.flush();
//InputStream inputStream = socket.getInputStream();
//BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//String line;
//
//while ((line = reader.readLine()) != null) {
//  System.out.println(line);
//}
//
//socket.close();
//}
//}