package ru.netology.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FancyServer {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Fancy server started on port " + PORT);

            try (Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                out.println("Write your name");
                String name = in.readLine();
                System.out.println("Client name: " + name);

                out.println("Are you child? (yes/no)");
                String answer = in.readLine();
                System.out.println("Client answer: " + answer);

                if ("yes".equalsIgnoreCase(answer)) {
                    out.println("Welcome to the kids area, " + name + "! Let's play!");
                } else {
                    out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Fancy server error", e);
        }
    }
}
