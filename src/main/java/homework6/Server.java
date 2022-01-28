package homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner scanner = new Scanner(System.in);


    public Server() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Подключение клиента...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключен");
            System.out.println("ВВедите сообщение");

            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void messagesReadAndSend() throws IOException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        String clientMessage = in.readUTF();

                        if (clientMessage.equals("/end")) closeConnection();

                        System.out.println(" " + clientMessage);
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {

                        String serverInput = scanner.nextLine();

                        if (serverInput.equals("/end")) closeConnection();

                        out.writeUTF(serverInput);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    void closeConnection() {

        System.out.println("Сеанс окончен");

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }

    public static void main(String[] args) {

        Server server = new Server();

        try {

            server.messagesReadAndSend();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}


