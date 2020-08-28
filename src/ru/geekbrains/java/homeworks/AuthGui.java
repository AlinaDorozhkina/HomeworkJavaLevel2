package ru.geekbrains.java.homeworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthGui extends JFrame {
        //private BaseAuthService bas;
        private MyServer server;
        private JTextField log_text;
        private JPasswordField password_text;
        JPasswordField passwordForReg;
         JTextField loginForReg;
        private JLabel message;
        JLabel message_reg;
        private JLabel name;
        private boolean isConnected;
        private AuthService.Record possibleRecord;

        public AuthGui(MyServer server) {
            this.server = server;
            setBounds(100, 100, 500, 200);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            JLabel greet = new JLabel("Welcome to chat. Login or register.");
            greet.setFont(new Font("Verdana", Font.ITALIC, 18));
            add(greet, BorderLayout.NORTH);

            JPanel mainPanel = new JPanel(new GridLayout(0,2));
           // add (mainPanel);






            JPanel logPanel = new JPanel(new GridLayout(3, 1));//(new GridLayout(3, 1));
            logPanel.setBackground(new Color(180, 208, 210));
            //add(logPanel);

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

            //mainPanel.add(logPanel);
            logPanel.add(login);
            logPanel.add(log_text);
            logPanel.add(password);
            logPanel.add(password_text);
            logPanel.add(message);
            logPanel.add(log_button);

            JPanel regPanel = new JPanel(new GridLayout(0,2));
            regPanel.setBackground(new Color(114, 160, 165));
            name = new JLabel("Name");
            JTextField name_=new JTextField();
            JLabel login1 = new JLabel("Login");
            loginForReg=new JTextField();
            JLabel password1 = new JLabel("Password");
            passwordForReg=new JPasswordField();
            message_reg = new JLabel();
            JButton reg_button = new JButton("Reg");
            reg_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    register();
                }
            });


            //mainPanel.add(regPanel);
            regPanel.add(name);
            regPanel.add(name_);
            regPanel.add(login1);
            regPanel.add(loginForReg);
            regPanel.add(password1);
            regPanel.add(passwordForReg);
            regPanel.add(message_reg);
            regPanel.add(reg_button);

            mainPanel.add(logPanel);
            mainPanel.add(regPanel);
            add(mainPanel, BorderLayout.CENTER);


            setVisible(true);
            while (!isConnected)
                Thread.onSpinWait();
            dispose();

        }

        public AuthService.Record getPossibleRecord() {
            return possibleRecord;
        }

        private void authorize() {
            possibleRecord = server.getAuthService().findRecord(log_text.getText(), password_text.getText());
            if (possibleRecord != null) {
                if (server.isOccupied(possibleRecord)) {
                    message.setForeground(Color.RED);
                    message.setText("User is exist");

                } else {
                    message.setText("Auth ok");
                    isConnected = true;
                }

            } else {
                message.setText("User no found");
                password_text.setText(null);
            }
        }

        private void register (){

            if (server.getAuthService().isLoginFree(loginForReg.getText())){
                server.getAuthService().addRecord(name.getText(), loginForReg.getText(), passwordForReg.getText());
                message_reg.setForeground(Color.GREEN);
               message_reg.setText("Auth ok");
                isConnected=true;
            } else {
                message_reg.setForeground(Color.RED);
                message_reg.setText("Login is occupied");
            }



        }
    }