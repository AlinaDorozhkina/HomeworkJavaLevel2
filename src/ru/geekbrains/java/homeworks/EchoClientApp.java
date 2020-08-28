package ru.geekbrains.java.homeworks;

import javax.swing.*;

public class EchoClientApp {
    public static void main(String[] args) {
        new Client();
        /*SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });

         */
    }
}
    class ClientTwo {
        public static void main(String[] args) {
            new Client();

        }
    }
        class Client3{
            public static void main(String[] args) {
                new Client();

            }

    }
class Client4{
    public static void main(String[] args) {
        new Client();

    }

}


