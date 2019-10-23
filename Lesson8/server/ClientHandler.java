package Lesson8.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClientHandler {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Main server;
    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Socket socket, Main server) {
        try {
            this.socket = socket;
            this.server = server;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/auth")) {
                                String[] tokens = str.split(" ");
                                String newNick = AuthService.getNickByLoginAndPass(tokens[1], tokens[2]);

                                if (newNick != null) {
                                    if (!server.isNickBusy(newNick)) {
                                        sendMsg("/authok");
                                        nick = newNick;
                                        server.subscribe(ClientHandler.this);
                                        ArrayList msgs = MessageService.getMessagesFromHistory();
                                        for (int i = 0; i < msgs.size() ; i++) {
                                            sendMsg((String) msgs.get(i));
                                        }
                                        break;
                                    } else {
                                        sendMsg("Учетная запись уже используется");
                                    }
                                } else {
                                    sendMsg("Неверный логин/пароль");
                                }
                            }
                        }

                        while (true) {
                            String str = in.readUTF();
                            if (str.startsWith("/")) {

                                if (str.equals("/end")) {
                                    out.writeUTF("/serverclosed");
                                    break;
                                }

                                if (str.startsWith("/w ")) { // /w nick3 lsdfhldf sdkfjhsdf wkerhwr
                                    String[] tokens = str.split(" ", 3);
                                    //if(tokens.length > 3) {
                                    //String m = str.substring(tokens[1].length() + 4);
                                    server.sendPersonalMsg(ClientHandler.this, tokens[1], tokens[2]);
                                }

                                if (str.startsWith("/blacklist ")) {
                                    String[] tokens = str.split(" ");
                                    if(nick.equals(tokens[1])){
                                        sendMsg("Себя нельзя заблокировать");
                                    }else{
                                        sendMsg(AuthService.addNickToBlackList(nick, tokens[1]));
                                    }
                                }

                            } else {
                                server.broadcastMsg(ClientHandler.this, nick, str);
                                try {
                                    MessageService.recordMessageInHistory(nick, str);
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
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
                    }
                    server.unsubscribe(ClientHandler.this);
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
