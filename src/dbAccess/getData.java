package dbAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getData {

    public static String getClassFeaturesDescription(String feature) {
        Connection conn = connectDB.getConnection();
        Statement stmt = null;
        String description = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT description FROM classfeatures WHERE name = '" + feature + "'");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    description = " " + rs.getObject(i);
                }
            }
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return description;
    }

    public static String getRaceFeatures(String race) {
        Connection conn = connectDB.getConnection();
        Statement stmt = null;
        String description = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT features FROM races WHERE name = '" + race + "'");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    description = " " + rs.getObject(i);
                }
            }
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return description;
    }

    public static String getRaceFeaturesDescription(String feature) {
        Connection conn = connectDB.getConnection();
        Statement stmt = null;
        String description = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT featdescription FROM racefeatures WHERE featname = '" + feature + "'");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    description = " " + rs.getObject(i);
                }
            }
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return description;
    }

    public static String getRacialASI(String race) {
        Connection conn = connectDB.getConnection();
        Statement stmt = null;
        String abilities = null;

        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT ASI FROM races WHERE name = '" + race + "'");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    abilities = " " + rs.getObject(i);
                }
            }
            rs.close();
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return abilities;
    }
}
