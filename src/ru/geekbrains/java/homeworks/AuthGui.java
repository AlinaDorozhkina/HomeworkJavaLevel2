package ru.geekbrains.java.homeworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AuthGui extends JFrame {
    private Server server;
    private JTextField log_text;
    JPasswordField password_text;
    private JLabel message;
    private boolean isConnected;
    private AuthService.Record possibleRecord;




    public AuthGui(Server server){
        this.server=server;
        setBounds(100, 100, 500, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel greet = new JLabel("Welcome to chat. Login or register.");
        greet.setFont(new Font("Verdana", Font.ITALIC, 18));
        add(greet, BorderLayout.NORTH);




        JPanel logPanel = new JPanel(new GridLayout(3, 1));
        logPanel.setBackground(new Color(180, 208, 210));
        add(logPanel);

        JLabel login = new JLabel("Login");
        log_text = new JTextField();
        JLabel password = new JLabel("Password");
        password_text = new JPasswordField();

       message = new JLabel();

        JButton log_button = new JButton("Submit");

        log_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authorize();

            }
        });


        logPanel.add(login);
        logPanel.add(log_text);
        logPanel.add(password);
        logPanel.add(password_text);
        logPanel.add(message);
        logPanel.add(log_button);


        setVisible(true);
        while (!isConnected)
            Thread.onSpinWait();
        dispose();

    }
    public AuthService.Record getPossibleRecord() {
        return possibleRecord;
    }

    private void authorize(){
        possibleRecord=server.getAuthService().findRecord(log_text.getText(), password_text.getText());
        if (possibleRecord != null) {
            if (server.isOccupied(possibleRecord)){
                message.setText("User is occupied");

            } else {
                message.setText("Auth ok");
                isConnected=true;
            }

        } else {
            message.setText("User no found");
        }
    }





}
