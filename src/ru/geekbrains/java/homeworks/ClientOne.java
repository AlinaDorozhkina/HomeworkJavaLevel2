package ru.geekbrains.java.homeworks;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class ClientOne {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", Server.PORT);
        System.out.println("Connected " + socket);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String message = in.readUTF();
                        if (message.startsWith("/authok")) {
                            System.out.println("Authorized");
                            break;
                        }
                    }

                    Chat chat = new Chat(in, out);


                    while (true) {
                        String message ;
                        message = in.readUTF();
                        if (message.equals("/end")) {
                            System.out.println("Selection is closed");
                            break;

                        }

                        System.out.println(message);
                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();



    }
}
