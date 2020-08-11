package ru.geekbrains.java.homeworks;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    private ServerSocket server;
    private Socket socket;

    public Server() {

        try {
            server = new ServerSocket(7777);
            System.out.println("Server is working...");
            socket = server.accept();
            System.out.println("New Client is connected " + socket.getLocalSocketAddress());
            Scanner in = new Scanner(socket.getInputStream());

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);


            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        String msg = sc.nextLine();
                        out.println(msg);
                    }
                }
            }).start();

            while (true) {
                String msg = in.nextLine();
                if (msg.equalsIgnoreCase("/end")){
                    break;
                }
                System.out.println("Client: " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
                System.out.println("Server is  closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        }
    }
