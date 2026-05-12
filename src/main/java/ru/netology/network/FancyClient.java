package ru.netology.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FancyClient {
    private static final String HOST = "netology.homework";
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String question = in.readLine();
            System.out.println(question);
            out.println("Taras");

            question = in.readLine();
            System.out.println(question);
            out.println("no");

            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException("Fancy client error", e);
        }
    }
}
