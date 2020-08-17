package ru.geekbrains.java.homeworks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    public static final int PORT=8081;
    private AuthService authService;

    private Set<ClientHandler> clientHandlers;

    public Server() {
        //try with resourses
        try ( ServerSocket serverSocket=new ServerSocket(PORT))// работет с closable объектами.Когда приложение закончится и мы выйдем из блока он все сам закроет
        {
            authService=new BasicAuthService();
            System.out.println("Auth is started up");

            clientHandlers=new HashSet<>();
            while (true){
                System.out.println("Waiting for connection..");
                Socket socket=serverSocket.accept();
                System.out.println("Client is connected "+socket);
                new ClientHandler(this, socket);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isOccupied (AuthService.Record record){
        for (ClientHandler ch:clientHandlers){
            if (ch.getRecord().equals(record)){
                return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler ch){
        clientHandlers.add(ch);

    }
    public synchronized void unsubscribe(ClientHandler ch){
        clientHandlers.remove(ch);
    }

    public synchronized void broadCast(String message){
        for (ClientHandler ch: clientHandlers){
            ch.sendMessage(message);
        }
    }

}
