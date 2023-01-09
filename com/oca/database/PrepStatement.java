package com.oca.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepStatement {

    // SELECT - executeQuery
    public static ResultSet select(String sql) {
        try (PreparedStatement ps = DerbyConnection.connect().prepareStatement(sql);) {
            return ps.executeQuery();
        } catch (SQLException e) {}
        return null;
    }

    public static void main(String[] args) {
        String sql = "SELECT * FROM CHOUDENJI_MACHINES";
        System.out.println(PrepStatement.select(sql));
    }


}
