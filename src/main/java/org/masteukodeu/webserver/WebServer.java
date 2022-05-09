package org.masteukodeu.webserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

public class WebServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);

        while (true) {
            try (Socket socket = serverSocket.accept()) {
                System.out.println("New connection " + LocalDateTime.now());
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true, StandardCharsets.UTF_8);
                writer.println("HTTP/1.1 200");
                writer.println();
                writer.println("<h1>Hello World!</h1>");
            }

        }
    }
}
