package my_chat.view;

import my_chat.controller.Client;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by dexter on 06.03.16.
 */
public class ClientFrame extends JFrame {

    private Client client;

    private JButton setConnection = new JButton("set connection");
    private JPanel connectionPanel = new JPanel();
    private JPanel textFieldsPanel = new JPanel();
    private JLabel ipLabel = new JLabel("set ip");
    private JTextField ipField = new JTextField(20);
    private JLabel portLabel = new JLabel("set port");
    private JTextField portField = new JTextField(20);
    private JButton connect = new JButton("connect");

    private JPanel messagePanel = new JPanel();
    private JScrollPane scrollPane;
    private JScrollPane scrollForMessageField;
    private JTextArea messageField = new JTextArea("Enter message...", 5, 25);
    private JTextPane messageLabel;
    private JButton sendMessage = new JButton("send");

    public ClientFrame(){
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dex Chat");
        setLocationRelativeTo(null);
        init();
    }

    private void init(){
        setLayout(new BorderLayout());

        textFieldsPanel.setLayout(new GridLayout(2, 2));
        textFieldsPanel.add(ipLabel);
        textFieldsPanel.add(portLabel);
        textFieldsPanel.add(ipField);
        textFieldsPanel.add(portField);

        connectionPanel.setLayout(new BorderLayout());
        connectionPanel.add(textFieldsPanel, BorderLayout.SOUTH);
        connectionPanel.add(connect, BorderLayout.NORTH);
        connectionPanel.setVisible(false);

        messagePanel.setLayout(new BorderLayout());
        scrollForMessageField = new JScrollPane(messageField);
        messagePanel.add(scrollForMessageField, BorderLayout.NORTH);
        messagePanel.add(sendMessage, BorderLayout.SOUTH);
        messagePanel.setVisible(false);

        add(connectionPanel, BorderLayout.CENTER);
        add(setConnection, BorderLayout.NORTH);
        add(messagePanel, BorderLayout.SOUTH);

        setConnection.addActionListener((e) ->{
            if(!connectionPanel.isVisible()){
                client = null;
                connectionPanel.setVisible(true);
                setConnection.setVisible(false);
                messagePanel.setVisible(false);
                messageLabel = new JTextPane();
                ClientFrame.this.add(connectionPanel, BorderLayout.CENTER);
            }
        });

        connect.addActionListener((e) -> {
            if(connectionPanel.isVisible()){
                try{

                    int port = Integer.parseInt(portField.getText());
                    client = new Client();
                    client.connect(ipField.getText(), port);
                    new MessageInput().start();

                    connectionPanel.setVisible(false);
                    setConnection.setVisible(true);
                    messagePanel.setVisible(true);
                    messageLabel = new JTextPane();
                    scrollPane = new JScrollPane(messageLabel);
                    ClientFrame.this.add(scrollPane, BorderLayout.CENTER);


                    JOptionPane.showMessageDialog(this,
                            client.getIp(),
                            "Connection complete",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(this,
                            "Wrong port",
                            "Connection error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex){
                    JOptionPane.showMessageDialog(this,
                            ex.getMessage(),
                            "Connection error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        sendMessage.addActionListener((e) ->{
            try {

                String line = messageField.getText();

                client.sendMessage(line);

                String newMessage = "I said : " + line + '\n';
                String oldMessages = messageLabel.getText();
                messageLabel.setText(oldMessages + newMessage);
                messageLabel.setEditable(false);

            } catch (IOException ex){
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Connection error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    private class MessageInput extends Thread{

        @Override
        public void run(){
            try (BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()))){

                while(true){
                    String line = br.readLine();
                    if(line == null) break;
                    String newMessage = "Server said : " + line + '\n';
                    String oldMessages = messageLabel.getText();
                    messageLabel.setText(oldMessages + newMessage);
                }

            } catch (IOException e){
                JOptionPane.showMessageDialog(ClientFrame.this, e.getMessage(),
                        "Connection error", JOptionPane.ERROR_MESSAGE);
            }
            JOptionPane.showMessageDialog(ClientFrame.this, "server break the connection",
                    "Connection error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
