package ru.geekbrains.java.homeworks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class Chat extends JFrame {

    public JTextArea textArea;
    public JTextField textField;
    private DataInputStream in;
    private DataOutputStream out;
    public  JTextArea online;



    public Chat(DataInputStream in, DataOutputStream out) {

        this.in=in;
        this.out=out;
        setTitle("chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 600);




        JPanel jpanel = new JPanel(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setForeground(new Color(29, 106, 4));
        textArea.setFont(new Font("Verdana", Font.ITALIC, 18));
        textArea.setBackground(new Color(209, 231, 188));
        JScrollPane scroll = new JScrollPane(textArea);
        jpanel.add(scroll);

        online=new JTextArea("Users are online");
        online.setEditable(false);
        jpanel.add(online, BorderLayout.EAST);


        add(jpanel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(new Dimension(50, 50));
        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            private StringBuilder sb = new StringBuilder();

            @Override
            public void actionPerformed(ActionEvent e) {
                if (textField.getText().isBlank()) {
                    return;
                }
                sb.append(textArea.getText()).append("\n").append(textField.getText());
                textArea.setText(sb.toString());
                textField.setText("");
                sb.setLength(0);
            }
        });


        panel.add(textField);


        JButton sendButton = new JButton("SEND");
        sendButton.setBackground(new Color(118, 227, 73));
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sb = new StringBuilder();
                if (textField.getText().isBlank()) {
                    return;
                }
                sb.append(textArea.getText()).append("\n").append(textField.getText());
                textArea.setText(sb.toString());
                textField.setText("");
                sb.setLength(0);
            }
        });

        panel.add(sendButton, BorderLayout.EAST);

        add(panel, BorderLayout.SOUTH);


        setVisible(true);
    }
}
