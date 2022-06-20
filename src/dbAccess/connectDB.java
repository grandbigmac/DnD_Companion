package dbAccess;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class connectDB {

    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:dnd_companion.db";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("connected");
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
