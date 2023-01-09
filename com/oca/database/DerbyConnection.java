package com.oca.database;

import java.sql.*;

public class DerbyConnection {
    private static Connection conn;
    private static final String URL = "jdbc:derby:voltesvdb";

    public static Connection connect() {
        try {
            if (conn == null) conn = DriverManager.getConnection(URL);
        } catch (SQLException e) {}
        return conn;
    }

    public static void disconnect() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {}
        conn = null;
    }

    public static void main(String[] args) throws SQLException {
        System.out.print(DerbyConnection.connect());  //org.apache.derby.impl.jdbc.EmbedConnection@1373419525 (XID = 349), (SESSIONID = 1), (DATABASE = voltesvdb), (DRDAID = null)
        DerbyConnection.disconnect();
    }
}
