package Lesson8.server;

import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MessageService {

    private static PreparedStatement pstmt;

    public static void recordMessageInHistory(String fromNick, String msg) throws SQLException {
        String currentTime =  getCurrentTimeStamp();

        pstmt = AuthService.getConnection().prepareStatement("INSERT INTO messagehistory (nickname, message, time) " +
                        "VALUES (?, ?, ?)");
        pstmt.setString(1, fromNick);
        pstmt.setString(2, msg);
        pstmt.setString(3, currentTime);

        pstmt.execute();
    }

    public static ArrayList getMessagesFromHistory(){
        String str;
        String sql = String.format("SELECT * FROM messagehistory");
        ArrayList messagesArrayList = new ArrayList();

        try {
            ResultSet rs = AuthService.getStmt().executeQuery(sql);

            while (rs.next()) {
                Message message = new Message();
                message.setNick(rs.getString(1));
                message.setMsg(rs.getString(2));
                message.setTime(rs.getString(3));
                str = message.toString();
                messagesArrayList.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messagesArrayList;
    }

    private static String getCurrentTimeStamp(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

}
