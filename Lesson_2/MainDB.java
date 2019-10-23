package Java_Prof_Level.Lesson_2;

import java.sql.*;

public class MainDB {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public static void main(String[] args) throws SQLException {
        try {
            connect();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        getDataDB();
//        dropTable();
//        createTable();
        addElementsInTable();
        close();

    }

    public static void getDataDB() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        while (rs.next()){
            System.out.println(rs.getInt(1) + rs.getString("name"));
        }
    }

    public static void dropTable() throws SQLException {
        stmt.execute("DROP TABLE IF EXISTS citizens");
    }

    public static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE citizens (" +
                "id INTEGER  PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "score INT)");
    }

    public static void addElementsInTable() throws SQLException {

//        connection.setAutoCommit(false);
//
//        for (int i = 0; i < 1000; i++) {
//            String res = "Bob" + i;
//            stmt.executeUpdate(String.format("INSERT INTO citizens (name, score)\n" +
//                    "VALUES ('%s', %d)", res, i));
//        }
//
//        connection.setAutoCommit(true);

        pstmt = connection.prepareStatement("INSERT INTO citizens (name, score) VALUES (?, ?)");
        pstmt.setString(1, "Bob");
        pstmt.setInt(2,100);
        pstmt.execute();

    }

    public static void connect()  throws SQLException, ClassNotFoundException {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:maintest.db");
            stmt = connection.createStatement();
    }

    private static void close() throws SQLException{
        connection.close();
    }
}
