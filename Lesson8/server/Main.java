package Lesson8.server;

import Lesson8.server.AuthService;
import org.apache.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    private Vector<ClientHandler> clients;
    static Logger file = Logger.getLogger("file");

    public Main() {



//        file.info("INFO");
//        file.warn("WARNING");
//        file.error("ERROR");
//        file.fatal("FATAL ERROR");


        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            AuthService.connection();
//            MessageService.connection();
//            String str1 = AuthService.setNewUsers(1,"login1", "pass1", "nick1");
//            System.out.println(str);
            server = new ServerSocket(8189);
            System.out.println("Сервер запущен");
            file.info("Сервер запущен");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
                file.info("Клиент подлючился");
                new ClientHandler(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
            file.error("Ошибка подключения!");

        } finally {
            try {
                socket.close();
                file.info("Клиент отключился");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
                file.info("Сервер отключился");
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
//            MessageService.disconnect();
        }
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nick)) {
                return true;
            }
        }
        return false;
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientList();
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientList();
    }

    public void broadcastMsg(ClientHandler from, String nick, String msg) {

        for (ClientHandler o : clients) {
            if(o.getNick().equals(from.getNick())){
                o.sendMsg("*" + msg);  // служебный символ "*", который вставляется в "свое" сообщение
                file.info("Клиент " + nick + " прислал команду: " + msg);
            }else{
                if(!AuthService.isNickInBlackList(o.getNick(), from.getNick())){
                    o.sendMsg(nick + ": " + msg);
                    file.info("Клиент " + nick + " прислал сообщение: " + msg);
                }
            }
        }
    }

    public void sendPersonalMsg(ClientHandler from, String nickTo, String msg) {
        for (ClientHandler o : clients) {
            if (o.getNick().equals(nickTo) && !AuthService.isNickInBlackList(nickTo, from.getNick())) {
                o.sendMsg("from " + from.getNick() + ": " + msg);
                from.sendMsg("to " + nickTo + ": " + msg);
                return;
            }
        }
        from.sendMsg("Клиент с ником " + nickTo + " не найден в чате");
    }

    public void broadcastClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("/clientlist ");
        for (ClientHandler o : clients) {
            sb.append(o.getNick() + " ");
        }

        String out = sb.toString();

        for (ClientHandler o : clients) {
            o.sendMsg(out);
        }
    }
}
